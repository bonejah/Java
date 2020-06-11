package controle.desafios;

import java.util.Scanner;

public class Desafio8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String word = scanner.nextLine();
		
		for (int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
		
		System.out.println();
		
		char[] wordChar = word.toCharArray();
		for (int i = 0; i < wordChar.length; i++) {
			System.out.println(wordChar[i]);
		}
		
		
		scanner.close();
	}
	
}
