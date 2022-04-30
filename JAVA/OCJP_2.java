package com.day10;

class A {
	
	// Cocstructor
	public A() {					// 기본 생성자 구현 
		
	}
	
	// Method
	public A(String msg) { 			// msg를 받고  
		System.out.println(msg);	// msg를 호출할 거야 
	}
}

class B extends A {
	/** 							Error !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
	 * 									Implicit super constructor PArernt() is undefined.
	 * 									Must explicitly invoke another constructor. 
	 * 								why? 
	 *  								부모 클래스에 기본 생성자가 없는 클래스를 상속받는 경우 슈퍼클래스의 생성자를 호출해야 한다. 
	 *								so?
	 *  								(1) 자식클래스에서 부모 클래스의 생성자를 호출하는 방법으로 해결한다. 
	 *  								(2) 부모 클래스에 기본 생성자를 구현하는 방법으로 해결한다. 
	 * **/
	public B(String msg) {
		
	}
}
public class OCJP_2 {
	
	static class B extends A {
		public B(String msg) {
			System.out.println(msg + "from here");
		}
	}
	public static void main(String[] args) {
		A a = new B("hello");

	}

}
