package practice.java;

import java.util.Scanner;

class UsernameValidator {
	/*
	 * Write regular expression here.
	 * 
	 * The username consists of to characters inclusive. If the username consists of
	 * less than or greater than characters, then it is an invalid username. The
	 * username can only contain alphanumeric characters and underscores (_).
	 * Alphanumeric characters describe the character set consisting of lowercase
	 * characters , uppercase characters , and digits. The first character of the
	 * username must be an alphabetic character, i.e., either lowercase character or
	 * uppercase character.
	 * 
	 */
	public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
}

public class _23_RegexValidUsernameExpression {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(scan.nextLine());
		
		while (n-- != 0) {
			String userName = scan.nextLine();

			if (userName.matches(UsernameValidator.regularExpression)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}
	}
}
