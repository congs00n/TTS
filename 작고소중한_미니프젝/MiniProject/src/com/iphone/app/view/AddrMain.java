package com.iphone.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.iphone.app.model.AddrDAO;
import com.iphone.app.model.AddrVO;

/* 이 page는 메인(홈) 페이지입니다.
 * -> 메인 테이블을 띄웁니다.(이름만)
 * -> 검색할 수 있습니다.
 * -> + 버튼을 통해 새로운 연락처를 입력할 수 있습니다.
 * -> */
public class AddrMain  extends JFrame implements ActionListener, MouseListener{
	/*****************UI선언부*******************/
	JPanel					jp_north 	= new JPanel();
	JPanel					jp_text 		= new JPanel();
	JButton					jbtn_search 		= new JButton("search");
	JButton 					jbtn_insert 		= new JButton("+");
	JButton 					jbtn_reset 			= new JButton("새로고침");
	JButton					jbtn_owner 		= new JButton("		ADDRESSBOOK PROJECT BY CHAEEUN		");
	JTextField				jtf_search			= new JTextField("검색");
	
	String[] 				header				= new String[]{"이름"};
	DefaultTableModel 	dtm					= 	new DefaultTableModel(header, 0);
	JTable					table					= new JTable(dtm);
	JScrollPane 			scrollTable 			= 	new JScrollPane(table);
	
	String				imgPath					= "image/";
	ImageIcon 		icon						= new ImageIcon(imgPath+"owner.png");
	Image				img						= icon.getImage();
	Image				changeImg				= img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon			changeIcon			= new ImageIcon(changeImg);
							
	AddrVO addrvo = null;
	AddrDAO dao = new AddrDAO();
	
	public AddrMain() {
		initDisplay();
	}
 	public void initDisplay() {
 		jbtn_insert.addActionListener(this);
		jbtn_reset.addActionListener(this);
		jbtn_search.addActionListener(this);
		
		// 프레임을 내 맘대로 설정하겠다. 	
 		this.setLayout(null);
			this.setBackground(Color.WHITE);
			jp_north.setLayout(null);
			jp_north.setBounds(0, 0, 400, 170);
			jp_north.setBackground(Color.white);

		
   		    jbtn_search.setLayout(null);
			jbtn_search.setBounds(330, 47, 62, 42);
			jp_north.add(jbtn_search);
			
			jbtn_owner.setLayout(null);
			jbtn_owner.setEnabled(false);
			jbtn_owner.setBounds(80, 93, 314, 62);
			jp_north.add(jbtn_owner);
			
			
			jtf_search.setLayout(null);
			jtf_search = new JTextField("검색");
			jtf_search.setBounds(6, 47, 322, 42);
			jtf_search.setForeground(Color.DARK_GRAY);
			jtf_search.setBackground(UIManager.getColor("Button.background"));
			jp_north.add(jtf_search);
			
			jbtn_insert.setLayout(null);
			jbtn_insert.setBounds(359, 6, 35, 36);
			jbtn_insert.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			jbtn_insert.setForeground(UIManager.getColor("Button.disabledText"));
			jp_north.add(jbtn_insert);
			
			jbtn_reset.setLayout(null);
			jbtn_reset.setBounds(290, 6, 62, 36);
			jbtn_reset.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			jbtn_reset.setForeground(UIManager.getColor("Button.disabledText"));
			jp_north.add(jbtn_reset);		
			
			JLabel lblNewLabel = new JLabel("  연락처");
			lblNewLabel.setLayout(null);
			lblNewLabel.setBounds(6, 6, 110, 40);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			jp_north.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setLayout(null);
			lblNewLabel_1.setBounds(6, 92, 67, 62);
			lblNewLabel_1.setIcon(new ImageIcon(changeImg));
			jp_north.add(lblNewLabel_1);
			
			table.addMouseListener(this);
			table.setLayout(null);
			table.setBounds(10, 10, 380, 330);
		
			// 테이블은 하나의 행만 선택할 수 있도록 지정합니다. 
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setRowHeight(25);
			table.setPreferredScrollableViewportSize(new Dimension(380, 350));
			table.setFont(new Font("Lucida Grande", Font.PLAIN, 17 ));
			table.setForeground(Color.DARK_GRAY);
			table.setFillsViewportHeight(true);
			table.setVisible(true);
			
			
			// 테이블의 데이터가 아래로 내려갈 경우에 아래로 자동으로 내려감 
			scrollTable.setLayout(null);
			scrollTable.setBounds(0, 170, 400, 410);
			scrollTable.setBackground(Color.LIGHT_GRAY);
			scrollTable.add(table);
			scrollTable.setVisible(true);
			this.add(jp_text);
			this.add(jp_north);
			this.add(scrollTable);
			this.setSize(400, 600);
			this.setTitle("연락처");
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		}
 
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();	
				// 입력은 입력창에서 실행되도록 입력창을 불러옵니다. 
				if(obj == jbtn_insert) {
					System.out.println("=======  4. 등록 서비스 시작  =======");
					new AddrInsertDialog();
				}
				
				//새로 고침 버튼을 누르면 테이블에 저장된 전체 이름이 조회됩니다. 
				if(obj == jbtn_reset) {
					System.out.println("=======  1. 전체조회 서비스 시작  =======");
					System.out.println();
					while(dtm.getRowCount() > 0) {
						dtm.removeRow(0); 
					}
					dao.getDBName();
					// 창이 무한으로 생성되는 것을 방지하기 위해 
					// 켜져 있던 창은 dispose()를 해줍니다.  
					this.dispose();
				}
				// 검색 버튼을 클릭했을 때 
				else if(obj == jbtn_search) {
					System.out.println("=======  3. 검색 서비스 시작  =======");
					while(dtm.getRowCount() > 0) {
						dtm.removeRow(0);
					}
					dao.searchDBName(dtm, this.jtf_search);
				}
			}
		
		public DefaultTableModel  getDtm() {
			return dtm;
		}
		/*마우스 클릭 이벤트처리*/
		@Override
		// 마우스를 클릭하면 상세조회 창이 열리고 -> new AddrDetailDialog();
		// 그 안에서 수정과 삭제가 가능하다. 
		// 우선 테이블의 셀을 클릭했을 때 현재 위치를 읽어낼 수 있어야 한다. 
		// 현재 위치는 => 선택된 행의 행번호, 열번호를 통해 읽어낼 수 있고,
		// 행번호와 열번호로 선택된 셀의 값을 가져올 수 있다. 
		// getSelectedRow() :JTable에서 선택한 셀의 row 값을 int로 반환
		// getSelectedColumn() : JTable에서 선택한 셀의 column값을 int로 반환
		// getModel(): JTable이 갖고 있는 데이터를 담고 있는 객체인 TableModel 객체가 리턴
		// TableModel의 getValueAt(row, col) 지정한 row와 column번호에 해당하는 셀의 값을 리턴
		// getColumnCount(): JTable에 뿌려진 모든 데이터의 컬럼 수를 계산해서 int 형으로 리턴한다. 
		public void mouseClicked(MouseEvent e) {
			System.out.println("=======  2. 상세조회 서비스 시작  =======");
			addrvo = new AddrVO();
			// 이벤트가 발생한 데이터의 행번호를 담을 변수
			int rowNum = table.getSelectedRow();
			// 테이블의 모델 객체 얻어오기
			TableModel data = table.getModel();
			// 선택한 테이블의 이름 레코드를 받아줍니다. 
			String name = (String) data.getValueAt(rowNum, 0);
			
			// dao 객체가 클릭한 name 레코드의 id 값(인덱스)을 반환하는 서비스를 제공합니다. 
			int id = dao.selectID(name);
			
			// dao객체가 id 값에 해당하는 전체 레코드를 Value Object 값으로 반환해 줍니다. 
			addrvo = dao.selectAll(id);
			
			for(int i = 0; i < table.getColumnCount(); i++) {
				System.out.println("선택된 "+name+"을 상세 조회합니다.");
				// 선택한 데이터에 해당되는 상세조회창이 켜집니다. 
				// 이렇게 구현하기 위해서는 새 창을 띄울 때 생성자를 통해 
				// 선택한 레코드에 대한 Value Object를 줄 수 있도록 해야 한다. 
				new AddrDetailDialog(addrvo);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
}

