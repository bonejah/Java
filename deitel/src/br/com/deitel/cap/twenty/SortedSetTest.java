package br.com.deitel.cap.twenty;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	public static void main(String[] args) {
		String[] colors = { "yellow", "green", "black", "tan", "grey", "white", "orange", "red", "green" };

		TreeSet<String> tree = new TreeSet<String>(Arrays.asList(colors));

		System.out.print("sorted set: ");
		printSet(tree); // conteudo de saida de arvore

		// obtem headSet com base em "orange"
		System.out.print("headSet (\"orange\"): ");
		printSet(tree.headSet("orange"));

		// obtem tailSet com base em "orange"
		System.out.print("tailSet (\"orange\"): ");
		printSet(tree.tailSet("orange"));

		// obtem o primeiro e o ultimo elementos
		System.out.printf("first: %s\n", tree.first());
		System.out.printf("lastst: %s\n", tree.last());
	}

	private static void printSet(SortedSet<String> tailSet) {
		for (String s : tailSet) {
			System.out.printf("%s ", s);
		}

		System.out.println();
	}
}
