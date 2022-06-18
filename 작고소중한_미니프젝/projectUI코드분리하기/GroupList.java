package projectUI코드분리하기;

import java.util.ArrayList;

// OnePerson 캡슐 여러 개를 모아놓은 것 
public class GroupList {

	// <OnePerson>타입의 ArrayList gathering을 스택영역에 로드
	// OnePerson 의 객체 하나 하나가 모여서 객체배열 ArrayList<OnePerson> gathering이 된 것.

	// 필드
	private ArrayList<OnePerson> groupList;
	private int current;

// 생성자
	public GroupList() {
		this.groupList = new ArrayList<OnePerson>();
	}

// getter 메소드 
	public ArrayList<OnePerson> getGathering() {
		return groupList;
	}

	/*****
	 * 메소드 구현***** oneperson 신규등록 (등록은 데이터 입력(input) 후 리스트에 추가(add)하는 과정이므로
	 * inputAdd라 하겠음) > 추가된 객체 인덱스 반환 oneperson 삭제 (리스트에서 삭제 > 백업 가능 / 데이터까지 삭제 > 완전
	 * 삭제) oneperson 조회 oneperson 수정
	 **/

	// 내 인덱스 = 추가 직전 gathering 배열의 길이 + 1 = oneperson.index
	public int inputAdd(String name, String phoneNum, String relationship) {

		// 현재 객체 배열의 길이
		int index = this.groupList.size();

		// 데이터를 담은 oneperson 객체 선언하며 데이터 입력 && 리스트에 추가
		// 1.메소드로부터 입력받은 데이터를 생성자를 통해 입력
		OnePerson oneperson = new OnePerson(name, phoneNum, relationship);
		this.groupList.add(oneperson);

		index = this.groupList.indexOf(oneperson);

		// 객체배열에 추가된 인덱스 반환
		return index;
	}

	// 삭제는 다음과 같은 순으로 이루어짐
	// 인덱스로 받아서 삭제할 것인지?
	// 값으로 받아서 삭제할 것인지? -> 중복 값이 있을 경우 첫번째로 찾아진 값만 삭제
	// 삭제할 데이터를 조회(인덱스 반환) -> 리스트에서 뺀다 -> 데이터를 삭제한다.
	public ArrayList<OnePerson> takeOutDelete(int index) {
		this.groupList.remove(index);

		// 삭제되면 삭제된 인덱스 이후의 값들의 인덱스는 모두 -1이 되어야 함.

		// 삭제된 후의 gathering 객체 배열을 반환
		return this.groupList;
	}

	public int size() {
		return current;
	}

}
