package chap06.string;

import java.util.Scanner;

class ChildrenzDay {
	
	String text;

	ChildrenzDay (String text) {
	this.text = text;
	}

}


public class ChildrenzDayExe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ChildrenzDay days = new ChildrenzDay("어린이날");
		String newTxt = days.text; 
		
		if(scanner.next().equals(newTxt)) {
			System.out.println("화면에 라이언을 그리세요..");
		}
		
		
	}

}
