package clone_project;

// 주소록에서 개인의 정보(이름, 아이디, 주소, 전화번호 등)를 저장하기 위해 personal클래스를 생성
// 그럼 나는? 확장! 이런 개인 클래스가 모여있는 클래스의 집합인 컬랙션 프레임워크 map으로 확장해 보아야 겠구나~
public class CongSoon {
	// field > private ? 외부에서 정보에 접근해서 함부로 변경하지 못하게! 
	private String id;
	private String name;
	private String address;
	private String relationship;
	private String birthday;
	private String comment;
	private String registerDate;
	
	// 디폴트생성자 
	public CongSoon() {
		this.id = "";
		this.name = "";
		this.address = "";
		this.relationship = "";
		this.birthday = "";
		this.comment = "";
		this.registerDate = "";
	}
	
	// constructor > CongSoon 객체 생성하면 필드의 변수에 대입할 준비가 됨
	public CongSoon(String id, String name, String address, String relationship,
			String birthday, String comment, String registerDate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.relationship = relationship;
		this.birthday = birthday;
		this.comment = comment;
		this.registerDate = registerDate;
	}
	
	// private로 필드를 설정해줬기에 필드의 값을 읽어오기 위해서는 getter 메소드로 this.필드값을 반환해준다. 
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getRelationship() {
		return this.relationship;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public String getRegisterDate() {
		return registerDate;
	}

///////////////// setter
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

}
