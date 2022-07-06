package com.iphone.app.view;

// 주소록 신규 등록 시에 열리는 창입니다. 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.iphone.app.model.AddrDAO;
import com.iphone.app.model.AddrVO;

public class AddrInsertDialog extends JFrame implements ActionListener{
	JPanel      	jp_center		= new JPanel();
	
	JLabel 		jlb_name 			= new JLabel("	이름 ");
	JTextField 	jtf_name 			= new JTextField("",20);
	
	JLabel 		jlb_address 			= new JLabel("	주소 ");
	JTextField	jtf_address			= new JTextField("",20);
	
	JLabel 		jlb_telephone 			= new JLabel("	전화번호 ");
	JTextField 	jtf_telephone 				= new JTextField("",20);
	
	String gender[] = {"남", "여"};
	JComboBox<String> jc_gender 	= new JComboBox<String>(gender);
	
	JLabel 		jlb_gender 			= new JLabel(" 성별 ");
	JTextField	jtf_gender			= new JTextField("",20);
	
	JLabel 		jlb_relationship 			= new JLabel(" 관계 ");
	JTextField	jtf_relationship			= new JTextField("",20);
	
	JLabel 		jlb_infoBirth			= new JLabel("'yyyy.mm.dd'으로 입력해 주세요.");
	JLabel 		jlb_birthday 			= new JLabel(" 생일 ");
	JTextField	jtf_birthday		= new JTextField(" ",20);
	
	JLabel 		jlb_comments 			= new JLabel("	메모 ");
	JTextField	jtf_comments			= new JTextField("",20);
	
	JButton		jbtn_success		= new JButton("완료");
	JButton		jbtn_cancel		= new JButton("취소");

	JScrollPane	scroll = new JScrollPane();
	
	// 생성자
	public AddrInsertDialog() {
		initDisplay();
	}
	
	public AddrInsertDialog(AddrMain main) {
	}
	
	public String getName() {
		return jtf_name.getText();
	}
	
	public void initDisplay() {
		jbtn_success.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		jtf_name.addActionListener(this);
		jtf_address.addActionListener(this);
		jtf_telephone.addActionListener(this);

		jp_center.setLayout(null);
		
		jbtn_success.setLayout(null);
		jbtn_success.setBounds(359, 6, 35, 36);
		
		jbtn_cancel.setLayout(null);
		jbtn_cancel.setBounds(6,6,35,36);
		
		jlb_name.setBounds(6, 85, 67, 62);
		jlb_address.setBounds(6, 145, 67, 62);
		jlb_telephone.setBounds(6, 205, 67, 62);
		jlb_comments.setBounds(6, 280, 67, 62);
		jlb_relationship.setBounds(6, 375, 67, 62);
		jlb_gender.setBounds(6, 435, 67, 62);
		jlb_infoBirth.setBounds(80, 475, 280, 62);
		jlb_birthday.setBounds(6, 510, 67, 62);
		
		jtf_name.setBounds(80, 90, 314, 50);
		jtf_address.setBounds(80, 150, 314, 50);
		jtf_telephone.setBounds(80, 210, 314, 50);
		jtf_comments.setBounds(80, 270, 314, 100);
		jtf_relationship.setBounds(80, 380, 314, 50);
//		jtf_gender.setBounds(80, 440, 314, 50);
		jtf_birthday.setBounds(80, 515, 314, 50);
		
		jc_gender.setLayout(null);
		// 콤보박스의 초기 선택값을 0으로 두어 
		// 첫 번째 값이 초기값으로 보일 수 있도록 합니다. 
		jc_gender.setSelectedIndex(0);
		jc_gender.setBackground(Color.yellow);
		jc_gender.setForeground(Color.black);
		jc_gender.setVisible(true);
		jc_gender.setBounds(80, 440, 314, 50);
	
		
		// 패널에 라벨과 입력창을 붙입니다. 
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		
		jp_center.add(jlb_telephone);
		jp_center.add(jtf_telephone);
		
		jp_center.add(jlb_comments);
		jp_center.add(jtf_comments);
		
		jp_center.add(jlb_relationship);
		jp_center.add(jtf_relationship);
		
		jp_center.add(jlb_gender);
		jp_center.add(jc_gender);

		jp_center.add(jlb_infoBirth);
		jp_center.add(jlb_birthday);
		jp_center.add(jtf_birthday);
		
		this.add(jbtn_success);
		this.add(jbtn_cancel);
		this.add(jp_center);
		this.setTitle("회원가입 하기");
		this.setVisible(true);
		this.setSize(415, 625);
		this.setVisible(true);
		this.setTitle("새로운 연락처");
		this.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		// 확인버튼의 눌림을 감지했을 때 
		if(jbtn_success == obj) {
			// 속성값담당 insertVO 객체를 생성합니다. 
			AddrVO insertVO= new AddrVO();
			
			// 속성값 담당객체는 텍스트필드로 입력받은 값으로 vo의 값을 설정합니다. 
			insertVO.setName(jtf_name.getText());
			insertVO.setAddress(jtf_address.getText());
			// 전화번호 사이 공백을 없애기 위해서 문자 사이의 공백을 없애는 replaceAll()함수를 사용합니다. 
			insertVO.setTelephone(jtf_telephone.getText().replaceAll(" ", ""));
			// 콤보박스에서 선택된 값을 리턴하는 getSelectedItem() 메소드를 사용하여 
			// vo 의 속성값을 전달합니다. 
			insertVO.setGender(jc_gender.getSelectedItem().toString());
			insertVO.setRelationship(jtf_relationship.getText());
			insertVO.setBirthday(jtf_birthday.getText());
			insertVO.setComments(jtf_comments.getText());
			
			// 사용자의 입력으로 속성값이 잘 변경되었는지 확인하기 위해 콘솔창에 출력합니다. 
			System.out.println(insertVO.getName());
			System.out.println(insertVO.getAddress());
			System.out.println(insertVO.getTelephone());
			System.out.println(insertVO.getGender());
			System.out.println(insertVO.getRelationship());
			System.out.println(insertVO.getBirthday());
			System.out.println(insertVO.getComments());
			
			// 입력을 위한 dao 를 불러온 뒤 insertDAO라 명명합니다. 
			// insertDAO는 insert()메소드를 통해 insertVO를 데이터베이스에 입력합니다. 
			AddrDAO insertDAO = new AddrDAO();
			int row = insertDAO.insert(insertVO);
			// 서비스 클래스의 insert(); 메소드가 데이터 입력에 성공하면 1을 반환하므로.. 
			if(row == 1) {
				JOptionPane.showMessageDialog
				(this, "연락처 등록이 완료되었습니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog
				(this, "입력한 연락처를 등록할 수 없습니다. 입력을 확인해주세요.","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
			this.dispose();
		}
		else if (jbtn_cancel == obj){
			this.dispose();
		}
	}
}
