package br.com.deitel.cap.ninetheen;

public class MergeSortTest {
	public static void main(String[] args) {
		// cria objeto para executar a classificacao por intercalacao
		MergeSort mergeSort = new MergeSort(10);

		// imprime um array nao classificado
		System.out.println("Unsorted: " + mergeSort + "\n");

		mergeSort.sort(); // classifica o array

		// imprime um array classificado
		System.out.println("Sorted: " + mergeSort);
	}
}
