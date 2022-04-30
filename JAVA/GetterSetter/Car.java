package chap06.exam06;

////////////////////// Getter와 Setter 메소드 선언 

public class Car {
	
	// 필드
	private int speed;
	private boolean stop;
	
	// 생성자
	
	// 메소드
	// speed값을 읽어오는 메소드 
	// (읽어온다고 생각)
	public int getSpeed() {
		return speed;
	}
	// 매개변수로 speed값을 받고 
	// speed 값이 0보다 작으면 0을
	// 아니면 제 값을 반환하는 메소드 
	public void setSpeed(int speed) {
		if(speed<0) {
			this.speed = 0;
			return;
			}else {
				this.speed = speed; 	// 필드값 자체를 변경한다. 
			}
	}
	// 필드값 stop을 읽어오는 메소드  
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
