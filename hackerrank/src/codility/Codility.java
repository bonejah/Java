package codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Codility {

	/**
	 * This is a demo task.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given an array A of N integers, returns the smallest positive integer
	 * (greater than 0) that does not occur in A.
	 * 
	 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	 * 
	 * Given A = [1, 2, 3], the function should return 4.
	 * 
	 * Given A = [−1, −3], the function should return 1.
	 * 
	 * Write an efficient algorithm for the following assumptions:
	 * 
	 * N is an integer within the range [1..100,000]; each element of array A is an
	 * integer within the range [−1,000,000..1,000,000].
	 * 
	 */

	public static void main(String[] args) {
		// Example test: [1, 3, 6, 4, 1, 1] The smallest is: 5
		int a[] = { 1, 3, 6, 4, 1, 1 };

		// Example test: [1, 2, 3] The smallest is: 0
		// int a [] = { 1, 2, 3};

		// Example test: [-1, -3] The smallest is: -2
		// int a[] = { -1, -3 };
		solution(a);
	}

	public static int solution(int[] A) {
		List<Integer> arraySorted = Arrays.stream(A).distinct().sorted().boxed()
				.collect(Collectors.toList());

		Integer max = arraySorted.get(arraySorted.size() - 1);

		while (true) {
			boolean contains = arraySorted.contains(max);

			if (!contains) {
				break;
			}

			max--;
		}

		return max;
	}

}
