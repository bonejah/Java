package academy.learnprogramming.sort;

/**
 * Insertion Sort
 * 
 * - In-place algorithm
 * 
 * - O(n2) time complexity- quadratic
 * 
 * - It will take 100 steps to sort 10 items, 10000 steps to sort 100 items,
 * 1000000 steps to sort 1000 items
 * 
 * - Stable algorithm
 * 
 * @author brunolima
 *
 */

public class InsertionSort {

	public static void main(String[] args) {

		int[] input = { 20, 35, -15, 7, 55, 1, -22 };

//		int lastValueInArray = intArray[intArray.length - 1];
//		int lastIndexInArray = intArray.length - 1;
//		
//		System.out.println("Last value in Array: " + lastValueInArray);
//		System.out.println("Last index in Array: " + lastIndexInArray);

		printInputBefore(input);

//		insertionSort(input);

		insertionSortRecursive(input, input.length);

		printArrayAfter(input);
	}

	private static void printArrayAfter(int[] intArray) {
		System.out.println("\n\nArray sorted: ");
		for (int i : intArray) {
			System.out.print(i + " ");
		}
	}

	private static void printInputBefore(int[] intArray) {
		System.out.println("\nArray unsorted: ");
		for (int i : intArray) {
			System.out.print(i + " ");
		}
	}

	private static void insertionSort(int[] input) {
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++) {
			int newElement = input[firstUnsortedIndex];

			int i;

			for (i = firstUnsortedIndex; i > 0 && input[i - 1] > newElement; i--) {
				input[i] = input[i - 1];
			}

			input[i] = newElement;
		}

	}

	private static void insertionSortRecursive(int[] input, int numItems) {
		if (numItems < 2)
			return;

		insertionSortRecursive(input, numItems - 1);

		int newElement = input[numItems - 1];

		int i;

		for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
			input[i] = input[i - 1];
		}

		input[i] = newElement;

	}

}
