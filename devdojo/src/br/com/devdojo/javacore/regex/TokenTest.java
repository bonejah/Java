package br.com.devdojo.javacore.regex;

public class TokenTest {

	public static void main(String[] args) {
		String str = "Bruno, Bianca, Matheus, Leticia";
		String[] tokens = str.split(",");
		for (String token : tokens) {
			System.out.println(token.trim());
		}
		
		
	}
}
