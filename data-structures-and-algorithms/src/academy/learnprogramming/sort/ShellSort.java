package academy.learnprogramming.sort;

/**
 * Shell Sort
 * 
 * - Variation of Insertion Sort
 * 
 * - Insertion sort chooses wich element to insert using a gap of 1
 * 
 * - Shell Sort starts out using a larger gap value
 * 
 * - As the algorithm runs, the gap is reduced
 * 
 * - Goal is to reuce the amount of shifting required
 * 
 * @author brunolima
 *
 */

public class ShellSort {

	public static void main(String[] args) {
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

		for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < intArray.length; i++) {
				int newElement = intArray[i];
				
				int j = i;
				
				while(j >= gap && intArray[j - gap] > newElement) {
					intArray[j] = intArray[j - gap];
					j -= gap;
				}
				
				intArray[j] = newElement;
			}
		}

		for (int i = 0; i < intArray.length; i++) {
			if (i != intArray.length - 1) {
				System.out.print(intArray[i] + ", ");
			} else {
				System.out.print(intArray[i]);
			}
		}
	}

}
