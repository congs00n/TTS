package src.Class.Exam01; 

class point extends Object {
	int x;
	int y;
	
	// 생성자 
	point(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "toString 호출 성공 " +x + y;
	}
}
public class methodOverriding {

	public static void main(String[] args) {
		point p = new point(3, 5);
		System.out.println(p);
	}

}
// p.x = 3;
// p.y = 5;
// System.out.println(p.toString); 대신 p로 쓰면 간편함 
