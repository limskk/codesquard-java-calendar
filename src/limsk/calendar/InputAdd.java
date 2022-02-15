package limsk.calendar;
import java.util.*;

public class InputAdd {

	public static void main(String[] args) {
		
		
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		
		String[] splitedValue = inputValue.split(" ");
		
		int first = Integer.parseInt(splitedValue[0]);
		int secon = Integer.parseInt(splitedValue[1]);
		
		System.out.println("두 수의 합은 "+ (first+secon) +"입니다.");
		scanner.close();
	}

}
