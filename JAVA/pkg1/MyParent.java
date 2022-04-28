package pkg1;

public class MyParent {
	private 		int prv;
					int dft;
	protected 		int prt;
	public 			int pub;
}

class MyParentTest {
 
	public static void main(String[] args) {
		MyParent p = new MyParent();
		//System.out.println(p.prv);	// private 이므로 다른 클래스에서 접근 불가 >> 에러 
		System.out.println(p.dft);	// default 이므로 같은 패키지 내에서 접근 가능 
		System.out.println(p.prt);	// protected 이므로 같은 패키지 + 다른 패키지의 자손 
		System.out.println(p.pub);	// public 이므로 접근 제한이 없음  
	}

}
