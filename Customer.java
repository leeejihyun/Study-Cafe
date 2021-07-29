package finalProject;

// 사용자(손님)의 정보를 가지는 클래스
public class Customer extends Person {
	int seatID; // 좌석번호
	long startTime; // 입장시간
	long endTime; // 퇴장시간
	
	Customer(String name){
		super(name);
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
