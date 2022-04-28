package com.makeUI;

import javax.swing.JFrame;

public class Window extends JFrame {
	// 생성자 만들기 
	Window () {
		setTitle("Cong's BLOG");
		// 창을 닫으면 프로그램이 정상적으로 종료가 되도록 함 **
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		// 창의 크기 변경 권한을 줌 > 변경 가능(true), 변경 불가(false) 
		setResizable(false);
		setSize(600,600);
	}
}
