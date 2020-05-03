package br.com.deitel.cap.ninetheen;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
	private int[] data; // array de valores
	private static final Random generator = new Random();

	// cria um array de um dado tamanho e o preenche com inteiros aleatorios
	public InsertionSort(int size) {
		data = new int[size]; // cria espaco para o array

		// preenche o array com ints aleatorios no intervalo de 10-99
		for (int i = 0; i < size; i++) {
			data[i] = 10 + generator.nextInt(90);
		}
	}

	// classifica o array utilizando a classificacao por insercao
	public void sort() {
		int insert; // variavel temporaria para armazenar o elemento a inserir

		// faz um loop sobre data.lenght - 1 elemento
		for (int next = 1; next < data.length; next++) {
			// armazena o valor no elemento atual
			insert = data[next];

			// inicializa a localizacao para colocar o elemento
			int moveItem = next;

			// procura o local para colocar o elemento atual
			while (moveItem > 0 && data[moveItem - 1] > insert) {
				// desloca o elemento direito um slot
				data[moveItem] = data[moveItem - 1];
				moveItem--;
			}

			data[moveItem] = insert; // posiciona o elemento inserido
			printPass(next, moveItem); // passagem de saida do algoritmo
		}
	}

	public void printPass(int pass, int index) {
		System.out.print(String.format("after pass %2d: ", pass));

		// gera saida dos elementos até o item trocado
		for (int i = 0; i < index; i++) {
			System.out.print(data[i] + "  ");
		}

		System.out.print(data[index] + "* "); // indica troca

		// termina de gerar a saida do array
		for (int i = index + 1; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}

		System.out.println("\n            "); // para alinhamento

		// indica quantidade do array que é classificado
		for (int i = 0; i <= pass; i++) {
			System.out.print("--  ");
		}

		System.out.println("\n"); // adiciona fim da linha
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
