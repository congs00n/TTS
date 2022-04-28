package pkg2;

import pkg1.MyParent; // ctrl + shift + O

class MyChild extends MyParent{ // import를 안해서 생기는 오류 
	public void printMembers() {
		//System.out.println(prv); // 부모 클래스의 prv가 private이므로 오류  
		//System.out.println(dft); // 부모 클래스의 dfr가 default이므로 오류  
		System.out.println(prt); // Ok 부모 클래스와 다른 패키지지만 자손패키지이므로 
		System.out.println(pub);
	}
}
public class MyClassTest2 {
	
	public static void main(String[] args) {
		MyParent p = new MyParent();
		//System.out.println(p.prv); 
		//System.out.println(p.dft); 
		//System.out.println(p.prt); // prt는 완전히 다른 패키지이고, 자손도 아니므로 오류  
		System.out.println(p.pub); // pub는 접근제한이 없으므로 ok 
	}

}
