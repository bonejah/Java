package br.com.deitel.cap.ninetheen;

import java.util.Arrays;
import java.util.Random;

public class BinaryArray {
	private int[] data; // array de valores
	private static final Random generator = new Random();

	// cria um array de um dado tamanho e o preenche com inteiros aleatorios
	public BinaryArray(int size) {
		data = new int[size];
		; // cria espaço para o array

		// preenche o array com ints aleatorios no intervalo de 10-99
		for (int i = 0; i < size; i++) {
			data[i] = 10 + generator.nextInt(90);
		}

		Arrays.sort(data);
	}

	// realiza a pesquisa binaria sobre os dados
	public int binarySearch(int searchElement) {
		int low = 0; // extremidade baixa da area de pesquisa
		int high = data.length - 1; // extremidade alta da area de pesquisa
		int middle = (low + high + 1) / 2; // elemento do meio
		int location = -1; // valor de retorno; -1 se nao localizado

		do {
			// imprime os elementos remanescentes do array
			System.out.print(remainingElements(low, high));

			// gera espaços para o alinhamento
			for (int i = 0; i < middle; i++) 
				System.out.print("   ");		

			System.out.println(" * "); // indica o meio atual

			// se o elemento for localizado no meio
			if (searchElement == data[middle]) {
				location = middle; // a localizacao é o meio atual
			} else if (searchElement < data[middle]) {
				high = middle - 1; // elimina a metade mais alta
			} else { // elemento do meio é muito baixo
				low = middle + 1; // elimina a metade mais baixa
			}

			middle = (low + high + 1) / 2; // recalcula o meio
		} while ((low <= high) && (location == -1));

		return location; // retorna a localizacao da chave de pesquisa;
	}

	public String remainingElements(int low, int high) {
		StringBuilder temporary = new StringBuilder();

		// gera espacos para o alinhamento
		for (int i = 0; i < low; i++)
			temporary.append("   ");
		
		// gera a saida dos elementos que permanecem no array
		for (int i = low; i <= high; i++) 
			temporary.append(data[i] + " ");
		

		temporary.append("\n");
		return temporary.toString();
	}

	@Override
	public String toString() {
		return remainingElements(0, data.length - 1);
	}
}
