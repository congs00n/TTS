package com.week4.day20.assignment;

public class GuguDan {
	int[] gu;
	
	//시작 단
	int n;
	//끝 단
	int m;
	
// 메인 클래스에서 인스턴스화를 하면 자동으로 gu배열 생성
// 사용자로부터 n과 m 값을 받겠다. 
	public GuguDan(int n, int m) {
		
		this.gu = new int[] {1,2,3,4,5,6,7,8,9};
		this.n = n;
		this.m = m;
		multiple();
		
	}

// 곱셈 기능을 할 메소드 
	public void multiple() {
		for(int i = n; i < m+1; i++) {
			
			System.out.println("======== "+i+" 단 Start~! =======");

			for(int j = 0; j < gu.length; j++) {
				
				// 시작단부터 끝단까지 gu 배열의 인덱스 반복해서 곱하기 
				System.out.println(i+" * "+(j+1)+" = "+ i * gu[j]);
			}
		}
	}

}
