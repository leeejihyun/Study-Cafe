package finalProject;
import java.util.Calendar;

public class Payment {
	static int total_Income = 0; // �� ����
	final int FEE_PER_MINUTE = 100;
	final int FEE_PER_HOUR = 5000;
	
	int calculateFee(long startTime, long endTime) {
		return (int)((endTime - startTime) / 60 * FEE_PER_HOUR + (endTime - startTime) % 60 * FEE_PER_MINUTE);
	};
	
	long setCheckIn() {
		Calendar now = Calendar.getInstance();
		
		// ����ð� üũ
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		long startTime = hour * 60 + minute;
		
		// ����ڿ��� ����ð� ���
		System.out.println("����ð��� " + hour + "�� " + minute + "���Դϴ�.");
		return startTime;
	};
	
	long setCheckOut() {
		Calendar now = Calendar.getInstance();
		
		// ����ð� üũ
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		long endTime = hour * 60 + minute;
		
		// ����ڿ��� ����ð� ���
		System.out.println("����ð��� " + hour + "�� " + minute + "���Դϴ�.");
		return endTime;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
