package thirty.days.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6LetsReview {

	private static final Scanner scan = new Scanner(System.in);
	private static List<String> lsWords = new ArrayList<String>();
	private static List<String> lsWordsFinal = new ArrayList<String>();
	private static StringBuilder sbOdd = new StringBuilder();
	private static StringBuilder sbEven = new StringBuilder();

	public static void main(String[] args) {
		writeWords();
		separetedWords(lsWords);
		readWords();
		scan.close();
	}

	private static void writeWords() {
		int totalWords = scan.nextInt();
		for (int i = 0; i < totalWords; i++) {
			lsWords.add(scan.next());
		}
	}

	private static void separetedWords(List<String> lsWords) {
		for (String word : lsWords) {
			for (int i = 0; i < word.length(); i++) {
				if (i % 2 == 0) {
					char charAt = word.charAt(i);
					sbEven.append(charAt);
				} else {
					char charAt = word.charAt(i);
					sbOdd.append(charAt);
				}
			}

			lsWordsFinal.add(sbEven.append("  ").append(sbOdd).toString().trim());
			sbOdd = new StringBuilder();
			sbEven = new StringBuilder();
		}
	}

	private static void readWords() {
		for (String string : lsWordsFinal) {
			System.out.println(string);
		}
	}

}
