/****
 * 몸무게 N은 실수이고 키보드로부터 입력받습니다.
출력) 지구몸무게 : 100
     달 몸무게 : 17kg
 */
package memo;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("현재 몸무게를 입력하시오 : " );
		
		double N = scanner.nextDouble();
		
		double weight = N * 0.17;
		
		System.out.println("달에서의 당신의 몸무게는 : " + weight + "kg 입니다. ");
	}

}
