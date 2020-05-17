package practice.java;

import java.util.Scanner;

public class _09_EndOfFile {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;

		while (scanner.hasNext()) {
			System.out.printf("%d %s %n", ++count, scanner.nextLine());
		}
		
		scanner.close();
	}
	
}
