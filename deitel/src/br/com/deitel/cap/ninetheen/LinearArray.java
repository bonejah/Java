package br.com.deitel.cap.ninetheen;

import java.util.Arrays;
import java.util.Random;

public class LinearArray {
	private int[] data; // array de valores
	private static final Random genarator = new Random();

	// cria um array de um dado tamanho e o preenche com numeros aleatorios
	public LinearArray(int size) {
		data = new int[size]; // cria o espaço para o array

		// preenche o array com ints aleatorios no intervalo de 10-99
		for (int i = 0; i < size; i++) {
			data[i] = 10 + genarator.nextInt(90);
		}
	}
	
	// realiza a pesquisa linear de dados
	public int linearSearch(int searchKey) {
		// faz um loop pelo array sequencialmente
		for (int index = 0; index < data.length; index++) {
			if (data[index] == searchKey) {
				return index; // retorna indice de inteiros
			}
		}
		
		return -1; // inteiro nao foi localizado
	}
	
	// metodo para gerar saida de valores no array
	public String toString() {
		return Arrays.toString(data);
	}
}
