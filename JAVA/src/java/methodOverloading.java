package src.Class.Exam01;

class methodOverloading {
	
	// 메소드 오버로딩 
	
	// 하나의 메소드 이름으로 여러 실행을 할 수 있도록 중복해서 정의하는 것
	// 메소드에 사용되는 이름을 절약할 수 있음 
	// 또한 호출할 때 전달해야 할 매개변수의 타입이나 개수를 신경쓰지 않고 호출할 수 있다.  
	
	// 조건
	// 매개변수의 개수와 타입과 개수가 달라야 한다. 
	
	
	static void display (String name) {
		System.out.println(name);
	}
	static void display (int a, double b) {
		System.out.println(a + b);
	}
	static void display (double a, double b ) {
		System.out.println(a );
	}

public static class Test {
		public static void main(String[] args) {
			methodOverloading method = new methodOverloading();
			
			// 입력된 매개변수의 타입과 개수에 따라 적절한 메소드를 찾아 호출 > 실행  
			method.display("콩순"); 
			
			method.display(1, 0.5);
			
			method.display(1, 1);
		}

	}
}
