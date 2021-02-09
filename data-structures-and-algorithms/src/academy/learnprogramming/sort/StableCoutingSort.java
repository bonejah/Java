package academy.learnprogramming.sort;

/**
 * Stable Couting Sort
 * 
 * - Requires extra steps
 * 
 * - Can canculate where values should be written back to the original array
 * 
 * - Writing the values into the array in backwards order ensures stabiliy
 *
 * brunolima on Feb 1, 2021
 * 
 */

public class StableCoutingSort {

	public static void main(String[] args) {

		int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
		
	
		for (int i = 0; i < intArray.length; i++) {
			if (i != intArray.length - 1) {
				System.out.print(intArray[i] + ", ");
			} else {
				System.out.print(intArray[i]);
			}
		}
	}

}
