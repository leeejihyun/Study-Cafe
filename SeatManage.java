package finalProject;

// ���͵� ī���� �¼��� �����ϴ� Ŭ����
public class SeatManage {
	boolean setTable[][];
	
	SeatManage(){
		// setTable �迭�� ��� ��Ҹ� false�� �ʱ�ȭ
		setTable = new boolean[2][5];
	};
	
	// "3.������ �� 2.��ü �¼� ���� �ϱ�" �޴��� �������� �� �����ϴ� �޼ҵ�
	void clear() {
		// setTable �迭�� ��� ��Ҹ� false�� �缼��
		for (int i=0; i<setTable.length; i++)
			for (int j=0; j<setTable[i].length; j++)
				setTable[i][j] = false;
	};
	
	// setTable �迭�� ���¸� ���̴� �޼ҵ�
	void print() {
		// �� �ڸ�(V), �� �ڸ�(O)�� ǥ��
		// ���ڴ� �¼� �ڸ� ����(ù ����:��, �ι�° ����: ��)
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
		// �Ű������� �¼� ��ȣ
		// x�� ��(�տ� ����), y�� ��(�ڿ� ����)
		// �����(�մ�)�� ������ �ڸ��� setTable�迭���� ã�Ƽ�, ����ִٸ� V��O�� ����
		if (setTable[x][y] == false) {
			setTable[x][y] = true;
			System.out.println("���õǾ����ϴ�.");
			return true;
		}
		// ���ִٸ� "�̹� ��� �� �Դϴ�." ���
		else {
			System.out.println("�̹� ��� �� �Դϴ�. �ٸ� �¼� ��ȣ�� �Է����ּ���.");
			return false;
		}
	};
	
	void releaseSeat(int x, int y) {
		// �Ű������� �¼���ȣ(setSeat�� ����)
		// �ش��ϴ� �¼���ȣ�� true���, O��V�� ����
		if (setTable[x][y] == true)
			setTable[x][y] = false;
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
