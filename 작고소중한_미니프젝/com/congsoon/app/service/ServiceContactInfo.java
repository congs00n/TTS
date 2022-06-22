package com.congsoon.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*이 서비스를 통해 데이터를 조작하게 된다.
 * 상수가 아니라 사용자가 입력한 값을 통해 조작하도록 하겠다. */
public class ServiceContactInfo {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "CRUD";
	private String pwd = "tiger";
	/*드라이버도 문자열이 반복되므로 전역변수화 시켜서 올려준다.
	 * 이는 드라이버가 바뀌었을 때 쉽게 변경할 수 있도록 한다. */
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	
		// 기본적으로 4개의 서비스를 가진다. 
		/* SELECT info_num
		 * FROM contactinfo
		 * WHERE info_name = '?'(사용자 입력)' 
		 * 사용자가 이름을 검색하면 그 사람의 info_num가 조회되도록 처리 */
		public List<ContactInfo> getList() throws ClassNotFoundException, SQLException{
			Class.forName(driver);
			
			/*이 객체들은 매번 실행할 때마다 따로 있어야 한다. 따라서 전역변수로 올리는 것은 바람직하지 않다. */
			String sql = "SELECT info_num, info_name FROM CONTACTINFO";
			Connection 			con 	= DriverManager.getConnection(url,uid,pwd);
			Statement 				st 		= con.createStatement();
			ResultSet 				rs		= st.executeQuery(sql);// 조회경우 커서를 조작 필요
		
			// 반환받기 위한 준비 List<ContactInfo> arryaList를 만든다. 
			List<ContactInfo> list = new ArrayList<>();
			
			while (rs.next()){
				int	 info_num = rs.getInt("info_num");
				String info_name = rs.getString("info_name");
				
				// 사용할 객체를 만들었다. 
				// 만든 뒤에는 반환할 list가 필요하다. 
				ContactInfo contactInfo = new ContactInfo(
															info_num,
															info_name
															);
				// 커서를 통해 받아온 값을 생성자를 통해 받아온다. 
				// 목록에 하나씩 하나씩 담길 것이다. 
				list.add(contactInfo);
			}
			rs.close();
			st.close();
			con.close();
			
			return list;
			
		
	}

		/*INSERT
		 * 반환타입은 int로 할 것이고, 데이터는 ContactInfo 를 넘겨 받아서 사용할 것이다. 
		 * 일단 기본값으로 0을 반환하도록 할 것이다. 
		 *
		 *0622 sql.append()>SQL이 null이라고 떠서 StringBuilder 대신 String 사용
		 *			sql.append("   INSERT INTO contactinfo (	");
//			sql.append("    info_num,                 		");
//			sql.append("    info_name,                		");
//			sql.append("    info_tel                 			");
//			sql.append("    info_email,               		");
//			sql.append("    info_relation,            		");
//			sql.append("    info_loc,                 			");
//			sql.append("    info_gender,              		");
//			sql.append("    info_memo,                		");
//			sql.append("    info_regdate  	        		");
//			sql.append(") VALUES (                    		");
//			sql.append("    (select nvl(max(info_num+1),0) from contactinfo),?,?) ");
//			sql.append("    ?,?                			"); //1
			//sql.append("    ? )                      			"); //2
//			sql.append("    ?,                        			"); //3
//			sql.append("    ?,                        			"); //4
//			sql.append("    ?,                        			"); //5
//			sql.append("    ?,                        			"); //6
//			sql.append("    ?,                        			"); //7
//			sql.append("    TO_DATE(sysdate,'yy.mm.dd')");                
			
			
//			pstmt.setString(3, contactInfo.getInfo_email());
//			pstmt.setString(4, contactInfo.getInfo_relation());
//			pstmt.setString(5, contactInfo.getInfo_loc());
//			pstmt.setString(6, contactInfo.getInfo_gender());
//			pstmt.setString(7, contactInfo.getInfo_memo());*/
		public int insert(ContactInfo contactInfo) throws ClassNotFoundException, SQLException {
			int row = 0;
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String sql = ("insert into contactinfo (info_num,info_name,info_tel) values ((select nvl(max(info_num+1),0) from contactinfo), ?, ?)");
			
			Class.forName(driver);
			
			Connection 				con 		= DriverManager.getConnection(url,uid,pwd);
			PreparedStatement 	pstmt 	= con.prepareStatement(sql);
			
			
			
			pstmt.setString(1, contactInfo.getInfo_name());
			pstmt.setString(2, contactInfo.getInfo_tel());
			row	= pstmt.executeUpdate();// 조회경우 커서를 조작 필요
			
			pstmt.close();
			con.close();
			
			return row;
			// 사용자 인터페이스에서 입력한 값이 contactInfo로 전달이 될 것
			// 따라서 contactInfo의 getter 메소드를 통해 데이터를 받아온다. 
			
		}
		
		/*UPDATE
		 * 반환타입은 int로 할 것이고, 데이터는 ContactInfo 를 넘겨 받아서 사용할 것이다. 
		 * 일단 기본값으로 0을 반환하도록 할 것이다. */
		public int update(ContactInfo contactInfo) throws ClassNotFoundException, SQLException {
			int row = 0;
			StringBuilder sql = new StringBuilder();
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			
			Class.forName(driver);
			
			Connection 				con 		= DriverManager.getConnection(url,uid,pwd);
			PreparedStatement 	pstmt 	= con.prepareStatement(sql.toString());
			
			sql.append( "UPDATE CONTACTINFO");
			sql.append( "SET"                       );
			sql.append( "			info_name = ?," );
			sql.append( "			info_tel  = ?," );
			sql.append(  "		info_email = ?,"    );
			sql.append(  "		info_relation = ?," );
			sql.append(  "		info_loc = ?,"      );
			sql.append(  "		info_gender = ?,"   );
			sql.append(  "		info_memo = ?"     );
			sql.append(  "WHERE info_num = ? "      );
			
			pstmt.setString(1, contactInfo.getInfo_name());
			pstmt.setString(2, contactInfo.getInfo_tel());
			pstmt.setString(3, contactInfo.getInfo_email());
			pstmt.setString(4, contactInfo.getInfo_relation());
			pstmt.setString(5, contactInfo.getInfo_loc());
			pstmt.setString(6, contactInfo.getInfo_gender());
			pstmt.setString(7, contactInfo.getInfo_memo());
			pstmt.setInt(8, contactInfo.getInfo_num());
			
			row = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return row;
		}
		
		/*DELETE
		 * 반환타입은 int로 할 것이고
		 * 데이터를 삭제할 때는 ContactInfo 의 큰 보따리를 주는것이 아니므로 int info_num를 줄 것이다.
		 * 일단 기본값으로 0을 반환하도록 할 것이다. */
		public int delete(int info_num) throws ClassNotFoundException, SQLException {
			StringBuilder sql = new StringBuilder();
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			Class.forName(driver);
			Connection 				con 		= DriverManager.getConnection(url,uid,pwd);
			PreparedStatement 	pstmt 	= con.prepareStatement(sql.toString());
			pstmt.setInt(1, info_num);
			
			int row = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return row;
		}
}
