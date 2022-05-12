package com.week4.day19.assignment;

	public class BaeSuHap_Ex {
		
		public static void main(String[] args) {
				int result;
				
				BaeSuHapFor bs = new BaeSuHapFor();
				BaeSuHapWhile bswhl = new BaeSuHapWhile ();
				
			// for문 이용
				result = bs.getSumBaesu(1, 0, 3);
				System.out.println("1~100까지의 수 중 3의 배수의 합 ===> "+result);
			
			// while문 이용 
				result = bswhl.getSumBaeSu();
				System.out.println("1~100까지의 수 중 3의 배수의 합 ===> "+result);
		}
		
	}


