package com.week4.day17.test01;
/**Q. 
 *자바 성적을 난수를 발생하여 5개 받은 후 
 *총점, 평균, 석차를 구하는 프로그램을 작성.*/

import java.util.Random;

public class RanArrayNum {
	
	Random random = new Random();
	int[] jumsu = new int[5];
	
		// 성적의 총점 
			int sum;	
			
		// 성적의 평균
			double avg;
			
		// 성적 석차 (점수 간)
			int[] rank = new int[5];
			

		// 총점을 구하는 메소드 
			public void jumsuSum() {
				for (int i = 0; i < jumsu.length; i ++) {
					jumsu[i] = random.nextInt(101);
					sum = sum + jumsu[i];
				}
				System.out.println("총점 : " + sum);
			}
			
		// 평균 성적을 구해주는 메소드 
			public void jumsuAvg() {
				avg = sum / 5;
				System.out.println("평균 : " + avg);
			}
			
		// 석차를 구하는 메소드 
			public void jumsuRank() {
				
				for (int i = 0; i < rank.length; i ++) {
					rank[i] = 1;
				}
				
				for(int i = 0; i < jumsu.length; i ++) {
					for (int j = 0; j < jumsu.length; j ++) {
						if (jumsu[i]<jumsu[j]) {
							rank[i] ++;
						}
					}	
				}
				for (int i = 0; i < rank.length; i ++) {
					System.out.println("석차 : " + rank[i] + " 등 ( 점수 : " + jumsu[i]+" )");
				}
				
			}
	}
