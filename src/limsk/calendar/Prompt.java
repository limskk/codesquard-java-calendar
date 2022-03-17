package limsk.calendar;

import java.util.Scanner;

public class Prompt {
	
	/*
	 * week 요일명
	 * 일월화수목금토
	 * */
	public int parseDay(String week) {
		if(week.equals("su")) {
			return 0;
		}else if(week.equals("mo")){
			return 1;
		} else if (week.equals("tu")) {
			return 2;
		}else if (week.equals("we")) {
			return 3;
		}else if (week.equals("th")) {
			return 4;
		}else if (week.equals("fr")) {
			return 5;
		}else if(week.equals("sa")) {
			return 6;
		} 
		return 0;
	}
	
	//변경 안되는 것을 final static으로 함
	private final static String PROMPT_MONTH="CAL> ";  // 변경 없는거는 대문자로
	private final static String PROMPT_YEAR = "YEAR> ";
	private final static String PROMPT_WEEKDAY = "WEEKDAY>";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		CalendarVirtual cal = new CalendarVirtual();
		
		int year = 2022;
		int month = 2;
		int weekday = 0;
		
		while(true) {
			System.out.println("연도를 입력하세요. (exit : -1)");
			System.out.print(PROMPT_YEAR);
			year = scanner.nextInt();
			
			if (year == -1) {
				break;
			}
			
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT_MONTH);
			month = scanner.nextInt();
			
			if (month > 12 || month <1) {
				System.out.println("잘못된 입력입니다/");
				continue;
			}
			
			System.out.println("첫째 날의 요일을 입력하세요 (su, mo, tu, we, th, fr, sa).");
			System.out.print(PROMPT_WEEKDAY);
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			//디버깅용 -- System.out.println(str_weekday +" , "+ weekday);
			
			cal.printCalendar(year, month, weekday);
	
		}
		System.out.println("Bye~~");
		scanner.close();
	}
	
	public static void main(String[] args) {
		//셀실행
		Prompt p = new Prompt();
		p.runPrompt();
		
		
	}

}
