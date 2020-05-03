package challenges;

import java.util.Scanner;
import java.util.Stack;

public class StringReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		/* Enter your code here. Print output to STDOUT. */

		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < A.length(); i++) {
			System.out.println(A.substring(i, i + 1));
			stack.add(A.substring(i, i + 1));
		}

		System.out.println(stack);

		boolean isPalindrome = true;

		for (int i = 0; i < A.length(); i++) {
			if (A.substring(i, i + 1).equals(stack.pop())) {
				continue;
			} else {
				isPalindrome = false;
			}
		}

		System.out.printf("%s", isPalindrome ? "Yes" : "No");

	}

}
