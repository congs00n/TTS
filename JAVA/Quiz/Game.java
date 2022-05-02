package src.Class.Quiz;

import java.util.Scanner;
public class Game {

		void gameTest() {
			Scanner scanner = new Scanner(System.in);
			int num = (int) (Math.random() * 10); // num = 1~9
			for(int i = 1; i < 6; i ++) {
				int input = scanner.nextInt();
				
				if (num == input) {
					System.out.println("맞았습니다!");
					return;
				}
				else {
					System.out.println("다시 입력하세요. (남은 횟수 : " + (5 - i) + "/5)");
				}
			}
		}
	}

