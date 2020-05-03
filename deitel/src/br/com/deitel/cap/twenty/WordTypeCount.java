package br.com.deitel.cap.twenty;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordTypeCount {
	public static void main(String[] args) {
		HashMap<String, Integer> myMap = new HashMap<String, Integer>();
		createMap(myMap);
		displayMap(myMap);
	}

	private static void displayMap(HashMap<String, Integer> myMap) {
		Set<String> keys = myMap.keySet(); // obtem as chaves

		// classifica as chaves
		TreeSet<String> sortedKeys = new TreeSet<String>(keys);
		System.out.println("\nMap contains:\nKey\t\tValue");

		// gera a saida de cada chave no mapa
		for (String key : sortedKeys) {
			System.out.printf("%-10s%10s\n", key, myMap.get(key));
		}

		System.out.printf("\nsize: %d\nisEmpty: %b\n", myMap.size(), myMap.isEmpty());
	}

	private static void createMap(HashMap<String, Integer> myMap) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String input = scanner.nextLine();

		// tokeniza a entrada
		String[] tokens = input.split(" ");

		for (String token : tokens) {
			String word = token.toLowerCase();

			if (myMap.containsKey(word)) {
				int count = myMap.get(word); // obtem a contagem atual
				myMap.put(word, count + 1); // incrementa a contagem
			} else {
				myMap.put(word, 1);
			}
		}
	}

}
