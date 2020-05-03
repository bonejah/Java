package br.com.deitel.cap.ninetheen;

import java.util.Random;

public class MergeSort {
	private int[] data;
	private static final Random generator = new Random();

	public MergeSort(int size) {
		data = new int[size];

		for (int i = 0; i < size; i++) {
			data[i] = 10 + generator.nextInt(90);
		}
	}

	// chama o metodo split recursivo para iniciar a classificacao por
	// intercalacao
	public void sort() {
		sortArray(0, data.length - 1); // divide o array inteiro
	}

	public void sortArray(int low, int high) {
		// caso basico de teste: tamanho do array é igual a 1
		if ((high - low) >= 1) {
			int middle1 = (low + high) / 2; // calcula o meio do array\
			int middle2 = middle1 + 1; // calcula o proximo elemento

			// gera uma saida do passo da divisao
			System.out.println("split: " + subarray(low, high));
			System.out.println("       " + subarray(low, middle1));
			System.out.println("       " + subarray(middle2, high));
			System.out.println();

			// divide o array pela metade; classifica cada metade (chamadas
			// recursivas)
			sortArray(low, middle1); // primeira metade do array
			sortArray(middle2, high); // segunda metado do array

			// intercala dois arrays classificados depois que as chamadas de
			// divisao retoram
			merge(low, middle1, middle2, high);
		}
	}

	// intercala dois subarrays classificados em um subarray classificado
	private void merge(int left, int middle1, int middle2, int right) {
		int leftIndex = left; // indice do subarray esquerdo
		int rightIndex = middle2; // indice no subarry direito
		int combineIndex = left; // indice no array temporario funcional
		int[] combined = new int[data.length]; // array funcional

		// gera saida de dois subarrays antes de mesclar
		System.out.println("merge:    " + subarray(left, middle1));
		System.out.println("          " + subarray(middle2, right));

		// intercala arrays até alcançar o fim de um deles
		while (leftIndex <= middle1 && rightIndex <= right) {
			// coloca o menor dos dois elementos atuais no resultado
			// e o move para o proximo espaço de arrays
			if (data[leftIndex] <= data[rightIndex++])
				combined[combineIndex++] = data[leftIndex++];
			else
				combined[combineIndex++] = data[rightIndex++];
		}

		// se o array esquerdo estiver vazio
		if (leftIndex == middle2)
			// copia o restante do array direito
			while (rightIndex <= right)
				combined[combineIndex++] = data[rightIndex++];

		else // o array direito esta vazio
				// copia o restante do array esquerdo
			while (leftIndex <= middle1)
				combined[combineIndex++] = data[leftIndex++];

		// copia os valores de volta ao array original
		for (int i = left; i <= right; i++)
			data[i] = combined[i];

		// gera saida do array intercalado
		System.out.println("          " + subarray(left, right));

		System.out.println();
	}

	public String subarray(int low, int right) {
		StringBuilder temporary = new StringBuilder();

		// gera espaços para alinhamentos
		for (int i = 0; i < low; i++) {
			temporary.append("  ");
		}

		// gera a saida dos elementos que permanecem no array
		for (int i = low; i <= right; i++) {
			temporary.append(" " + data[i]);
		}

		return temporary.toString();
	}

	@Override
	public String toString() {
		return subarray(0, data.length - 1);
	}
}
