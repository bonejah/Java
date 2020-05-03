package br.com.deitel.cap.ninetheen;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
	private int[] data; // array de valores
	private static final Random generator = new Random();

	// cria um array de um determinado tamanho e o preenche com numeros
	// aleatorios
	public SelectionSort(int size) {
		data = new int[size]; // cria espaço para o array

		// preenche o array com ints aleatorios no intervalo de 10-99
		for (int i = 0; i < size; i++) {
			data[i] = 10 + generator.nextInt(90);
		}
	}

	// classifica o array utilizando a classificacao por selecao
	public void sort() {
		int smallest; // indice do menos elemento

		// faz o loop sobre o data.lenght -1 elementos
		for (int i = 0; i < data.length; i++) {
			smallest = i;

			// faz um loop para localizar o indice do menor elemento
			for (int index = i + 1; index < data.length; index++) {
				if (data[index] < data[smallest]) {
					smallest = index;
				}
			}

			swap(i, smallest); // troca o menor elemento na posicao
			printPass(i + 1, smallest); // passagem de saida do algoritmo
		}
	}

	// metodo auxiliar para trocar valores em dois elementos
	public void swap(int first, int second) {
		int temporary = data[first]; // armazena o primeiro em temporario
		data[first] = data[second]; // substitui o primeiro pelo segundo
		data[second] = temporary; // coloca o temporario no segundo
	}

	// imprime uma passagem do algoritmo
	public void printPass(int pass, int index) {
		System.out.print(String.format("after pass %2d: ", pass));

		// saida de elementos ate o item selecionado
		for (int i = 0; i < index; i++) {
			System.out.print(data[i] + "  ");
		}

		System.out.print(data[index] + "* "); // indica troca

		// termina de gerar a saida do array
		for (int i = index + 1; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}

		System.out.print("\n              "); // para alinhamento

		// indica a quantidade do array que é classificado
		for (int j = 0; j < pass; j++) {
			System.out.print("-- ");
		}

		System.out.println("\n"); // adiciona fim de linha
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
