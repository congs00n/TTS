package src;

class Dog{int leg = 0;}

public class Parameter_0 {
	//method
	
	// Dog 클래스의 leg값을 2로 변경해주는 메소드 
	static void methodA(Dog myDog) {
		System.out.println(myDog.leg);
		myDog.leg = 2; 
	}
	
	public static void main(String[] args) {
		Dog myDog = new Dog();
		myDog.leg = 4;
		methodA(myDog); 		// leg값이 2로 변경이 됨 
		System.out.println(myDog.leg);
	}

}
