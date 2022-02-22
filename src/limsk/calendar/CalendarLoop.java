package limsk.calendar;
import java.util.*;

public class CalendarLoop {
	
	private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31}; 
	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
	}

	public static void main(String[] args) {
		
		String PROMPT = "cal>";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = 2;
		while (true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			
			if(month > 12) {
				continue;
			}
			
			
			System.out.printf("%d월은 %d일까지 있습니다.\n",month, cal.getmaxDaysOfMonth(month));
			
			
		}
		System.out.println("Bye~~");
		scanner.close();
			//System.out.println(month + "월은" + cal.getmaxDaysOfMonth(month) + "일까지 있습니다");
		}	

}
