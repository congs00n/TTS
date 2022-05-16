package com.week4.day19.assignment;

public class BaeSuHapWhile {
	
	int number;
	int total;
	
	public int getSumBaeSu() {
		while (number < 100) {
			if (number % 3 == 0) {
				total = total + number;
			}
			number+=1;
		}
		return total;
	}
}
