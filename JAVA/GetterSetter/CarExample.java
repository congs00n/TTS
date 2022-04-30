package chap06.exam06;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		// 잘못된 속도를 조건에 맞게 변경 >> 변경은 set
		myCar.setSpeed(-50);
		
		// set 으로 변경한 필드값 읽어오는 메소드 
		System.out.println("현재 속도 : " + myCar.getSpeed()); 
		
		// 조건에 맞는 속도 변경 >> 변경은 set 
		myCar.setSpeed(100);
		
		/**
		 * stop필드의 getter(isStop())리턴값이 false일 경우, 
		 * 자동차를 멈추기 위해 Setter(setStoop(true))를 호출해서
		 * stop 필드를 true로, speed필드를 0으로 변경한다. **/
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("현재속도 : " + myCar.getSpeed());
	}

}
