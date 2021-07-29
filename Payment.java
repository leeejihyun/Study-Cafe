package finalProject;
import java.util.Calendar;

public class Payment {
	static int total_Income = 0; // 총 수익
	final int FEE_PER_MINUTE = 100;
	final int FEE_PER_HOUR = 5000;
	
	int calculateFee(long startTime, long endTime) {
		return (int)((endTime - startTime) / 60 * FEE_PER_HOUR + (endTime - startTime) % 60 * FEE_PER_MINUTE);
	};
	
	long setCheckIn() {
		Calendar now = Calendar.getInstance();
		
		// 입장시간 체크
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		long startTime = hour * 60 + minute;
		
		// 사용자에게 입장시간 출력
		System.out.println("입장시간은 " + hour + "시 " + minute + "분입니다.");
		return startTime;
	};
	
	long setCheckOut() {
		Calendar now = Calendar.getInstance();
		
		// 퇴장시간 체크
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		long endTime = hour * 60 + minute;
		
		// 사용자에게 퇴장시간 출력
		System.out.println("퇴장시간은 " + hour + "시 " + minute + "분입니다.");
		return endTime;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
