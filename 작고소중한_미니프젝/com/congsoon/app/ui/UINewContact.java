package com.congsoon.app.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.congsoon.app.service.ContactInfo;
import com.congsoon.app.service.ServiceContactInfo;

public class UINewContact extends JFrame implements ActionListener , KeyListener{
	JPanel      	jp_center		= new JPanel();
	
	JLabel 		jlb_name 			= new JLabel("	이름 ");
	JTextField 	jtf_name 			= new JTextField("",20);
	
	JLabel 		jlb_tel 			= new JLabel("	전화번호 ");
	JTextField 	jtf_tel 			= new JTextField("",20);
	
	JLabel 		jlb_email 			= new JLabel("	Email");
	JTextField	jtf_email			= new JTextField("",20);
	
	JLabel 		jlb_relation 			= new JLabel("	관계 ");
	JTextField	jtf_relation			= new JTextField("",20);
	
	JLabel 		jlb_loc 			= new JLabel("	지역 ");
	JTextField	jtf_loc			= new JTextField("",20);
	
	JLabel 		jlb_memo 			= new JLabel("	메모 ");
	JTextField	jtf_memo			= new JTextField("",20);
	
	JButton		jbtn_success		= new JButton("완료");
	JButton		jbtn_cancel		= new JButton("취소");

	JScrollPane	scroll = new JScrollPane();
	
	// 생성자
	
	public UINewContact() {
		initDisplay();
	}
	
	public UINewContact(UIContactInfo main) {
		
	}
	public String getName() {
		return jtf_name.getText();
	}
	
	public void initDisplay() {
		jbtn_success.addActionListener(this);
		jtf_name.addActionListener(this);
		jtf_tel.addActionListener(this);
		//처음 화면이 열렸을 때는 아직 데이터입력이 되지 않았으니까 회원가입 버튼 비활성화
//		jbtn_success.setEnabled(false);
		// 이벤트 소스와 이벤트처리 핸들러 클래스 연결하기
//		jbtn_success.addActionListener(this);
//		jbtn_cancel.addActionListener(this);
		jp_center.setLayout(null);
		
		jbtn_success.setLayout(null);
		jbtn_success.setBounds(359, 6, 35, 36);
		
		jbtn_cancel.setLayout(null);
		jbtn_cancel.setBounds(6,6,35,36);
		
		jlb_name.setBounds(6, 85, 67, 62);
		jlb_tel.setBounds(6, 145, 67, 62);
		jlb_email.setBounds(6, 205, 67, 62);
		jlb_memo.setBounds(6, 280, 67, 62);
		jlb_relation.setBounds(6, 375, 67, 62);
		jlb_loc.setBounds(6, 435, 67, 62);
		
		jtf_name.setBounds(80, 90, 314, 50);
		jtf_tel.setBounds(80, 150, 314, 50);
		jtf_email.setBounds(80, 210, 314, 50);
		jtf_memo.setBounds(80, 270, 314, 100);
		jtf_relation.setBounds(80, 380, 314, 50);
		jtf_loc.setBounds(80, 440, 314, 50);
		
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_tel);
		jp_center.add(jtf_tel);
		jp_center.add(jlb_email);
		jp_center.add(jtf_email);
		jp_center.add(jlb_memo);
		jp_center.add(jtf_memo);
		jp_center.add(jlb_relation);
		jp_center.add(jtf_relation);
		jp_center.add(jlb_loc);
		jp_center.add(jtf_loc);
		
		scroll.setLayout(null);
		scroll.setBounds(0, 160, 400, 412);
		scroll.setViewportView(jp_center);
		//	jp_center.add(scroll);
		
		
		this.add(jbtn_success);
		this.add(jbtn_cancel);
		this.add(jp_center);
		this.setTitle("회원가입 하기");
		this.setSize(430, 380);
		this.setVisible(true);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setTitle("새로운 연락처");
		this.setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(jbtn_success == obj) {
			ContactInfo contact = new ContactInfo();
			contact.setInfo_name(jtf_name.getText());
			contact.setInfo_tel(jtf_tel.getText());
			System.out.println(contact.getInfo_name());
			System.out.println(contact.getInfo_tel());
			
			try {
				ServiceContactInfo in = new ServiceContactInfo();
				
				in.insert(contact);
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			this.dispose();
		}
		//boolean isFilled = false;
	
//		if(jtf_name.getText()!=null) {
//			jbtn_success.setEnabled(true);
//		}
		
	}

	@Override
	public void keyPressed(KeyEvent e ) {
		jtf_name.setText(jtf_name.getText());
		System.out.println();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
