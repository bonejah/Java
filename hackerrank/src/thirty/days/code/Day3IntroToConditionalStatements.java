package thirty.days.code;

import java.util.Scanner;

public class Day3IntroToConditionalStatements {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		if(isOdd(N)) {
			System.out.println("Weird 1 ");
		} 
		
		if (isEven(N) && (isRange2To5(N))) {
			System.out.println("Not Weird 2 ");
		}
		
		if (isEven(N) && (isRange6To20(N))) {
			System.out.println("Weird 3 ");
		}
		
		if(isEven(N) && N > 20) {
			System.out.println("Not Weird 4 ");
		}
		
		scanner.close();
	}
	
	public static boolean isOdd(int odd) {
		return odd % 2 == 1;
	}
	
	
	public static boolean isEven(int odd) {
		return odd % 2 == 0;
	}
	
	
	
	public static boolean isRange2To5(int num) {
		return (num >=2 && num <=5);
	}
	
	public static boolean isRange6To20(int num) {
		return (num >=6 && num <=20);
	}

}
