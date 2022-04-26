package BaekJoon;

public class JeongSooNgaeHap {
	
	long sum(int[] a) {					// int[] a 를 매개변수로 가지는 sum 함수 선언부 
		long result = 0; 				// 누적해서 더해줄 result 변수 
		
		for (int i =0; i < a.length; i ++)	// 배열의 길이만큼 더해
			result += a[i];
		return result;
	}
}
