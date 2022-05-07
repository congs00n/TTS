package project;

import java.util.Scanner;

public class CalcTest {
	
	public static void main(String[] args) {
		CalculatorEXe display = new CalculatorEXe ();
		
		display.message();
		display.inputM1();
		display.input();
		
		
		////////////////////////////////////////////// 여기서부터 출력이 안 됨. 
		///// equals() 메소드 사용 
			if (display.result.equals(display.m1[0])) {
					display.plus();
			}
			if (display.result.equals(display.m1[1])) {
					display.minus();
			}
			if (display.result.equals(display.m1[2])) {
					display.multi();
			}
			if (display.result.equals(display.m1[3])) {
					display.divide();
			}
	}
	
}
class Calculator  {
		Scanner scanner = new Scanner(System.in);
	
		//field
	public String result;
	
	String[] m1 = new String[] {"더하기", "빼기", "곱하기", "나누기"};			
		
		//Method
	void message () {
		System.out.println("1. 계산기 시작! 무엇을 하시겠습니까? ");
		for (int i = 0; i < m1.length; i ++ ) {
				System.out.print(m1[i]);
			}
		}
	
	void inputM1 () {
		Scanner scanner = new Scanner(System.in);
		this.result = scanner.next();
		System.out.println("2." + result + "선택 ");
	}
	
}

class CalculatorEXe extends Calculator {
	
	double x;
	double y;
	
	void input () {
		System.out.println("숫자 두 개를 입력하시오. ");
		x = scanner.nextDouble();
		y = scanner.nextDouble();
	}
	public void plus ( ) {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
	public void minus () {
		 System.out.println(x + " - " + y + " = " + (x - y));
	 }
	public void multi () {
		 System.out.println(x + " * " + y + " = " + (x * y));
	}
	public void divide () {
		 System.out.println(x + " / " + y + " = " + (x / y));
	}
}

