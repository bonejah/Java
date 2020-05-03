package br.com.deitel.cap.twenty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Algorithms1 {
	public static void main(String[] args) {
		// cria e exibe uma List<Character>
		Character[] letters = { 'P', 'C', 'M' };
		List<Character> list = Arrays.asList(letters);
		System.out.println("list contains: ");
		output(list);

		// inverte e exibe a List<Character>
		Collections.reverse(list); // inverte a lista dos elementos
		System.out.println("\nAfter calling reverse, list contains: ");
		output(list);

		// cria copyList de um array de 3 caracteres
		Character[] lettersCopy = new Character[3];
		List<Character> copyList = Arrays.asList(lettersCopy);

		// copia os conteudos de list para copyList
		Collections.copy(copyList, list);
		System.out.println("\nAfter copying, copyList contains: ");
		output(list);

		// copia os conteudos de list para copyList
		Collections.fill(list, 'R');
		System.out.println("\nAfter calling fill, copyList contains: ");
		output(list);
	}

	private static void output(List<Character> list) {
		System.out.print("The list is: ");
		
		for (Character element : list) {
			System.out.printf("%s ", element);
		}

		System.out.printf("\nMax: %s", Collections.max(list));
		System.out.printf(" Min: %s\n", Collections.min(list));
	}

}
