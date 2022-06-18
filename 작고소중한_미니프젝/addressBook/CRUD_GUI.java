package addressBook;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/****************************************************
 * 					CRUI_UI 
 * 					( VIEW )
 * 
 * 		사용자가 보는 화면 구성에 쓰일 재료
 * 		 + 그 재료를 사용한 
 * 			입력, 조회, 수정, 삭제 처리
 * 
 * **************************************************/
public class CRUD_GUI extends JFrame implements ActionListener, MouseListener{
	
	// 선언부
	
	/***************DB연동 선언부****************
	 * */
	디비연결담당클래스 		디비연결총괄객체 	= new 디비연결담당클래스();
	Connection 			연결통로			= null;
	PreparedStatement	쿼리전달 			= null;
	ResultSet			커서 				= null;
	
	/*****************UI선언부******************
	 * 버튼 _ Component						 */
	
	JButton 	입력버튼 			= new JButton("+");
	JButton		소유자수정조회버튼 	= new JButton("정콩순"); 
	JLabel 		제목_연락처	 	= new JLabel("		 연락처		");
	ImageIcon 	icon			= new ImageIcon("images/congsoon.png");
	JLabel  	소유자사진			= new JLabel(icon);
	JPanel		제목영역			= new JPanel();
	JPanel		소유자영역			= new JPanel();
	
	
	
	// 생성자 
	public CRUD_GUI() {
		System.out.println("생성자 호출 성공");
		initDisplay();
		
	}
	
	// 화면처리 메소드 21	
	public void initDisplay() {
		this.setBackground(Color.WHITE);
	
		// 컨테이너에 컴포넌트를 붙인다.
		제목영역.add(제목_연락처);
		소유자영역.add(소유자수정조회버튼);
		제목영역.setBackground(Color.LIGHT_GRAY);
		소유자영역.setBackground(Color.DARK_GRAY);
		
		this.add("South", 입력버튼);
		this.add("North", 제목영역);
		this.add("Center", 소유자영역);
		
		this.setSize(400, 600);
		this.setTitle("연락처");
		this.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new CRUD_GUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
