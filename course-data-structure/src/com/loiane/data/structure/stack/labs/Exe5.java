package com.loiane.data.structure.stack.labs;

import java.util.Stack;

public class Exe5 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		printResult("ADA");
		printResult("HADAD");
		printResult("IJIJI");
	}
	
	public static void printResult(String word) {
		System.out.println("The word " + word + ", is palindrome?: " + isPalindrome(word));
	}

	public static boolean isPalindrome(String word) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}

		String reverseWord = "";

		while (!stack.isEmpty()) {
			reverseWord = reverseWord + stack.pop();
		}

		return word.equalsIgnoreCase(reverseWord);
	}

}
