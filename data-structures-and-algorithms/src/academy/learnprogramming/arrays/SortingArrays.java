package academy.learnprogramming.arrays;

import java.util.Arrays;

/**
*
* brunolima on Feb 1, 2021
* 
*/

public class SortingArrays {
	
	public static void main(String[] args) {
		
		int[] intArray = {20, 35, -15, 7, 55, 1, -22};
		
		
		long begin = System.currentTimeMillis();
		Arrays.sort(intArray);
		long end = System.currentTimeMillis();
		
		System.out.println("Time execution: " + (end - begin));
		
		for (int i : intArray) {
			System.out.println(i);
		}
		
		begin = System.currentTimeMillis();
		int[] intArray2 = {20, 35, -15, 7, 55, 1, -22};
		end = System.currentTimeMillis();
		
		System.out.println("Time execution: " + (end - begin));
		
		Arrays.parallelSort(intArray2);
		
		for (int i : intArray) {
			System.out.println(i);
		}
	}

}

