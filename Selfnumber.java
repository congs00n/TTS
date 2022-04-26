package BaekJoon;

public class Selfnumber {

	static int d(int n) {
		//////메소드 d가 이해가 안감 
		int self = n;
		
		while (n>0) {
			self = self + (n%10);
			n = n/10;
		} 
		return self;
	}
	public static void main(String[] args) {
		
		boolean[] nums = new boolean[10001];
		
		for (int i = 0; i < nums.length; i ++) {
			if(d(i) < 10001) {
				nums[d(i)] = true;
			}
		}
		for (int i = 0; i < nums.length; i ++) {
			if(nums[i] == false) {
				System.out.println(i);
			}
		}
	}

}
