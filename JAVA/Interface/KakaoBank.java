package chap07.interFace.exam01;


// Bank 인터페이스의 가이드라인을 따르지 않고 자신만의 메소드를 구현 
// 이는 금융결제원에서 제공해주는 그 어떠한 서비스도 사용할 수 없기에 호환성이 없고 연동이 불가  > Main 에서 확인..
public class KakaoBank {
		
		public void kakaoWithDraw(int price) {
			System.out.println("kakao 은행만의 인출 로직...");
			System.out.println(price+" 원을 인출한다. ");
		}
		
		public void kakaoDeposit(int price) {
			System.out.println("kakao 은행만의 입금 로직..." +price+"원을 입금한다.");
		}
		
		public void kakaoFindDormancyAccount() {
			System.out.println("kakao은행만의 휴면계좌 찾아주기 로직");
		}
}
