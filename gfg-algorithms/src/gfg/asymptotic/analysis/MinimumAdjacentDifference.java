package gfg.asymptotic.analysis;

import java.util.Vector;

public class MinimumAdjacentDifference {

	public static void main(String[] args) {

		int [] arr = {3, 7, 8 ,10, 14};
		int n = 5;
		int k = 2;
		
//		System.out.println(minimumAdjacentDifference(arr, n, k));
		
		System.out.println(1 << 7);
		System.out.println(1 << 6);
		System.out.println(1 << 5);
		System.out.println(1 << 4);
		System.out.println(1 << 3);
		System.out.println(1 << 2);
		System.out.println(1 << 1);
		
		System.out.println("==========");
		
		System.out.println(1 >> 7);
		System.out.println(1 >> 6);
		System.out.println(1 >> 5);
		System.out.println(1 >> 4);
		System.out.println(1 >> 3);
		System.out.println(1 >> 2);
		System.out.println(1 >> 1);

	}

	// Function to find the minimum of the maximum difference of the 
    // adjacent elements after removing K elements from the array 
	private static int minimumAdjacentDifference(int[] arr, int n, int k) {
		
		// Initializing the minimum difference
		int minDiff = Integer.MAX_VALUE;
		
		// Traversing over subsets in interative manner
		for (int i = 0; i < (1 << n); i++) {
			
			
			// Number of elements to be taken in the subset ON bits
			// of i represent elements not to be removed
			int cnt = Integer.bitCount(i);
			
			// If the removed set is of size k 
			if (cnt == n - k) {
				
				// Creating the new array after removing elements
				Vector<Integer> temp = new Vector<Integer>();
				
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) != 0) {
						temp.add(arr[j]);
					}
				}
				
				// Maximum difference of adjacent elements remaining array
				int maxDiff = Integer.MIN_VALUE;
				
				for (int j = 0; j < temp.size() - 1; j++) {
					maxDiff = Math.max(maxDiff,  temp.get(j + 1) - temp.get(j));
				}
				
				minDiff = Math.min(minDiff, maxDiff);
			}
		}
				
		return minDiff;
	}

}
