package limsk.calendar;

import java.util.Scanner;

public class Prompt {
	
	//변경 안되는 것을 final static으로 함
	private final static String PROMPT_MONTH="cal> ";  // 변경 없는거는 대문자로
	private final static String PROMPT_YEAR = "year> ";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		CalendarVirtual cal = new CalendarVirtual();
		
		int year = 2022;
		int month = 2;
		
		while(true) {
			System.out.println("연도를 입력하세요");
			System.out.print(PROMPT_YEAR);
			year = scanner.nextInt();
			
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT_MONTH);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			
			cal.printCalendar(year, month);
			
			
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		//셀실행
		Prompt p = new Prompt();
		p.runPrompt();
		
		
	}

}
