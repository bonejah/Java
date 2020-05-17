package practice.java;

import java.util.Scanner;

public class _14_StringsIntroduction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		System.out.println(A.length() + B.length());
		System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
		String Anew = A.substring(0, 1).toUpperCase() + A.substring(1);
		String Bnew = B.substring(0, 1).toUpperCase() + B.substring(1);
		System.out.printf("%s %s", Anew, Bnew);
		
		sc.close();
	}
	
}
