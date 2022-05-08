package chap07.polymorphism.exam03;

// Tire 클래스를 상속받는 HankookTire 클래스 
public class HankookTire extends Tire{
	
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
		
	}
	//roll 메소드는 재정의되어 정상 회전과 펑크가 났을 때 출력하는 내용이 Tire클래스의 roll()메소드와 다름. 
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println("HankookTire 수명 : " + (maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("타이어 펑크입니다.");
			return false;
		}
	}
	
}
