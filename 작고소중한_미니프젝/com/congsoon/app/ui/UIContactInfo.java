package com.congsoon.app.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/* ui 담당 클래스는 어떤 메소드를 가지도록 할 것이냐?*/
public class UIContactInfo  extends JFrame implements ActionListener{
	/*****************UI선언부*******************/
	JPanel					jp_north = new JPanel();
	JButton					jbtn_search 		= new JButton("search");
	JButton 					jbtn_insert 		= new JButton("+");
	JButton 					jbtn_reset 		= new JButton("새로고침");
	JButton					jbtn_owner 		= new JButton("			정채은			");
	String[] 				header				= new String[]{"이름"};
	Object[][] 				data 					= new Object[][]{ {"					서한힘					"}};																				
	//DefaultTableModel 	model 				= 	new DefaultTableModel(data, header);
	JTable					table					= new JTable(data, header);
	JScrollPane 			scrollTable 			= 	new JScrollPane(table);
	
	String				imgPath					= "src/addressBook/image/";
	ImageIcon 		icon						= new ImageIcon(imgPath+"owner.png");
	Image				img						= icon.getImage();
	Image				changeImg				= img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon			changeIcon			= new ImageIcon(changeImg);
	
	JTextField 				jtf_search	 	= new JTextField("🔍검색");
//	InsertAddress			infoinsert		= new InsertAddress(this);
	public UIContactInfo() {
		jbtn_insert.addActionListener(this);
		initDisplay();
	}
 	public void initDisplay() {
		// 프레임을 내 맘대로 설정하겠다. 	
 		this.setLayout(null);
			this.setBackground(Color.WHITE);
			jp_north.setLayout(null);
			jp_north.setBounds(0, 0, 400, 170);
			jp_north.setBackground(Color.white);
			scrollTable.setLayout(null);
			scrollTable.setBounds(0, 170, 400, 410);
			scrollTable.setBackground(Color.LIGHT_GRAY);
		
   		    jbtn_search.setLayout(null);
			jbtn_search.setBounds(330, 47, 62, 42);
			jp_north.add(jbtn_search);
			
			jbtn_owner.setLayout(null);
			jbtn_owner.setBounds(80, 93, 314, 62);
			jp_north.add(jbtn_owner);
			
			jtf_search.setLayout(null);
			jtf_search.setBounds(6, 47, 322, 42);
			jtf_search.setColumns(10);
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
			

			table.setLayout(null);
			table.setBounds(10, 10, 380, 330);
			table.setRowHeight(25);
			table.setPreferredScrollableViewportSize(new Dimension(380, 350));
			table.setFont(new Font("Lucida Grande", Font.PLAIN, 17 ));
			table.setForeground(Color.DARK_GRAY);
			table.setFillsViewportHeight(true);
			table.setVisible(true);
					
			scrollTable.add(table);
			this.add(jp_north);
			this.add(scrollTable);
			this.setSize(400, 600);
			this.setTitle("연락처");
			this.setVisible(true);
			//this.setBackground(Color.WHITE);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		}
 	

		public void printContactInfoList() {

		}
		
		public void searchContactInfo() {
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();		
			if(obj == jbtn_insert) {
				UINewContact insertFrame = new UINewContact();
				
			}
			/*새로 고침 버튼을 누르면 테이블에 저장된 연락처 이름이 ㄱㄴㄷ순서대로 나타난다. 
			 * SELECT INFO_NAME FROM CONTACTINFO ORDER BY ASC;*/
			if(obj == jbtn_reset) {
				
			}
		}

}
