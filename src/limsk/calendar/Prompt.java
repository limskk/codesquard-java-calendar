package limsk.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+---------------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말      q. 종료");
		System.out.println("+---------------------------+");
		System.out.println();
		System.out.println("사용하려는 기능을  입력해주세요");
	}
	
	/*
	 * week 요일명
	 * 일월화수목금토
	 * */
	public int parseDay(String week) {
		switch(week) {
		case "su": 
			return 0;
		case "mo" :
			return 1;
		case "tu": 
			return 2;
		case "we" :
			return 3;
		case "th": 
			return 4;
		case "fr" :
			return 5;
		case "sa" :
			return 6;
		default :
			return 0;
		}
		
	}
	
	//변경 안되는 것을 final static으로 함
	private final static String PROMPT_MONTH="CAL> ";  // 변경 없는거는 대문자로
	private final static String PROMPT_YEAR = "YEAR> ";
	private final static String PROMPT_MENU = "MENU> ";
	
	public void runPrompt() throws ParseException {
		
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		CalendarVirtual cal = new CalendarVirtual();
		
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print(PROMPT_MENU);
			String cmd = scanner.next();
			switch(cmd) {
			case "1" :
				cmdRegister(scanner, cal);
				break;
			case "2" :
				cmdSearch(scanner, cal);
				break;
			case "3" :
				cmdCal(scanner, cal);
				break;
			case "h" :
				printMenu();
				break;
			case "q" :
				isLoop = false;
				break;
			}
	
		}
		System.out.println("Bye~~");
		scanner.close();
	}
	
	private void cmdCal(Scanner scanner, CalendarVirtual cal) {
		
		int year = 2022;
		int month = 2;
		
		System.out.println("년도를 입력하세요.");
		System.out.print(PROMPT_YEAR);
		year = scanner.nextInt();
		
		
		System.out.println("달을 입력하세요");
		System.out.print(PROMPT_MONTH);
		month = scanner.nextInt();
		
		if (month > 12 || month <1) {
			System.out.println("잘못된 입력입니다");
			return;
		}
		
		//디버깅용 -- System.out.println(str_weekday +" , "+ weekday);
		
		cal.printCalendar(year, month);
		
	}

	private void cmdSearch(Scanner s, CalendarVirtual c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = s.next();
		Plan plan;
		plan = c.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner s, CalendarVirtual c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = s.next();
		String text ="";
		System.out.println("일정을 입력해 주세요. (문장 끝에 ; 을 입력해 주세요.)");
		String word;
		while(!(word = s.next()).endsWith(";")) {
			text += word +" ";
		}
		word = word.replace(";", " ");
		text += word;
		c.registerPlan(date, text);
		
		
//		while(true) {
//			String word = s.next();
//			text += word +" ";
//			if (word.endsWith(";")) {
//				break;
//			}
//			
//		}
		
	}

	public static void main(String[] args) throws ParseException {
		//셀실행
		Prompt p = new Prompt();
		p.runPrompt();
		
		
	}

}
