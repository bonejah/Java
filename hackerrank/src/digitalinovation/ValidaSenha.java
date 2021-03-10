package digitalinovation;

import java.util.regex.Pattern;

/**
 *
 * brunolima on Feb 14, 2021
 * 
 */

public class ValidaSenha {

	private static final int MAX = 200;

	public ValidaSenha(int max2) {

	}

	public static void main(String[] args) {
		String teste1 = "Digital Innovation One";
		validaSenha(teste1);

		String teste2 = "AbcdEfgh99";
		validaSenha(teste2);

		String teste3 = "DigitalInnovationOne123";
		validaSenha(teste3);

		String teste4 = "Digital Innovation One 123";
		validaSenha(teste4);

		String teste5 = "Aass9";
		validaSenha(teste5);

		String teste6 = "Aassd9";
		validaSenha(teste6);

	}

	public static boolean validaSenha(String senha) {
		if (senha.length() >= 6 && senha.length() <= 32) {
			if (containsLetterUpperCase(senha) 
					&& containsLetterLowerCase(senha) 
					&& containsOneNumber(senha)
					&& !containsAccentsAndSpaces(senha)) {

				System.out.println("Senha valida.");
			} else {
				System.out.println("Senha invalida.");
			}
		} else {
			System.out.println("Senha invalida.");
		}

		return false;
	}

	private static boolean containsAccentsAndSpaces(String senha) {
		return Pattern.matches(".*[éèàù].*", senha) || senha.contains(" ");
	}

	private static boolean containsOneNumber(String senha) {
		for (char c : senha.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean containsLetterLowerCase(String senha) {
		for(char c: senha.toCharArray()) {
			if (Character.isLowerCase(c)) {
				return true;
			}
		}
		
//		for (int i = 0; i < senha.length(); i++) {
//			if (senha.charAt(i) >= 97 && senha.charAt(i) <= 122) {
//				return true;
//			}
//		}

		return false;
	}

	private static boolean containsLetterUpperCase(String senha) {
		for(char c: senha.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		
//		for (int i = 0; i < senha.length(); i++) {
//			if (senha.charAt(i) >= 65 && senha.charAt(i) <= 90) {
//				return true;
//			}
//		}

		return false;
	}

}
