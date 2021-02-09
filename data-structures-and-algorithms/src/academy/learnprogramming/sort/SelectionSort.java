package academy.learnprogramming.sort;


/**
 * Selection Sort
 * 
 * - In-place algorithm
 * 
 * - O(n2) time complexity- quadratic
 * 
 * - It will take 100 steps to sort 10 items, 10000 steps to sort 100 items, 1000000 steps to sort 1000 items
 * 
 * - Doesn't requires much swapping as bubble sort 
 * 
 * - Unstable algorithm
 * 
 * @author brunolima
 *
 */

public class SelectionSort {

	public static void main(String[] args) {

		int[] intArray = { 20, 35, -15, 7, 55, 1, -22};
		
//		int lastValueInArray = intArray[intArray.length - 1];
//		int lastIndexInArray = intArray.length - 1;
//		
//		System.out.println("Last value in Array: " + lastValueInArray);
//		System.out.println("Last index in Array: " + lastIndexInArray);
//		
		System.out.println("\nArray unsorted: ");
		
		for (int i : intArray) {
			System.out.print(i + " ");
		}

		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

			int largest = 0;
			
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[largest]) {
					largest = i;
				}
			}
			
			swap(intArray, largest, lastUnsortedIndex);
		}
		
		System.out.println("\n\nArray sorted: ");
		for (int i : intArray) {
			System.out.print(i + " ");
		}

	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) return;

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	
}
