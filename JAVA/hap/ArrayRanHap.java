package assignment.hap;

/*
-10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하시오.
[요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
음수합 : -24
양수합 : 17
*/

public class ArrayRanHap {
	int[] ran = null;
	int sum = 0;
	int i;
	
	// 기본 생성자 > 인스턴스화를 하면 랜덤숫자를 담는 배열 생성 시작
	
	public ArrayRanHap () {
		this.ran = new int[10];
		
		System.out.print("랜덤 숫자 => ");
		for(int i = 0; i < ran.length; i ++) {
			ran[i] = (int)((Math.random()*20)-9);
			System.out.print("'"+ran[i]+"' ");
		}System.out.println(" ");
	}
	
	// 오버 로딩 > 사용자에 의해 배열의 길이가 정해진다. 
	public ArrayRanHap (int[] ran, int n) {
		this.ran = new int[n];
		
		System.out.print("랜덤 숫자 => ");
		for(int i = 0; i < ran.length; i ++) {
			ran[i] = (int)((Math.random()*20)-9);
			System.out.print("'"+ran[i]+"' ");
		}System.out.println(" ");
	}
	
	// 배열의 합을 구해주는 메소드  
	public int plus() {
		for(int i : ran) {
			sum +=i;
		}
		return sum;
	}
}
