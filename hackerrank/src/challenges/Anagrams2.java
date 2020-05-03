package challenges;

import java.util.Scanner;

public class Anagrams2 {

	private static int[] frequency = new int[26];

	static boolean isAnagram(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();

		for (char c : a.toCharArray()) {
			System.out.println(c);
			System.out.println((int) c - 97);
			frequency[(int) c - 97]++;
		}

		for (int i = 0; i < frequency.length; i++) {
			System.out.println(i + " : " + frequency[i]);
		}

		System.out.println("================");
		System.out.println("================");

		for (char c : b.toCharArray()) {
			System.out.println(c);
			System.out.println((int) c - 97);
			frequency[(int) c - 97]--;
		}

		for (int i = 0; i < frequency.length; i++) {
			System.out.println(i + " : " + frequency[i]);
		}

		boolean anagrams = true;
		for (int i : frequency) {
			if (i != 0) {
				anagrams = false;
				break;
			}
		}
		return anagrams;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
