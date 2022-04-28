package com.makeUI;

import javax.swing.JButton; 					// 사용자가 버튼으로 클릭하기 위해 생성 > 클릭했을 때 일어나는 동작을 정의해 주어야 함 
import javax.swing.JFrame;
public class JButtonTest_1 {
												// 메인메소드 
	public static void main(String[] args) {
			JFrame f1 = new JFrame();
			JButton b1 = new JButton("CLICK");
			b1.setBounds(100, 100, 100, 40);
			
			f1.add(b1);							// 버튼의 인스턴스를 add한다. 
			f1.setSize(300, 400);				// 윈도우의 사이
			f1.setLayout(null);					// 레이아웃의 관리자가 없으면 null이다.
			f1.setVisible(true);				// setVisible이 true면 창을 그린다. 

	}

}
