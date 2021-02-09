package academy.learnprogramming.sort;

/**
 * Radix Sort - Makes assumptions about the data
 * 
 * - Data must have same radix and width
 * 
 * - Because of this, ata must be integers or strings
 * 
 * - Sort based on each individual digt or letter position
 * 
 * - Start at the rightmost position
 * 
 * - Must use a stable sort algorithm at each stage
 *
 * brunolima on Feb 1, 2021
 * 
 */

public class RadixSortString {

	public static void main(String[] args) {

		String[] radixArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };

		radixSort(radixArray, 26, 5);

		printArray(radixArray);
	}

	public static void radixSort(String[] input, int radix, int width) {
		for (int i = width - 1; i >= 0; i--) {
			radixSingleSort(input, i, radix);
		}
	}

	public static void radixSingleSort(String[] input, int position, int radix) {
		int numItems = input.length;

		int[] countArray = new int[radix];

		for (String value : input) {
			countArray[getIndex(position, value)]++;
		}

		// Adjust the count array
		for (int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}

		String[] temp = new String[numItems];

		for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
			temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex];
		}

		for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
			input[tempIndex] = temp[tempIndex];
		}

	}

	public static int getIndex(int position, String value) {
		return value.charAt(position) - 'a';
	}

	private static void printArray(String[] radixArray) {
		for (int i = 0; i < radixArray.length; i++) {
			if (i != radixArray.length - 1) {
				System.out.print(radixArray[i] + ", ");
			} else {
				System.out.print(radixArray[i]);
			}
		}
	}

}
