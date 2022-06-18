package projectUI코드분리하기;

public class OnePerson {

	//필드
	private String name;
	private String phoneNum;
	private String relationship;
	
	/**기본 생성자 
* 객체 생성 이후, 초기 입력 받기 전 null 일 경우 방지용 > 즉, db에서 조회했을 때 null이 뜰 것을 방지 
* index는 자동 설정, name, phoneNum, relationship을 주소록 관리자 로부터 입력받음 
	**/
	public OnePerson () {
		this.name = "";
		this.phoneNum = "";
		this.relationship = "";
	}
	
	public OnePerson (String name, String phoneNum, String relationship) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.relationship = relationship;
	}
	
/** 메소드 
* OnePerson의 데이터가 private 이기 때문에 getter을 이용해 읽어올 수 있도록 한다.  
* Group 리스트의 수정되는 객체의 인덱스를 받아서 수정한 뒤, 인덱스를 사용해서 다시 Group 리스트에 add 해줄 생각
**/
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String getRelationship() {
		return relationship;
	}
	
	public int setName (int index, String name) {
		this.name = name;
		return index;
	}

	public int setPhoneNum (int index, String phoneNum) {
		this.phoneNum = phoneNum;
		return index;
	}
	
	public int setRelationship (int index, String relationship) {
		this.relationship = relationship;
		return index;
	}
}
