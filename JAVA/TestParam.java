package src;

class Param {
	int ival; // 전역변수는 초기화 안해도 ㅇㅋ 
}

public class TestParam {
	void effectParam(Param p) { //param이 참조하는 객체 p를 받겠다.  
		p = new Param();
		p.ival = 300;
		System.out.println("sub ival : "+p.ival); // 300이 찍힐 것이다.  
	}

	public static void main(String[] args) {
		TestParam tp = new TestParam (); // 나 자신에 대한 인스턴스화이다.  왜? effectParam메소드를 호출하기 위해서입니다.  
		Param p = new Param();
		p.ival = 500;
		tp.effectParam(p); // () 안에 아무것도 안쓰면 문법 에러 발생 type 에러!! 
		System.out.println("main ival : " + p.ival); //300
	}

}
/**
 * 16번에서는 15번에서 인스턴스화 된 클래스의 전역변수인 ival변수에 
 * 초기값이 0 대신 500으로 덮어쓰기가 발생함 
 * 17번의 메소드를 경유하게 되는데 이때 15번에서 정의된 객체의 주소번지를 가지고 8번으로 진입
 * 8번의 지역변수 p와 15번의 주소번지는 같습니다. 
 * 따라서 9번 변수의 300은 전역변수 ival에 대입이 되므로 300이 출력이 된다. 
 *  9  **/
