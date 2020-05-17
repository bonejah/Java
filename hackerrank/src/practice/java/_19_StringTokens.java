package practice.java;

import java.util.Scanner;

public class _19_StringTokens {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		// Write your code here.
		
		if (s.trim().equals("")) {
			System.out.println("0");
			return;
		}
		
		String delims = "[ .,?!'_@]+";
		String[] tokens = s.trim().split(delims);
		
		System.out.println(tokens.length);
		
		for (String token : tokens) {
			System.out.println(token);
		}
		
		scan.close();
	}

}
