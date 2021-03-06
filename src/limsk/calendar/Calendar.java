package limsk.calendar;
import java.util.*;

public class Calendar {
	
	private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
		
	}
	
	public void printSampleCalendar() {
		System.out.println("일   월   화    수    목    금        토");
		System.out.println("-----------------------");
		System.out.println(" 1  2   3  4  5  6  7");
		System.out.println(" 8  9  10 11 12 13 14");
		System.out.println("15 16  17 18 19 20 21");
		System.out.println("22 23  24 25 26 27 28");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 숫자를 입력 받아 해당하는 달의 최대 일수를 출력하는 프로그램
		
		System.out.println("달을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = scanner.nextInt();
		/*if(month == 2) {
			System.out.println("28");
		} else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("31");
		} else {
			System.out.println("30");
		}*/
		
		System.out.printf("%d월은 %d일까지 있습니다. \n",month, cal.getmaxDaysOfMonth(month));
		
		cal.printSampleCalendar();
		scanner.close();

	}

}
