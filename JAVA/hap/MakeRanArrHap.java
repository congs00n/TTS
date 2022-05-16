package assignment.hap;

import java.util.Scanner;

public class MakeRanArrHap {

	public static void main(String[] args) {

		
		// 사용자가 지정해준 길이의 배열 생성 
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 길이를 입력하시오 : ");
		int n = sc.nextInt();
		
		// 랜덤 배열이 화면에 표시 
		ArrayRanHap sec	= new ArrayRanHap (new int[n], n);
		
	}
}


