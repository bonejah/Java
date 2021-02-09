package academy.learnprogramming.mysorts;

import java.util.Arrays;

/**
*
* brunolima on Feb 1, 2021
* 
*/

public class MainBubbleSort {

	public static void main(String[] args) {
		int[] intArray = { 434, 78, 9032, 120, 1, 323};
		
		sortOrderAsc(intArray);
		
		System.out.println();
		
		sortOrderDesc(intArray);
	}

	private static void sortOrderDesc(int[] intArray) {
		for(int lastIndex = intArray.length - 1; lastIndex > 0; lastIndex--) {
			for (int i = 0; i < lastIndex; i++) {
				
				if (intArray[i] < intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
		}
		
		System.out.print("Print array order desc => ");
		Arrays.stream(intArray).forEach(value -> System.out.printf("%d ", value));
	}

	private static void sortOrderAsc(int[] intArray) {
		for(int lastIndex = intArray.length - 1; lastIndex > 0; lastIndex--) {
			for (int i = 0; i < lastIndex; i++) {
				
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
		}
		
		System.out.print("Print array order asc => ");
		Arrays.stream(intArray).forEach(value -> System.out.printf("%d ", value));
	}
	
	private static void swap(int[] intArray, int i, int j) {
		// If they same vale do nothing
		if (i == j) return;
		
		int swap = intArray[i];
		intArray[i] = intArray[j];
		intArray[j] = swap;
	}
	
}

