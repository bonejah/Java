package academy.learningprogramming.stacks.challenge;

import java.util.LinkedList;

/**
*
* brunolima on Feb 8, 2021
* 
*/

public class PalindromeChallenge {
	
	public static void main(String[] args) {
		// should return true
		System.out.println(checkForPalindrome("abccba"));

		// should return true
		System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
		
		// should return true
		System.out.println(checkForPalindrome("I did, did I?"));
		
		// should return false
		System.out.println(checkForPalindrome("hello"));
		
		// should return true
		System.out.println(checkForPalindrome("Don't nod"));
	}

	private static boolean checkForPalindrome(String string) {
		LinkedList<Character> stack = new LinkedList<>();
		StringBuilder stringNOPunctuation = new StringBuilder(string.length());
		String lowercase = string.toLowerCase();
		
		for (int i = 0; i < lowercase.length(); i++) {
			char c = lowercase.charAt(i);
			
			if(c >= 'a' && c <= 'z') {
				stringNOPunctuation.append(c);
				stack.push(c);
			}
		}
		
		StringBuilder reversedString = new StringBuilder(stack.size());
		while(!stack.isEmpty()) {
			reversedString.append(stack.pop());
		}
		
		return stringNOPunctuation.toString().equals(reversedString.toString());
	}

}

