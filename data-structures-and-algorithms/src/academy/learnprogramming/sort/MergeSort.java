package academy.learnprogramming.sort;

/**
 * Merge Sort
 * 
 * - Divide and conquer algorithm
 * 
 * - Recursive algorithm
 * 
 * - Two phases: Splitting and Merging
 * 
 * - Splitting phase leads to faster sorting during the Merging phase
 * 
 * - Splitting is logical. We don't create new arrays
 *
 * brunolima on Jan 31, 2021
 * 
 */

public class MergeSort {

	public static void main(String[] args) {
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

		mergeSort(intArray, 0, intArray.length, true);
		printArray(intArray);

		mergeSort(intArray, 0, intArray.length, false);
		printArray(intArray);
	}

	private static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			if (i != intArray.length - 1) {
				System.out.print(intArray[i] + ", ");
			} else {
				System.out.print(intArray[i] + "\n\n");
			}
		}
	}

	public static void mergeSort(int[] input, int start, int end, boolean asc) {
		if (end - start < 2) {
			return;
		}

		int mid = (start + end) / 2;

		mergeSort(input, start, mid, asc);

		mergeSort(input, mid, end, asc);

		if (asc) {
			mergeAscending(input, start, mid, end);
		} else {
			mergeDescending(input, start, mid, end);
		}

	}

	private static void mergeAscending(int[] input, int start, int mid, int end) {
		if (input[mid - 1] <= input[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] temp = new int[end - start];

		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}

		System.arraycopy(input, i, input, start + tempIndex, mid - i);

		System.arraycopy(temp, 0, input, start, tempIndex);
	}

	private static void mergeDescending(int[] input, int start, int mid, int end) {
		if (input[mid - 1] >= input[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] temp = new int[end - start];

		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
		}

		System.arraycopy(input, i, input, start + tempIndex, mid - i);

		System.arraycopy(temp, 0, input, start, tempIndex);
	}

}
