package com.week4.day19.assignment;

//1~100에 사용자가 정의한 'n수' 의 배수의 합을 구하는 메소드 
public class BaeSuHapFor {
	
	public int getSumBaesu(int number, int total, int n) {
		
		for (number = 1; number <= 100; number++) {
			if(number % n == 0) {
				total = total + number;
			}
		}return total;
	}
		
}


	
		
		
