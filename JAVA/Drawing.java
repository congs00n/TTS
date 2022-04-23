package memo;

class Circle{
	//field
	int sun;
	void call () {
		System.out.println("부모클래스 Circle 의 생성자 sun 을 " + sun + "으로 불러왔어요. ");
		System.out.println("circle클래스 호출 ");
	}
}
class Square extends Circle{
	void call2 () {
		System.out.println("square클래스 호출 ");
	}
	
}


public class Drawing {

	public static void main(String[] args) {
		Square m = new Square(); // 자식클래스에서 객체 생성 
		m.sun = 5;
		m.call(); // 부모클래스에서 생성된 call 메소드가 호출되는 것을 알 수 있다.  
		m.call2(); 
	}
}