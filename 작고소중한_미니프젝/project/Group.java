package project;

import java.util.ArrayList;

public class Group {

	// <OnePerson>타입의 ArrayList gathering을 스택영역에 로드 
	// OnePerson 의 객체 하나 하나가 모여서 객체배열 ArrayList<OnePerson> gathering이 된 것.  
	
	// 필드 
	private ArrayList<OnePerson> gathering;

// 생성자
	public Group() {
		this.gathering = new ArrayList<OnePerson>();
	}

// getter 메소드 
	public ArrayList<OnePerson> getGathering() {
		return gathering;
	}	
/*****메소드 구현*****
 ***oneperson 신규등록 (등록은 데이터 입력(input) 후 리스트에 추가(add)하는 과정이므로 inputAdd라 하겠음) > 추가된 객체 인덱스 반환 
 ***oneperson 삭제 (리스트에서 삭제 > 백업 가능 / 데이터까지 삭제 > 완전 삭제)
 ***oneperson 조회
 ***oneperson 수정
 **/
	
/*-----add와 input 분리할 것  -------------------------------------------------*/
	// 내 인덱스 = 추가 직전 gathering 배열의 길이 + 1  = oneperson.index
	public int inputAdd(String name, String phoneNum, String relationship) {
		
		// 현재 객체 배열의 길이
		int index = this.gathering.size();
		
		// 데이터를 담은 oneperson 객체 선언하며 데이터 입력 && 리스트에 추가 
		// 1.메소드로부터 입력받은 데이터를 생성자를 통해 입력 
		OnePerson oneperson = new OnePerson(name, phoneNum, relationship);
		this.gathering.add(oneperson);
		
		index = this.gathering.indexOf(oneperson);
		
		// 객체배열에 추가된 인덱스 반환 
		return index;
	}
	
	// 삭제는 다음과 같은 순으로 이루어짐 
	// 인덱스로 받아서 삭제할 것인지? 
	// 값으로 받아서 삭제할 것인지? -> 중복 값이 있을 경우 첫번째로 찾아진 값만 삭제
	// 삭제할 데이터를 조회(인덱스 반환) -> 리스트에서 뺀다 -> 데이터를 삭제한다. 

	
/*----------get과 print 분리-------------------------------------------------*/
public ArrayList<OnePerson> takeOutDelete(int index) {
		this.gathering.remove(index);
		
		// 삭제되면 삭제된 인덱스 이후의 값들의 인덱스는 모두 -1이 되어야 함. 
		
		// 삭제된 후의 gathering 객체 배열을 반환 
		return this.gathering;
	}

// 사용자가 입력한 객체의 인덱스 값을 받아서 그 인덱스가 가리키는 객체를 반환 
public int get(int index) {
	return this.get(index);
}

	 
}
