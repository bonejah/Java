package thirty.days.code;

import java.util.Scanner;

public class Day1DataTypes {

	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";
		Scanner scan = new Scanner(System.in);
		
		/* Declare second integer, double, and String variables. */
		int ii;
		double dd;
		String ss = new String();
		/* Read and save an integer, double, and String to your variables. */
		// Note: If you have trouble reading the entire String, please go back and
		// review the Tutorial closely.
		ii = scan.nextInt();
		dd = scan.nextDouble();
		ss = scan.next();
		ss = ss + scan.nextLine();

		/* Print the sum of both integer variables on a new line. */
		System.out.println((i + ii));

		/* Print the sum of the double variables on a new line. */
		System.out.println((d + dd));

		/*
		 * Concatenate and print the String variables on a new line; the 's' variable
		 * above should be printed first.
		 */
		System.out.println(s + ss);
	}

}
