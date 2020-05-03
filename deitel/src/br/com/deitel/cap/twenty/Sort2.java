package br.com.deitel.cap.twenty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort2 {
	public static void main(String[] args) {
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		// Cria e exibe uma lista que contem os elementos do array de ternos
		List<String> list = Arrays.asList(suits);
		System.out.printf("Unsorted array elements: %s\n", list);
		
		Collections.sort(list, Collections.reverseOrder()); // classifica em orderm decrescente utilizando um comparador 
		
		System.out.printf("Sorted array elements: %s\n", list);
	}
}
