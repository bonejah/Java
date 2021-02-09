package academy.learnprogramming.arrays;

public class ArraysTest {
	
	/**
	 * 
	 * Arrays:
	 * 
	 * - Contiguous block in memory
	 * 
	 * - Every element occupies the same amount of space in memory
	 * 
	 * - If an array starts at memory address x, and the size of each element in the array
	 * is y, we can calculate the memory address of the ith  element by using
	 * the following expression: x + i * y
	 * 
	 * Example: Create an array int (4bytes)  with size 7
	 * 
	 * Starts address of array = 12, element size = 4 bytes
	 * Address of array[0] = 12 + (0 * 4) = 12
	 * Address of array[1] = 12 + (1 * 4) = 16
	 * Address of array[2] = 12 + (2 * 4) = 20
	 * Address of array[3] = 12 + (3 * 4) = 24
	 * Address of array[4] = 12 + (4 * 4) = 28
	 * Address of array[5] = 12 + (5 * 4) = 32
	 * Address of array[6] = 12 + (5 * 4) = 36
	 * 
	 * 
	 * - If we know the index of an element, the time to retrieve the element
	 * will be the same, no matter where it is in the array
	 */
	
	public static void main(String[] args) {
		int [] intArray = new int[7];
		
		System.out.println("Size array: " + intArray.length);
		
		System.out.println("\nBefore: ");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("index[" + i + "] = " + intArray[i]);
		}
		
		intArray[0] = 10;
		intArray[1] = 433;
		intArray[2] = 54;
		intArray[3] = 176;
		intArray[4] = 334;
		intArray[5] = 90;
		
		
		System.out.println("\nAfter: ");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("index[" + i + "] = " + intArray[i]);
		}
		
		System.out.println();

		int index = -1;
		
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == 54) {
				index = i;
				break;
			}
		}
		
		System.out.println("Looking position for the number 54 in array");
		System.out.println("index = " + index);
	}

}
