package com.week4.day20.assignment;

import java.util.Scanner;
public class GuguDanEx {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("구구단 시작! 시작 단과 끝 단을 입력해 주세요!");
		int n = in.nextInt();
		int m = in.nextInt();
		GuguDan gugu = new GuguDan(n,m);

	}

}
