package finalProject;
import java.util.*;

public class Menu {

	public static void main(String[] args) {	
		String menuNum;
		Management management = new Management();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// �޴��� ���
			System.out.println("[Study Cafe]");
			System.out.println("1.����");
			System.out.println("2.����");
			System.out.println("3.������");
			System.out.println("4.����");
			System.out.print("--> ");
			
			// �޴��� �Է¹���
			menuNum = scanner.next();
			System.out.println();
			
			// ���õ� �޴��� �ش� �޼ҵ带 ȣ��
			switch (menuNum) {
			
			// 1. ����
			case "1":
				management.setIn();
				break;
			
			// 2. ����
			case "2":
				management.setOut();
				break;
				
			// 3. ������
			case "3":
				management.admin();
				break;
				
			// 4. ����
			case "4":
				System.out.println("���α׷��� ����˴ϴ�.");
				scanner.close();
				management.scanner.close();
				management.lineScanner.close();
				return;
				
			default:
				System.out.println("1, 2, 3, 4 �� �ϳ��� �Է����ּ���.");
				}
			System.out.println();
			}
		}
	}
