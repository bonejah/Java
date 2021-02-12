package codsignal;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * brunolima on Feb 10, 2021
 * 
 * You are given an array of integers arr. Your task is to construct an array of
 * integers of length arr.length - 2, where the ith element is equal to 1 if
 * arr[i], arr[i + 1], and arr[i + 2] are monotonic, otherwise 0.
 * 
 * Return the resulting array of integers.
 * 
 * Note: a, b, and c are considered monotonic, if the values are strictly
 * increasing (a < b < c) or strictly decreasing (a > b > c).
 * 
 * Example For arr = [1, 2, 1, -4, 5, 10], the output should be
 * checkMonotonicity(arr) = [0, 1, 0, 1].
 * 
 * output[0] = 0 because arr[0], arr[1], and arr[2] aren't monotonic (1 < 2 >
 * 1).
 * 
 * output[1] = 1 because arr[1], arr[2], and arr[3] are monotonic (2 > 1 > -4).
 * 
 * output[2] = 0 because arr[2], arr[3], and arr[4] aren't monotonic (1 > -4 <
 * 5).
 * 
 * output[3] = 1 because arr[3], arr[4], and arr[5] are monotonic (-4 < 5 < 10).
 * 
 * For arr = [10, 10, 10, 10, 10], the output should be checkMonotonicity(arr) =
 * [0, 0, 0].
 * 
 * Since all elements of arr are the same (not strictly increasing or strictly
 * decreasing), all three sets of consecutive elements of arr aren't monotonic.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.integer arr
 * 
 * An array of integers.
 * 
 * Guaranteed constraints: 3 ≤ arr.length ≤ 1000, -109 ≤ arr[i] ≤ 109.
 * 
 * [output] array.integer
 * 
 * Return an array of 0s and 1s where the ith element represents whether arr[i],
 * arr[i + 1], and arr[i + 2] are monotonic.
 * 
 */

public class CheckMonotonicity {

	@Test
	public void checkMonotonicityTests() {
		// Expected Output: [0, 1, 0, 1]
		int[] arr1 = { 1, 2, 1, -4, 5, 10 };
		int[] arr1Expected = { 0, 1, 0, 1 };
//		printResult(checkMonotonicity(arr1));
		assertArrayEquals(arr1Expected, checkMonotonicity(arr1));

		// Expected Output: [0, 0, 0]
		int[] arr2 = { 10, 10, 10, 10, 10 };
		int[] arr2Expected = { 0, 0, 0 };
//		printResult(checkMonotonicity(arr2));
		assertArrayEquals(arr2Expected, checkMonotonicity(arr2));

		// Expected Output: [1, 1, 1]
		int[] arr3 = { 1, 2, 3, 4, 5 };
		int[] arr3Expected = { 1, 1, 1 };
//		printResult(checkMonotonicity(arr3));
		assertArrayEquals(arr3Expected, checkMonotonicity(arr3));
		
		// Expected Output: [1]
		int[] arr4 = { -1000000000, 0, 1000000000 };
		int[] arr4Expected = { 1 };
//		printResult(checkMonotonicity(arr4));
		assertArrayEquals(arr4Expected, checkMonotonicity(arr4));

		// Expected Output: [1, 0, 0, 0, 0, 0, 1]
		int[] arr5 = { 6, 7, 8, 8, 8, 9, 8, 10, 12 };
		int[] arr5Expected = { 1, 0, 0, 0, 0, 0, 1 };
//		printResult(checkMonotonicity(arr5));
		assertArrayEquals(arr5Expected, checkMonotonicity(arr5));
		
		// Expected Output: [1, 1, 0, 0, 1, 1]
		int[] arr6 = { -1, -2, -3, -4, -1, -2, -3, -4 };
		int[] arr6Expected = { 1, 1, 0, 0, 1, 1 };
//		printResult(checkMonotonicity(arr6));
		assertArrayEquals(arr6Expected, checkMonotonicity(arr6));
		
	}

//	private static void printResult(int[] checkMonotonicity) {
//		for (int value : checkMonotonicity) {
//			System.out.print(value + " ");
//		}
//
//		System.out.println();
//	}

	public static int[] checkMonotonicity(int[] arr) {
		int[] arrResult = new int[arr.length - 2];

		for (int i = 0; i < arrResult.length; i++) {
			if (isMonotonic(arr[i], arr[i + 1], arr[i + 2])) {
				arrResult[i] = 1;
			} else {
				arrResult[i] = 0;
			}
		}

		return arrResult;
	}

	public static boolean isMonotonic(int a, int b, int c) {
		return ((a > b && b > c) || (a < b && b < c)) ? true : false;
	}

}
