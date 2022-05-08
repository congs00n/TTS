package chap07.polymorphism.exam03;

public class CarExample {

	public static void main(String[] args) {
///// Tire 를 부품으로 가지는 Car 클래스에서 car 객체 생성 
		Car car = new Car(); 
		
		for (int i = 1; i <= 5; i ++ ) {
			int problemLocation = car.run();
		
		
			switch (problemLocation) {
				case 1:
					System.out.println("앞왼쪽 HankookTire로 교체");
					car.frontLeftTire = new HankookTire("앞왼쪽", 15);
					break;
					
				case 2:
					System.out.println("앞오른쪽 HankookTire로 교체");
					car.frontRightTire = new HankookTire("앞오른쪽", 13);
					break;
					
				case 3:
					System.out.println("뒤왼쪽 HankookTire로 교체");
					car.backLeftTire = new HankookTire("뒤왼쪽", 14);
					break;
					
				case 4:
					System.out.println("뒤오른쪽 HankookTire로 교체");
					car.backRightTire = new HankookTire("뒤오른쪽", 17);
					break;	
			}
			System.out.println("--------------------------"); // 1 회전시 출력되는 내용을 구분 
		}
	}

}
