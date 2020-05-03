package br.com.deitel.cap.twenty.one;

public class OverloadMethods {
	public static void main(String[] args) {
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		printArray(integerArray);
		System.out.println("Array doubleArray contains:");
		printArray(doubleArray);
		System.out.println("Array characterArray contains:");
		printArray(characterArray);
	}

	private static void printArray(Integer[] integerArray) {
		for (Integer element : integerArray) {
			System.out.printf("%s ", element);
		}

		System.out.println();
	}

	private static void printArray(Double[] doubleArray) {
		for (Double element : doubleArray) {
			System.out.printf("%s ", element);
		}

		System.out.println();
	}

	private static void printArray(Character[] characterArray) {
		for (Character element : characterArray) {
			System.out.printf("%s ", element);
		}

		System.out.println();
	}	
}
