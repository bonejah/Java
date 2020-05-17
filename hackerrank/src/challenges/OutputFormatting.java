package challenges;

import java.util.Scanner;

public class OutputFormatting {

	// See: https://www.baeldung.com/java-printstream-printf
	// Format types:
	// s - formats strings
	// d - formats decimal integers
	// f - formats the floating-point numbers
	// t - formats date/time values
	// b - formats booleans

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================");
		
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			int x = sc.nextInt();
			System.out.printf("%-15s%03d%n", s1, x);
		}
		
		System.out.println("================================");
		sc.close();
	}

}
