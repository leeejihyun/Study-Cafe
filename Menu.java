package finalProject;
import java.util.*;

public class Menu {

	public static void main(String[] args) {	
		String menuNum;
		Management management = new Management();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// 메뉴를 출력
			System.out.println("[Study Cafe]");
			System.out.println("1.입장");
			System.out.println("2.퇴장");
			System.out.println("3.관리자");
			System.out.println("4.종료");
			System.out.print("--> ");
			
			// 메뉴를 입력받음
			menuNum = scanner.next();
			System.out.println();
			
			// 선택된 메뉴에 해당 메소드를 호출
			switch (menuNum) {
			
			// 1. 입장
			case "1":
				management.setIn();
				break;
			
			// 2. 퇴장
			case "2":
				management.setOut();
				break;
				
			// 3. 관리자
			case "3":
				management.admin();
				break;
				
			// 4. 종료
			case "4":
				System.out.println("프로그램이 종료됩니다.");
				scanner.close();
				management.scanner.close();
				management.lineScanner.close();
				return;
				
			default:
				System.out.println("1, 2, 3, 4 중 하나만 입력해주세요.");
				}
			System.out.println();
			}
		}
	}
