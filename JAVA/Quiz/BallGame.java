package ballGame;

import java.util.Scanner;

public class BallGame {

	public static void main(String[] args) {
		
		// 게임 횟수 > 0이 되면 "Game Over"
		int cnt = 10;
		
		int ball = 0;
	
		int strike = 0;
		
		// 게임의 루프를 돌릴 변수 
		boolean isInitGame = false;
		boolean isPlaying = false;
		
		int[] ranNum = new int[3];
		int[] usrNum = new int[3];
		
		Scanner in = new Scanner(System.in);

		
// 1. 랜덤 숫자 채번 
//				단, 게임의 첫 시작에만 뽑고 갱신 X 
		while (!isInitGame && cnt > 0) {
			ball = 0;
			strike = 0;
			
			for(int i = 0; i < ranNum.length; i ++) {
				ranNum[i] =((int) (Math.random() * 9) + 1);
					for (int j = 0; j < i; j ++) {
						// 중복 제거 
						if (ranNum[i] == ranNum[j])
								i --;
								break;
				}	
			} 
		}
		
// 2. 사용자로부터 숫자 입력받기 
//						횟수가 남아있을 때만 실행 
		while (cnt > 0) {
			
			while (!isPlaying) {
				for(int i = 0; i < usrNum.length; i ++) {
					usrNum[i] = in.nextInt();
					if (usrNum[0] == usrNum[1] || usrNum[1] == usrNum[2] || usrNum[0] == usrNum[2]) {
						System.out.println("서로 다른 수를 입력하세요.");
						i --; 
					}
				}
			}
		}
		System.out.println("입력 숫자 : " + usrNum[0]+" " + usrNum[1] + " " + usrNum[2]);
		
		
// 3. 숫자 비교하기 
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j<i; j ++) {
				
				// 숫자가 같을 때 
				if(ranNum[i] == usrNum[j]) {
				// 인덱스도 같을 때 
					if(i == j)
						strike ++;
				// (숫자같을 때) - (인덱스 같을 때) = 숫자만 같을 때 
					else {
						ball ++;
					}
				}
			}
		}

// 4. 정답 확인 
//		정답인 경우 
		cnt --;
		if (strike == 3) {  
			System.out.println("총 3 스트라이크입니다. 축하합니다! "); 
			return;
		}else if (cnt == 0) {
			System.out.println("Game Over.");
		}else {
			System.out.println("ball : " + ball + "strike : " + strike + "남은횟수 : " + cnt + "");
			isPlaying = false;
		}
			ball = 0;
			strike = 0;
		

		if (strike == 3 || cnt == 0) {
			System.out.println("재도전 하시겠습니까? 재도전 '1' or 그만하기 '2' ");
			if(in.nextInt() == 1) { 
				isInitGame = false;
				isPlaying = false;
				cnt = 10;
			}
			else {
				isPlaying = true;
			}
		}
		System.out.println("게임 종료 ");
	}
}

