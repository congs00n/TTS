package BaekJoon;

import java.util.Scanner;
public class OXquiz {

	public static void main(String[] args) {
		int sum = 0;
		int cnt = 0;
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		String[] quiz = new String[n];
		
		for (int i = 0; i < quiz.length; i ++) {
			quiz[i] = scanner.next();
		}
		
	
		for (int i = 0; i < n; i ++) {
			for(int j = 0; j < quiz[i].length(); j ++) {
				if (quiz[i].charAt(j) == 'O') {
					cnt = cnt + 1;
				}
				else {
					cnt = 0;
				}
				sum = sum + cnt;
		}
			System.out.println(sum);
		}

	}
}
