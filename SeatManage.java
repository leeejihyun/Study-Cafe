package finalProject;

// 스터디 카페의 좌석을 관리하는 클래스
public class SeatManage {
	boolean setTable[][];
	
	SeatManage(){
		// setTable 배열의 모든 요소를 false로 초기화
		setTable = new boolean[2][5];
	};
	
	// "3.관리자 → 2.전체 좌석 리셋 하기" 메뉴를 선택했을 때 실행하는 메소드
	void clear() {
		// setTable 배열의 모든 요소를 false로 재세팅
		for (int i=0; i<setTable.length; i++)
			for (int j=0; j<setTable[i].length; j++)
				setTable[i][j] = false;
	};
	
	// setTable 배열의 상태를 보이는 메소드
	void print() {
		// 빈 자리(V), 찬 자리(O)로 표시
		// 숫자는 좌석 자리 숫자(첫 숫자:행, 두번째 숫자: 열)
		for (int i=0; i<setTable.length; i++) {
			for (int j=0; j<setTable[i].length; j++) {
				if (setTable[i][j] == true)
					System.out.print("O[" + (i+1) + (j+1) + "]\t");
				else
					System.out.print("V[" + (i+1) + (j+1) + "]\t");
			}
			System.out.println();
		}
	};
	
	boolean setSeat(int x, int y) { 
		// 매개변수는 좌석 번호
		// x는 행(앞에 숫자), y는 열(뒤에 숫자)
		// 사용자(손님)이 선택한 자리를 setTable배열에서 찾아서, 비어있다면 V→O로 변경
		if (setTable[x][y] == false) {
			setTable[x][y] = true;
			System.out.println("선택되었습니다.");
			return true;
		}
		// 차있다면 "이미 사용 중 입니다." 출력
		else {
			System.out.println("이미 사용 중 입니다. 다른 좌석 번호를 입력해주세요.");
			return false;
		}
	};
	
	void releaseSeat(int x, int y) {
		// 매개변수는 좌석번호(setSeat과 같음)
		// 해당하는 좌석번호가 true라면, O→V로 변경
		if (setTable[x][y] == true)
			setTable[x][y] = false;
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
