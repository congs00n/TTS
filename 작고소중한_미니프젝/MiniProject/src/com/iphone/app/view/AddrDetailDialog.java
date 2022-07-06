package com.iphone.app.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iphone.app.model.AddrDAO;
import com.iphone.app.model.AddrVO;

// 사용자가 클릭한 name에 해당하는 상세정보를 조회할 수 있는 창입니다. 
// 창이 켜질 때 AddrVO 에 있는 레코드가 textfield에 에 보여집니다. 
public class AddrDetailDialog extends JFrame implements ActionListener {
	AddrVO addrvo = null;
	AddrDAO dao = null;
	// 상세조회창은 이전에 선택된 name의 id 값으로 update, delete 를 할 것이므로 
	// 전역변수로 올려서 어느 자리에서도 쓸 수 있도록 해야 합니다. 
	int id = 0;
	JPanel		jp_center 			= new JPanel();
	
	JLabel 		jlb_name 			= new JLabel("	이름 ");
	JTextField 	jtf_name 			= new JTextField(" ", 20);
	
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
	
	// 편집 버튼을 눌러야 활성화 나타나도록 처리할 것입니다. 
	String		imgURL					= "image/";
	JButton		jbtn_update		= new JButton(new ImageIcon(imgURL+"update.png"));
	JButton		jbtn_delete		= new JButton(new ImageIcon(imgURL+"delete.png"));
	JButton 		jbtn_success		= new JButton(new ImageIcon(imgURL+"success.png"));
	JButton 		jbtn_cancel		= new JButton(new ImageIcon(imgURL+"cancel.png"));
	
	public AddrDetailDialog () {
	}
	
	public AddrDetailDialog(AddrVO addrvo) {
		// 선택한 name에 해당하는 상세정보를 담은 addrvo를 넘겨받습니다. 
		this.addrvo= addrvo;
		initDisplay();
	}

	public void initDisplay() {
		
		// 이벤트 감지
		jbtn_cancel.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_success.addActionListener(this);
		jbtn_delete.addActionListener(this);
		
		jp_center.setLayout(null);
		
		jbtn_update.setLayout(null);
		jbtn_update.setBounds(349, 7, 55, 55);
		
		jbtn_cancel.setLayout(null);
		jbtn_cancel.setBounds(9, 8, 55,55);
		
		jbtn_delete.setLayout(null);
		jbtn_delete.setEnabled(false);
		jbtn_delete.setBounds(140, 520, 70, 65);
		
		jbtn_success.setLayout(null);
		jbtn_success.setEnabled(false);
		jbtn_success.setBounds(210, 520, 70, 65);
		
		jlb_name.setBounds(6, 57, 67, 62);
		jlb_address.setBounds(6, 107, 67, 62);
		jlb_telephone.setBounds(6, 158, 67, 62);
		jlb_comments.setBounds(6, 225, 67, 62);
		jlb_relationship.setBounds(6, 308, 67, 62);
		jlb_gender.setBounds(6, 435, 67, 62);
		jlb_infoBirth.setBounds(80, 347, 280, 62);
		jlb_birthday.setBounds(6, 370, 67, 62);
		
		jtf_name.setBounds(80, 70, 314, 40);
		jtf_address.setBounds(80, 120, 314, 40);
		jtf_telephone.setBounds(80, 170, 314, 40);
		jtf_comments.setBounds(80, 220, 314, 90);
		jtf_relationship.setBounds(80, 320, 314, 40);
		jtf_gender.setBounds(80, 440, 314, 50);
		jtf_birthday.setBounds(80, 385, 314, 40);
		
		// 편집 버튼을 누르기 전까지는 textfield를 비활성화 합니다. 
		jtf_name.setEnabled(false);
		jtf_address.setEnabled(false);
		jtf_telephone.setEnabled(false);
		jtf_comments.setEnabled(false);
		jtf_relationship.setEnabled(false);
		jtf_birthday.setEnabled(false);
		
		jc_gender.setLayout(null);
		// 콤보박스의 초기 선택값을 0으로 두어 
		// 첫 번째 값이 초기값으로 보일 수 있도록 합니다. 
		jc_gender.setSelectedIndex(0);
		jc_gender.setBackground(Color.yellow);
		jc_gender.setForeground(Color.black);
		//  편집버튼이 눌리면 콤보박스가 보이도록 구현 
		jc_gender.setVisible(false);
		jc_gender.setBounds(80, 440, 314, 50);
	
		
		/*******AddrVO의 addrvo 객체에 의해 받아온 레코드로 textfield값 보이도록 처리 **********/
		jtf_name.setText(addrvo.getName());
		jtf_address.setText(addrvo.getAddress());
		jtf_telephone.setText(addrvo.getTelephone());
		jtf_gender.setText(addrvo.getGender());
		jtf_relationship.setText(addrvo.getRelationship());
		jtf_birthday.setText(addrvo.getBirthday());
		jtf_comments.setText(addrvo.getComments());
		
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
		
		this.add(jbtn_update);
		this.add(jbtn_delete);
		this.add(jbtn_success);
		this.add(jbtn_cancel);
		this.add(jp_center);
		this.setTitle("상세조회");
		this.setVisible(true);
		this.setSize(415, 625);
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
	}
	
	public static void main(String[] args) {
		new AddrDetailDialog();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (jbtn_cancel==obj) {
			int n = JOptionPane.showConfirmDialog(this, "작업을 중단하고 메인 화면으로 돌아가시겠습니까?", 
					"Confirm",JOptionPane.YES_NO_OPTION);
			if(n == 0){
					this.dispose();
			}
		}
		
		/////////======> 수정모드 전환!! 
		
		// 편집버튼을 누르면
		// - 텍스트필드가 활성화되고,
		// - 확인버튼이 활성화 되며, 
		// - 프레임의 제목이 '편집'으로 변경됩니다. 
		// - 수정모드로 전환 후 연락처를 수정, 삭제할 수 있습니다. 
		
				// *****!!!!!!여기서 주의해야 할 것은!!!!******
		
				// - 수정 전 textfield에 있는 id 값을 받아와야 합니다. 
				// - 완료 버튼을 누르고 id 값을 받으면 수정하고자 하는 이름의 id 값을 찾기 때문에 
				// - 쿼리의 실행결과는 나타나지 않습니다. 
		else if(jbtn_update==obj) {
			System.out.println("=======  4. 수정 서비스 시작  =======");
			JOptionPane.showMessageDialog
			(this, "수정모드로 전환합니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
			
			dao = new AddrDAO();
			jtf_name.setEnabled(true);
			jtf_address.setEnabled(true);
			jtf_telephone.setEnabled(true);
			jtf_comments.setEnabled(true);
			jtf_relationship.setEnabled(true);
			jtf_birthday.setEnabled(true);
			jbtn_success.setEnabled(true);
			jbtn_delete.setEnabled(true);
			jc_gender.setVisible(true);
			// 선택된 이름의 id 값을 selectID메소드로 불러옵니다. 
			this.id = dao.selectID(jtf_name.getText());
			
			this.setTitle("연락처 수정");
			System.out.println("수정모드로 전환합니다.");
			System.out.println("수정할 id번호는 ===>" +this.id);
		}///////// ========>  수정모드 전환 끝!! 
		
		
		//////////=====> 수정한 내용을 속성값 객체(vo)에 전달 시작!!! 
		else if(jbtn_success==obj) {
			addrvo = new AddrVO();
			// 입력을 위한 dao 를 불러온 뒤 insertDAO라 명명합니다. 
			// updateDAO는 update()메소드를 통해 updateVO를 데이터베이스에 입력합니다. 
			dao = new AddrDAO();
			// 속성값 담당객체는 텍스트필드로 입력받은 값으로 vo의 값을 수정합니다. 
						// 인덱스 id 값은 selectID 메소드에 이름을 넣어서 얻어온 후 넣어줍니다. 
//						int id = updateDAO.selectID(jtf_name.getText());
						System.out.println("변경할 인덱스 번호 => " +this.id);
						
						// vo 에 전달할 차례 
						addrvo.setId(id);
						addrvo.setName(jtf_name.getText());
						addrvo.setAddress(jtf_address.getText());
						// 전화번호 사이 공백을 없애기 위해서 문자 사이의 공백을 없애는 replaceAll()함수를 사용합니다. 
						addrvo.setTelephone(jtf_telephone.getText().replaceAll(" ", ""));
						// 콤보박스에서 선택된 값을 리턴하는 getSelectedItem() 메소드를 사용하여 
						// vo 의 속성값을 전달합니다. 
						addrvo.setGender(jc_gender.getSelectedItem().toString());
						addrvo.setRelationship(jtf_relationship.getText());
						addrvo.setBirthday(jtf_birthday.getText());
						addrvo.setComments(jtf_comments.getText());
						
						// 사용자의 입력으로 속성값이 잘 변경되었는지 확인하기 위해 콘솔창에 출력합니다. 
						System.out.println("수정할 속성값 ==>");
						System.out.print(addrvo.getId()+" ");
						System.out.print(addrvo.getName()+" ");
						System.out.print(addrvo.getAddress()+" ");
						System.out.print(addrvo.getTelephone()+" ");
						System.out.print(addrvo.getGender()+" ");
						System.out.print(addrvo.getRelationship()+" ");
						System.out.print(addrvo.getBirthday()+" ");
						System.out.print(addrvo.getComments()+" ");
					
						int row = dao.update(addrvo, this.id);
						System.out.println("성공적으로 수정되었으면 1 반환 ===> "+row);
						// 서비스 클래스의 insert(); 메소드가 데이터 입력에 성공하면 1을 반환하므로.. 
						if(row == 1) {
							JOptionPane.showMessageDialog
							(this, "연락처 수정이 완료되었습니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
							this.dispose();
						}
		} ///////////=====> 수정 끝! 
		
		///////////=======> 삭제 시작! 
		else if (jbtn_delete == obj) {
				System.out.println("=======  5. 삭제 서비스 시작  =======");
				addrvo = new AddrVO();
				dao = new AddrDAO();
						
				addrvo.setId(this.id);
				System.out.println("삭제할 인덱스 ===> "+id);
						
				int row = dao.delete(addrvo.getId());
				System.out.println("성공적으로 삭제되었으면 1 반환 ====>"+row);
						
				if(row == 1) {
					JOptionPane.showMessageDialog
					(this, "연락처가 삭제되었습니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
				}
		} ////////////=======> 삭제 끝! 
	}
}
