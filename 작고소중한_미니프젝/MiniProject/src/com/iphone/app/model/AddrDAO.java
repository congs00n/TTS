package com.iphone.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.iphone.app.view.AddrMain;

/*
 * 이 클래스는 데이터 조작 서비스를 담당(dao)합니다.
 * 상수가 아니라 사용자가 입력한 값을 통해 조작합니다.
 * 조작된 데이터의 결과를 AddVO클래스에 전달합니다.   
 */

public class AddrDAO {
	/*================================================> 선언부 !!!*/
			Connection con = null;
			Statement st = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
	
			AddrVO addrvo = null;
			/*드라이버도 문자열이 반복되므로 전역변수화 시켜서 올려줍니다.
			 * 이는 드라이버가 바뀌었을 때 쉽게 변경할 수 있도록 합니다. --> DB담당 클래스를 만들기  */
			private String driver = "oracle.jdbc.driver.OracleDriver";
			private String url = "jdbc:oracle:thin:@localhost:1521/xe";
			private String uid = "CRUD";
			private String pwd = "tiger";
			
	/*================================================> DB연결 관련 !!!*/
			/*이 클래스를 외부에서 생성하면 
			 * 자동으로 연결과 연결해제를 할 수 있도록 생성합니다.*/
			public AddrDAO() {
				connect();
				disconnect();
			}
			
			/* 연결 메소드 */ 
			void connect() {
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, uid, pwd);
				}catch(ClassNotFoundException e) {
					System.out.println(e + "=> 로드 fail");
				}
				catch(SQLException e) {
					System.out.println(e + "=> 연결 fail");
				}
				
			}
			
			/* 연결 해제 및 닫기 메소드*/
			void disconnect() {
			try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(pstmt != null) pstmt.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	/*========서비스에 대한 개요입니다 =========
	 * (*) 서비스 구성 
	 * (1) 전체 조회(새로고침, name) -> 0
	 * (2) 상세 조회 -> 0
	 * (3) 검색 -> 0
	 * (4) 등록 -> 0 
	 * (5) 수정
	 * (6) 삭제 
	 =============================*/
		
	
	/*====> 서비스 시작! */
			
			/* (1) 전체 조회(새로 고침)===============================
			 * 연락처 메인 페이지에서 새로고침 버튼을 누르면 
			 * 데이터의 Info_name만 dtm에 담아주는 기능을 담당합니다.
			 * ㄱ, ㄴ, ㄷ 순으로 담아 줍니다. 
			 *============================================*/
			public void getDBName(){
				AddrMain mainUI = new AddrMain();
				connect();
				String sql = "SELECT name FROM addressbook";
				try {
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						// DB에서 받아온 데이터 한 줄씩 더해줍니다. 
						String name = rs.getString("name");
						// DB에
						Object namedatas[] = {name};
						mainUI.getDtm().addRow(namedatas);
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					disconnect();
				}
			}
		
			/* (2-1) 상세조회 - ^인덱스^===============================  
			 *  mouseClicked이 감지된 name레코드를 받아서
			 *  그에 해당하는 id번호를  얻습니다. 
			 *  -> SELECT id FROM addressbook WHERE name = ?
			 *  =============================================*/
			public int selectID(String name) {
//				AddrMain mainUI = new AddrMain();
				connect();
				int id = 0;
				// 클릭된 name레코드에 해당하는 id 번호를 조회해 주세요. 
				String sql = "SELECT id FROM addressbook WHERE name ='"+name+"'";
				try {
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					// name이 잘 전달되는지 확인할 출력입니다. 
					System.out.println(name);
					while(rs.next()) {
						// 결과 객체에 데이터가 존재하는 동안 
						//  그 값을 id에 담아주세요. 
						id  = rs.getInt("id");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					disconnect();
				}
				return id;
			}
			
			/* (2 -2) 상세조회 - ^모든 레코드^
			 * 	 id번호에 해당하는 모든 레코드의 정보를 리턴합니다.
			 *  -> SELECT name, address, telephone, gender, relationship, birthday, comments
			 *  	FROM addressbook WHERE name = ?
			 */
			public AddrVO selectAll(int id) {
				AddrVO addrvo = null;
				connect();
				String sql = "SELECT id, name, address, telephone, gender, relationship, birthday, comments FROM addressbook WHERE id=?";
				
				try {
					pstmt= con.prepareStatement(sql);
					pstmt.setInt(1, id);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						addrvo = new AddrVO();
						addrvo.setId(rs.getInt("id"));
						addrvo.setName(rs.getString("name"));
						addrvo.setAddress(rs.getString("address"));
						addrvo.setTelephone(rs.getString("telephone"));
						addrvo.setGender(rs.getString("gender"));
						addrvo.setRelationship(rs.getString("relationship"));
						addrvo.setBirthday(rs.getString("Birthday"));
						addrvo.setComments(rs.getString("Comments"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					disconnect();
				}
				return addrvo;
			}
			
			/* (3) 검색==========================================
			 * 
			 * 연락처 메인 페이지에서 새로고침(jbtn_search)을 누르면 
			 * 데이터의 name 만 dtm 에 담아주는 서비스를 담당합니다. 
			 * 메인의 검색창에 사용자의 이름에 들어가는 문자를 입력하면 ( = ?) 
			 * 그 문자가 들어가는 이름을 메인의 테이블에 띄워줄 것입니다. 
			 * 후에 그 테이블 더블클릭해서 상세조회 할 수 있도록 구현할 예정 
			 * 참고사이트 : https://mainichibenkyo.tistory.com/87
			 * 사용자는 이름으로 검색할 것이므로, 텍스트필드의 이름을 넘겨받을 것입니다. 
			 *==========================================*/
			public void searchDBName(DefaultTableModel mainDtm, JTextField searchTF) {
				// 데이터베이스에 연결합니다. 
				connect();
				String sql = " SELECT name FROM addressbook WHERE name LIKE '%"+searchTF.getText().trim()+"%' ";
				
				try {
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						// ui의 검색 텍스트필드에서 사용자가 입력한 값을 받아옵니다.
						// 완성된 쿼리를 수행 후 결과값을 받아올 객체입니다. 
						// 검색창에 사용자가 입력한 텍스트를 잘 불러오는지 확인하는 출력입니다. 
						System.out.println(searchTF.getText());
						// 커서가 가리키는 것이 있는 동안 (= 결과객체에 조회 결과가 존재하는 동안)
						while (rs.next()) {
							String name = rs.getString("name");
							String namedatas[] = {name};
							mainDtm.addRow(namedatas);
						}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconnect();
				}
}

			/*(4) 등록==========================================
			 * 반환타입은 int로 할 것이고, 데이터는 AddrVO의 객체를 넘겨 받아서 사용할 것입니다. 
			 * 일단 기본값으로는 0을 반환하도록 할 것이지만,
			 * 데이터 등록이 완료되면 수행된 열의 갯수를 반환하도록 할 것입니다.
			 * UI를 통한 입력은 한 행씩 가능하므로 성공적으로 등록이 된다면 '1'을 반환할 것입니다. 
			 *==========================================*/
			public int insert(AddrVO addrvo) {
				// DB와 연결을 시작합니다. 
				connect();
				int row = 0;
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO addressbook ("                                         							);
				sql.append("		id, name, address, telephone, gender, relationship, birthday, comments");
				sql.append("		) VALUES	("																	                 	);
				sql.append("		(SELECT NVL(max(id+1),0) from addressbook) "                                 );
				sql.append("		,?"                                                       												); //1
				sql.append("		,?"                                                       												); //2
				sql.append("		,?"                                                       												); //3
				sql.append("		,?"                                                       												); //4
				sql.append("		,?"                                                       												); //5
				sql.append("		,TO_DATE(?,'yy.mm.dd')"                                                       				); //6 (yyyy.mm.dd 형식으로 입력받도록 라벨붙임) 
				sql.append("		,?)"                                                       											); //7
				
				try {
					pstmt = con.prepareStatement(sql.toString());
					// UI에서 입력받은 값은 AddrVO로 전달이 될 것
					pstmt.setString(1, addrvo.getName());
					pstmt.setString(2, addrvo.getAddress());
					pstmt.setString(3, addrvo.getTelephone());
					pstmt.setString(4, addrvo.getGender());
					pstmt.setString(5, addrvo.getRelationship());
					pstmt.setString(6, addrvo.getBirthday());
					pstmt.setString(7, addrvo.getComments());
					
					row	= pstmt.executeUpdate();// 조회경우 커서를 조작 필요
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconnect();
				}
				return row;
			}
	
			/*(5) 수정==========================================
			 * addrvo에 포함된 id (index)값으로 수정할 것입니다.
			 * @ param -> AddrVO addrvo
			 * @ return -> int row 
			 * ==============================================*/
			public int update(AddrVO addrvo, int id) {
				
				// DB와 연결을 시작합니다. 
				connect();
				int row = 0;
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE addressbook SET				 	");
				sql.append("								name = ?          ");
				sql.append("							, address = ?        	");
				sql.append("							, telephone = ?      ");
				sql.append("							, gender = ?          ");
				sql.append("							, relationship = ?   ");
				sql.append("							, birthday = TO_DATE(?,'yy.mm.dd')       ");
				sql.append("							, comments = ?     ");
				sql.append(" WHERE id = ?           						");
				
				try {
					pstmt = con.prepareStatement(sql.toString());
					// UI에서 입력받은 값은 AddrVO로 전달이 될 것
					pstmt.setString(1, addrvo.getName());
					pstmt.setString(2, addrvo.getAddress());
					pstmt.setString(3, addrvo.getTelephone());
					pstmt.setString(4, addrvo.getGender());
					pstmt.setString(5, addrvo.getRelationship());
					pstmt.setString(6, addrvo.getBirthday());
					pstmt.setString(7, addrvo.getComments());
					pstmt.setInt(8, id);
					
					System.out.println("변경할 인덱스 값 : "+ addrvo.getId());
					System.out.println(" 수정 후 값 : "+addrvo.getName());
					row	= pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					disconnect();
				}
				return row;
			}

			/*(6) 삭제==========================================
			 * @ param -> int id
			 * @ return -> int row 
			 *  ============================================== */
			public int delete(int id) {
				connect();				
				int row = 0; 
				String sql = "DELETE FROM addressbook WHERE id = ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, id);
					row = pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					disconnect();
				}
				return row;
			}
}

	

		
	