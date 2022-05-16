package assignment.hap;

/*
-10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하시오.
[요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
음수합 : -24
양수합 : 17
*/

public class ArrayRanHap2 {
	int[] ran = null;
	int sum = 0;
	int i = 0;
	
	// 생성자 > 사용자에 의해 배열의 길이가 정해진다. 
	public ArrayRanHap2 (int[] ran, int n) {
		this.ran = new int[n];
		
		// 채번 후 숫자가 ran[]에 담긴다. 
		System.out.print("랜덤 숫자 => ");
		
		for(i = 0; i < ran.length; i ++) {
			ran[i] = (int)((Math.random()*20)-9);
			System.out.print("'"+ran[i]+"' ");
		}System.out.println(" ");
		
		// ran[] 의 총합 
		for(i =0; i < ran.length; i++) {
			sum+=ran[i];
			System.out.println("배열의 총 합은 : "+sum);
		}
	}
	
}