/****
 * 필드의 다형성 
 * 
 * 자동 타입 변환이 필요한 이유? 
 */
package chap07.polymorphism.exam03;

public class Tire {

	// 필드 
// 최대회전수 > 타이어의 수명으로 최대 회전수에 도달하면 타이어에 펑크가 난다고 가정  
	public int maxRotation;
// 누적회전수 > 누적회전수가 최대 회전수가 되면 타이어가 펑크 
	public int accumulatedRotation;
// 타이어의 위치 
	public String location; 
	
	// 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	// 메소드 
// 타이어를 1회전 시킨다. 1번실행 시 누적 회전수를 1씩 증가한다. 
// 누적 회전수 < 최대 회전수  => 남은 회전수 출력 
// 누적 회전수 == 최대 회전수 => 펑크를 출력 
// return 타입은 boolean 정상 회전이면 true, 펑크가 나면 false 출력 
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println("타이어의 수명 : " + (maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("타이어 펑크입니다.");
			return false;
		}	
	}
}
