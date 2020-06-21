package practice.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _51_JavaExceptionHandlingTrayCatch {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int result = 0;
		
		try {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			result = a / b;
		} catch (InputMismatchException e) {
			System.out.println("java.util.InputMismatchException");	
			System.exit(0);
		} catch (ArithmeticException e) {
			System.out.println("java.lang.ArithmeticException: / by zero");
			System.exit(0);
		}
		
		System.out.println(result);
		
		scanner.close();
		
	}

}
