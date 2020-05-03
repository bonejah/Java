package br.com.deitel.cap.seven;

public class InitArray {
	public static void main(String[] args) {
		int[] array;
		array = new int[10];
		
		System.out.printf("%s%8s\n", "Index", "Value");
		
		for (int counter = 0; counter < array.length; counter++) {
			System.out.printf("%5d%8d\n", counter, array[counter]);
		}
		
		int[] array2 = {7, 10, 15, 20, 25};
		
		System.out.printf("\n%s%8s\n", "Index", "Value");
		
		for (int counter = 0; counter < array2.length; counter++) {
			System.out.printf("%5d%8d\n", counter, array2[counter]);
		}
	}
}
