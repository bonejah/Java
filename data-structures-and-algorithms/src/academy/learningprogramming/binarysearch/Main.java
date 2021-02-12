package academy.learningprogramming.binarysearch;

/**
 *
 * brunolima on Feb 11, 2021
 * 
 * Binary Search
 * 
 * - Data must be sorted!
 * 
 * - Chooses the element in the middle of the array and compares it against the search value
 * 
 * - If element is equal to the value, we're done
 * 
 * - If element is greater than the value, search the left half of the array
 * 
 * - If the element is less than the value, search the right half of the array
 * 
 */

public class Main {

	public static void main(String[] args) {
		int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };

		System.out.println(binarySearch(intArray, -15));
		System.out.println(binarySearch(intArray, 35));
		System.out.println(binarySearch(intArray, 888));
		System.out.println(binarySearch(intArray, 1));
		
		System.out.println("-------------------------");
		System.out.println(binarySearchRecursive(intArray, -15));
		System.out.println(binarySearchRecursive(intArray, 35));
		System.out.println(binarySearchRecursive(intArray, 888));
		System.out.println(binarySearchRecursive(intArray, 1));
		
	}

	public static int binarySearch(int[] input, int value) {
		int start = 0;
		int end = input.length;

		while (start < end) {
			int midPoint = (start + end) / 2;
			System.out.println("midPoint = " + midPoint);

			if (input[midPoint] == value) {
				return midPoint;
			} else if (input[midPoint] < value) {
				start = midPoint + 1;
			} else {
				end = midPoint;
			}
		}

		return -1;
	}

	public static int binarySearchRecursive(int[] input, int value) {
		return binarySearchRecursive(input, 0, input.length, value);
	}

	private static int binarySearchRecursive(int[] input, int start, int end, int value) {
		if (start >= end) {
			return -1;
		}
		
		int midPoint = (start + end) / 2;
		System.out.println("midPoint = " + midPoint);
		
		if (input[midPoint] == value) {
			return midPoint;
		} else if (input[midPoint] < value) {
			return binarySearchRecursive(input, midPoint + 1, end, value);
		} else {
			return binarySearchRecursive(input, start, midPoint, value);
		}
	}

}
