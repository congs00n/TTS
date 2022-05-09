package chap07.interFace.exam01;

// 국민은행은 Bank 인터페이스의 가이드라인을 따르겠다!!
public class KBBank implements Bank {
	
		@Override
		public void withDraw(int price) {
			System.out.println("KB은행만의 인출 로직...");
			if (price < Bank.MAX_INTEGER) {
						System.out.println(price+" 원을 인출합니다. ");
			}else {
						System.out.println(price+" 원을 인출하는데 실패했습니다. ");
			}
		}
		
		@Override
		public void deposit(int price) {
			System.out.println("KB은행만의 입금 로직..."+price+" 원을 입금한다.");
		}
}
