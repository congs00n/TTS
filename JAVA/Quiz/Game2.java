package chap06.Quiz;

import java.util.Scanner;
public class Game {

		void gameTest() {
			Scanner scanner = new Scanner(System.in);
			int num = (int) (Math.random() * 10); // num = 0~9
			for(int i = 1; i < 6; i ++) {///////////////////////// 채번 기회 : 다섯 번 
				int input = scanner.nextInt();
				
				if (num == input) {
					System.out.println("맞았습니다!");
					return;
				}
				else if (num > input) {
					System.out.println("다시 입력하세요. (남은 횟수 : " + (5 - i) + "/5)");
					System.out.println("힌트! : 숫자를 좀 높여볼까요^^? ");
				}
				else {
					System.out.println("다시 입력하세요. (남은 횟수 : " + (5 - i) + "/5)");
					System.out.println("힌트! : 숫자를 좀 낮춰볼까요^^? ");
				}
			}
		}
	}

