package br.com.deitel.cap.twenty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		String[] colors = { "red", "white", "blue", "green", "gray", "orange", "tan", "white", "cyan", "peach", "gray",
				"orange" };

		List<String> list = Arrays.asList(colors);
		System.out.printf("List: %s\n", list);

		// elimina duplicatas e imprime valores unicos
		printNoDuplicates(list);
	}

	private static void printNoDuplicates(List<String> list) {
		Set<String> set = new HashSet<String>(list);

		System.out.print("\nNonduplicates are: ");

		for (String value : set) {
			System.out.printf("%s ", value);
		}

		System.out.println();

	}

}
