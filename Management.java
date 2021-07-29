package finalProject;
import java.util.*;

// 해당 프로그램 메뉴를 실행하는 클래스
public class Management {
	private int currentNo; // 현재 입장하는 손님이 몇 번째 손님인지 저장하는 변수, 첫번째 손님은 0
	ArrayList<Customer> cst = new ArrayList<Customer>(10);
	SeatManage seatMan = new SeatManage(); // 자리를 관리할 수 있는 seatManage 객체 레퍼런스 seatMan
	Payment pay = new Payment();
	Scanner lineScanner = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);
	
	Management(){
		// 필드값 초기화
		currentNo = 0;
//		System.out.println("currentNo: " + currentNo);
	};
	
	// “1. 입장"을 선택했을 때, 실행되는 메소드(pdf 3페이지 내용에 해당)
	void setIn() {
		// 남은 좌석이 있는 경우
		if (currentNo < 10) {
			
			// 사용자의 이름을 입력받고
			System.out.print("이름을 입력하세요: ");
			String name = lineScanner.nextLine();
			
			for (int i=0; i<cst.size(); i++) {
				if (cst.get(i).name.equals(name)) {
					System.out.println("같은 이름이 있습니다. 다른 이름을 입력해주세요.");
					return;
				}
			}
			
			// seatManager의 print() 호출하여 현재 좌석 상태 표시
			seatMan.print();
			
			// 남은 좌석 수를 알려주고
			System.out.println("현재 남은 좌석은 " + (10 - currentNo) + "석 입니다(V:빈좌석/O:찬좌석).");

			try {
				// 사용자에게 좌석 번호를 입력 받음
				System.out.print("원하는 좌석을 고르세요: ");
				int seatID = scanner.nextInt();
				int x = seatID / 10 - 1;
				int y = seatID % 10 - 1;
				
				// 입력받은 좌석 번호를 매개변수로 seatManager의 setSeat() 호출
				if (seatMan.setSeat(x, y) == true) {
					
					// 사용자 이름 저장
					cst.add(new Customer(name));
					
					// 좌석번호 저장
					cst.get(currentNo).seatID = seatID;
					
					// 입장시간 저장 및 출력
					cst.get(currentNo).startTime = pay.setCheckIn();
					
					// currentNo 증가
					currentNo++;
//					System.out.println("currentNo: " + currentNo);
					}
				}
			
			// 없는 좌석번호인 경우
			catch (ArrayIndexOutOfBoundsException e){
				System.out.println("좌석번호를 잘못 입력하셨습니다.");
				}
			
			// 정수가 아닌 데이터 타입을 입력받았을 경우
			catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				scanner.next();
				}
		}
		
		// 남은 좌석이 없는 경우
		else
			System.out.println("좌석이 모두 찼습니다.");
	};
	
	// "2. 퇴장"을 선택했을 때, 실행되는 메소드(pdf 4페이지 내용에 해당)
	void setOut() {
		// 등록된 손님이 없는 경우
		if (currentNo == 0) 
			System.out.println("좌석이 모두 비어있습니다.");
		
		// 등록된 손님이 있는 경우
		else {
			int i;
			
			// 사용자의 이름을 입력받고, 
			System.out.print("이름을 입력하세요: ");
			String name = lineScanner.nextLine();
			
			// 해당 이름이 cst 몇 번째에 있는지 탐색
			for (i=0; i<cst.size(); i++) {
				if (cst.get(i).name.equals(name)) {
					// 탐색 후, 그 사용자의 좌석 번호를 알아냄
					System.out.println("당신의 좌석번호는 " + cst.get(i).seatID + "입니다.");
					
					// 입력받은 좌석 번호를 매개변수로 seatManager의 releaseSeat() 호출
					int x = cst.get(i).seatID / 10 - 1;
					int y = cst.get(i).seatID % 10 - 1;
					seatMan.releaseSeat(x, y);
					
					// 퇴장시간 저장 및 출력
					cst.get(i).endTime = pay.setCheckOut();
					
					// 사용시간 출력
					System.out.println("사용시간: " + (cst.get(i).endTime - cst.get(i).startTime) + "분");
					
					// 수익 출력
					System.out.println("사용요금: " + pay.calculateFee(cst.get(i).startTime, cst.get(i).endTime) + "원");
					
					// 수익 추가
					Payment.total_Income += pay.calculateFee(cst.get(i).startTime, cst.get(i).endTime);
					
					// cst의 내용도 지우기
					cst.remove(i);
					
					// currentNo 감소
					currentNo--;
//					System.out.println("currentNo: " + currentNo);
					System.out.println("해제되었습니다.");
					
					return;
					}
				}
			// 없는 이름일 경우
			System.out.println("없는 이름입니다.");
			}
		};
	
	// "3.관리자"를 선택했을 때, 실행되는 메소드(pdf 5페이지 내용에 해당)
	void admin() {		
			// 관리자 메뉴 출력
			System.out.println("1.현재 좌석 상태 보기");
			System.out.println("2.전체 좌석 리셋 하기");
			System.out.println("3.손님 현황 보기");
			System.out.println("4.총 수입 확인하기");
			System.out.print("--> ");

			// 메뉴를 입력받음
			String adminMenuNum = scanner.next();
			System.out.println();
			
			switch (adminMenuNum) {
			
			// "1.현재 좌석 상태 보기" 선택 시
			case "1":
				System.out.println("[현재 좌석 상태]");
				
				// seatManager의 print() 호출
				seatMan.print();
				
				// 빈 자리와 찬 자리 수 표시
				System.out.println("찬 좌석: " + (currentNo));
				System.out.println("남은 좌석: " + (10 - currentNo));
				break;
			
			// "2.전체 좌석 리셋 하기" 선택 시,
			case "2":
				// seatManager의 clear() 호출
				seatMan.clear();
				
				// cst의 내용도 지우기
				cst.clear();
				
				System.out.println("모든 좌석이 해제되었습니다.");
				
				// currentNo 리셋
				currentNo = 0;
//				System.out.println("currentNo: " + currentNo);
				break;
				
			// "3. 손님 현황 보기" 선택 시,
			case "3":
				// 좌석번호와 이름 출력
				System.out.format("%8s\t%8s", "좌석번호", "이름");
				System.out.println();
				System.out.println("----------------------------");
				
				for (int i=0; i<cst.size(); i++) {
						System.out.format("%8d\t%8s", cst.get(i).seatID, cst.get(i).name);
						System.out.println();
				}
				break;
				
			// "4. 총 수입 확인하기" 선택 시,
			case "4":
				// 현재 총 수익 출력
				System.out.println("현재 총 수익: " + Payment.total_Income + "원");
				break;
				
			default:
				System.out.println("1, 2, 3, 4 중 하나만 입력해주세요.");
				}
			};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
