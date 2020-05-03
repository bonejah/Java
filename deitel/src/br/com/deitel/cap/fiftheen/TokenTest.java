package br.com.deitel.cap.fiftheen;

import java.util.Scanner;

public class TokenTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence and press Enter");
		String sentence = scanner.nextLine();
		
		String[] tokens = sentence.split(" ");
		System.out.printf("Number of elements: %d\nThe tokens are:\n ",tokens.length);
		
		for (String string : tokens) {
			System.out.println(string);
		}
	}
}
