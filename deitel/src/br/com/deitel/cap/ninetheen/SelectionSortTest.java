package br.com.deitel.cap.ninetheen;

public class SelectionSortTest {
	public static void main(String[] args) {
		SelectionSort sortArray = new SelectionSort(10);

		System.out.println("Unsorted array:");
		System.out.println(sortArray + "\n"); // imprime um array nao classificado

		sortArray.sort(); // classifica o array

		System.out.println("Sorted array:");
		System.out.println(sortArray + "\n"); // imprime um array classificado
	}
}
