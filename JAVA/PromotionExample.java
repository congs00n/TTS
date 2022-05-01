package chap07.polymorphism.exam01;

class A {}

class B extends A {}
class C extends A {}

class D extends B {}
class E extends C {}



public class PromotionExample {
	public static void main(String[] args) {
		B b = new B ();
		C c = new C ();
		D d = new D ();
		E e = new E ();
		
		// A 부모 타입으로 자동 타입 변환된 이후에는 
		// 부모 클래스에 선언된 필드와 메소드만 접근 가능 !! 
		// 즉, a1. ~~ 로 호출해야 함을 뜻함  !! 
		// 허나, 메소드가 자식 클래스에서 재정의되었다면 자식 클래스의 메소드가 대신 호출 
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		// B, C 는 상속 관계에 있지 않기 때문에 컴파일 에러 
		// B b3 = e;
		// C c2 = d;
		

	}

}

