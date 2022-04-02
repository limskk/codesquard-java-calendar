package limsk.calendar;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/*
 * - 월을 입력하면 해당월의 달력을 출력한다.
 * - 달력의 모양은 1단계에서 작성한 모양으로 만든다.
 * - 1일은 일요일로 정해도 무방하다.
 * - -1을 입력받기 전까지 반복 입력 받는다.
 * - 프롬프트를 출력한다.
 * */


public class CalendarVirtual {
	
	public static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String SAVE_FILE="calendar.date";
	private HashMap <Date, Plan>planMap; 
	
	public CalendarVirtual() {
		planMap = new HashMap<Date, Plan>();
		//calendar을 초기화하는 부분에 불러오기 기능을 만들어 줌
		File f = new File(SAVE_FILE);
		if(!f.exists()) {
			
			return;
		} else {
			try {
				Scanner s = new Scanner(f);
				while(s.hasNext()) {
					String line = s.nextLine();
					String[] words = line.split(",");
					String date = words[0];
					String detail = words[1].replaceAll("\"", "");
					Plan p = new Plan(date, detail);
					planMap.put(p.getDate(),p);
				}
				s.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		
		}
	}
	
	/* 
	 * date ex : "2017-06-20"
	 * plan
	 * parseException
	 * */
	public void registerPlan(String strDate, String plan) {
		
		Plan p = new Plan(strDate, plan);
		planMap.put(p.getDate(), p);
		
		//file 저장 
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Plan searchPlan(String strDate) {
		Date date = Plan.getDatefromString(strDate);
		return planMap.get(date);
		}
	
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 !=0 || year % 400 ==0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}else {
			return MAX_DAYS[month];			
		}
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf(" << %4d년 %3d월 >>\n",year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("-----------------------");
		
		//get weekday automatiqually
		int weekday =  getWeekDay(year, month, 1);
		// print blank space
		for (int i=0; i<weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count <7)?count:0;
		
		//print first line
		for(int i =1; i <= count;i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		
		// print from second line to last
		count++;
		for(int i=count; i <=maxDay; i++) {
			System.out.printf("%3d",i);
			if (i% 7 == delim) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println();
		
		/*
		 * System.out.println(" 1  2   3  4  5  6  7");
		 * System.out.println(" 8  9  10 11 12 13 14");
		 * System.out.println("15 16  17 18 19 20 21");
		 * System.out.println("22 23  24 25 26 27 28");
		 */
	}

	private int getWeekDay(int year, int month, int day) {
		// 기준날짜의 요일을 얻어낼것
		// 요일 계산법 Zeller 공식
		// 컴퓨터 하드웨어 시간이 1970년 1월 1일부터 시작하기 때문에 1970년은 의미있는 날
		// 1970년 1월 1일은 목요일
		int syear = 1970;

		final int STANDARD_WEEKDAY = 4; // Thursday
		
		int count = 0;
		for(int i =syear; i<year; i++) {
			int delta = isLeapYear(i)? 366 : 365;  // 올해가 윤년이면 366일 아니면 365일 
			count += delta;
		}
		
		for(int i=1; i<month; i++) {
			int delta = getMaxDaysOfMonth(year, i); //year 올해
			count += delta;
		}
		
		count += day -1; 
		
		int weekday = (count +STANDARD_WEEKDAY) % 7;
		//System.out.println(count);
		return weekday;
	}
	
	//simple test code here
	
//	 public static void main(String[] args) throws ParseException { 
//	 CalendarVirtual c = new CalendarVirtual(); 
//	 System.out.println(c.getWeekDay(1970, 1, 1) == 4);
//	 System.out.println(c.getWeekDay(1971, 1, 1) == 5); 
//	 
//	 c.registerPlan("2022-03-22", "Let's eat beef" );
//	 System.out.println(c.searchPlan("2022-03-22").equals("Let's eat beef")  );
//	 
//	 }
	 
	 
	 
}
