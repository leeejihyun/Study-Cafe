package finalProject;
import java.util.*;

// �ش� ���α׷� �޴��� �����ϴ� Ŭ����
public class Management {
	private int currentNo; // ���� �����ϴ� �մ��� �� ��° �մ����� �����ϴ� ����, ù��° �մ��� 0
	ArrayList<Customer> cst = new ArrayList<Customer>(10);
	SeatManage seatMan = new SeatManage(); // �ڸ��� ������ �� �ִ� seatManage ��ü ���۷��� seatMan
	Payment pay = new Payment();
	Scanner lineScanner = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);
	
	Management(){
		// �ʵ尪 �ʱ�ȭ
		currentNo = 0;
//		System.out.println("currentNo: " + currentNo);
	};
	
	// ��1. ����"�� �������� ��, ����Ǵ� �޼ҵ�(pdf 3������ ���뿡 �ش�)
	void setIn() {
		// ���� �¼��� �ִ� ���
		if (currentNo < 10) {
			
			// ������� �̸��� �Է¹ް�
			System.out.print("�̸��� �Է��ϼ���: ");
			String name = lineScanner.nextLine();
			
			for (int i=0; i<cst.size(); i++) {
				if (cst.get(i).name.equals(name)) {
					System.out.println("���� �̸��� �ֽ��ϴ�. �ٸ� �̸��� �Է����ּ���.");
					return;
				}
			}
			
			// seatManager�� print() ȣ���Ͽ� ���� �¼� ���� ǥ��
			seatMan.print();
			
			// ���� �¼� ���� �˷��ְ�
			System.out.println("���� ���� �¼��� " + (10 - currentNo) + "�� �Դϴ�(V:���¼�/O:���¼�).");

			try {
				// ����ڿ��� �¼� ��ȣ�� �Է� ����
				System.out.print("���ϴ� �¼��� ������: ");
				int seatID = scanner.nextInt();
				int x = seatID / 10 - 1;
				int y = seatID % 10 - 1;
				
				// �Է¹��� �¼� ��ȣ�� �Ű������� seatManager�� setSeat() ȣ��
				if (seatMan.setSeat(x, y) == true) {
					
					// ����� �̸� ����
					cst.add(new Customer(name));
					
					// �¼���ȣ ����
					cst.get(currentNo).seatID = seatID;
					
					// ����ð� ���� �� ���
					cst.get(currentNo).startTime = pay.setCheckIn();
					
					// currentNo ����
					currentNo++;
//					System.out.println("currentNo: " + currentNo);
					}
				}
			
			// ���� �¼���ȣ�� ���
			catch (ArrayIndexOutOfBoundsException e){
				System.out.println("�¼���ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}
			
			// ������ �ƴ� ������ Ÿ���� �Է¹޾��� ���
			catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���.");
				scanner.next();
				}
		}
		
		// ���� �¼��� ���� ���
		else
			System.out.println("�¼��� ��� á���ϴ�.");
	};
	
	// "2. ����"�� �������� ��, ����Ǵ� �޼ҵ�(pdf 4������ ���뿡 �ش�)
	void setOut() {
		// ��ϵ� �մ��� ���� ���
		if (currentNo == 0) 
			System.out.println("�¼��� ��� ����ֽ��ϴ�.");
		
		// ��ϵ� �մ��� �ִ� ���
		else {
			int i;
			
			// ������� �̸��� �Է¹ް�, 
			System.out.print("�̸��� �Է��ϼ���: ");
			String name = lineScanner.nextLine();
			
			// �ش� �̸��� cst �� ��°�� �ִ��� Ž��
			for (i=0; i<cst.size(); i++) {
				if (cst.get(i).name.equals(name)) {
					// Ž�� ��, �� ������� �¼� ��ȣ�� �˾Ƴ�
					System.out.println("����� �¼���ȣ�� " + cst.get(i).seatID + "�Դϴ�.");
					
					// �Է¹��� �¼� ��ȣ�� �Ű������� seatManager�� releaseSeat() ȣ��
					int x = cst.get(i).seatID / 10 - 1;
					int y = cst.get(i).seatID % 10 - 1;
					seatMan.releaseSeat(x, y);
					
					// ����ð� ���� �� ���
					cst.get(i).endTime = pay.setCheckOut();
					
					// ���ð� ���
					System.out.println("���ð�: " + (cst.get(i).endTime - cst.get(i).startTime) + "��");
					
					// ���� ���
					System.out.println("�����: " + pay.calculateFee(cst.get(i).startTime, cst.get(i).endTime) + "��");
					
					// ���� �߰�
					Payment.total_Income += pay.calculateFee(cst.get(i).startTime, cst.get(i).endTime);
					
					// cst�� ���뵵 �����
					cst.remove(i);
					
					// currentNo ����
					currentNo--;
//					System.out.println("currentNo: " + currentNo);
					System.out.println("�����Ǿ����ϴ�.");
					
					return;
					}
				}
			// ���� �̸��� ���
			System.out.println("���� �̸��Դϴ�.");
			}
		};
	
	// "3.������"�� �������� ��, ����Ǵ� �޼ҵ�(pdf 5������ ���뿡 �ش�)
	void admin() {		
			// ������ �޴� ���
			System.out.println("1.���� �¼� ���� ����");
			System.out.println("2.��ü �¼� ���� �ϱ�");
			System.out.println("3.�մ� ��Ȳ ����");
			System.out.println("4.�� ���� Ȯ���ϱ�");
			System.out.print("--> ");

			// �޴��� �Է¹���
			String adminMenuNum = scanner.next();
			System.out.println();
			
			switch (adminMenuNum) {
			
			// "1.���� �¼� ���� ����" ���� ��
			case "1":
				System.out.println("[���� �¼� ����]");
				
				// seatManager�� print() ȣ��
				seatMan.print();
				
				// �� �ڸ��� �� �ڸ� �� ǥ��
				System.out.println("�� �¼�: " + (currentNo));
				System.out.println("���� �¼�: " + (10 - currentNo));
				break;
			
			// "2.��ü �¼� ���� �ϱ�" ���� ��,
			case "2":
				// seatManager�� clear() ȣ��
				seatMan.clear();
				
				// cst�� ���뵵 �����
				cst.clear();
				
				System.out.println("��� �¼��� �����Ǿ����ϴ�.");
				
				// currentNo ����
				currentNo = 0;
//				System.out.println("currentNo: " + currentNo);
				break;
				
			// "3. �մ� ��Ȳ ����" ���� ��,
			case "3":
				// �¼���ȣ�� �̸� ���
				System.out.format("%8s\t%8s", "�¼���ȣ", "�̸�");
				System.out.println();
				System.out.println("----------------------------");
				
				for (int i=0; i<cst.size(); i++) {
						System.out.format("%8d\t%8s", cst.get(i).seatID, cst.get(i).name);
						System.out.println();
				}
				break;
				
			// "4. �� ���� Ȯ���ϱ�" ���� ��,
			case "4":
				// ���� �� ���� ���
				System.out.println("���� �� ����: " + Payment.total_Income + "��");
				break;
				
			default:
				System.out.println("1, 2, 3, 4 �� �ϳ��� �Է����ּ���.");
				}
			};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
