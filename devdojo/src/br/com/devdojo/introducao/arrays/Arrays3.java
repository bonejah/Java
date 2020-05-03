package br.com.devdojo.introducao.arrays;

public class Arrays3 {

	public static void main(String[] args) {
		int[] numeros1 = new int[4];
		int[] numeros2 = { 1, 2, 3, 4 };
		int[] numeros3 = new int[] { 5, 6, 7, 8 };

//		System.out.println("Size array: " + numeros1.length);
//		for (int i = 0; i < numeros1.length; i++) {
//			numeros1[i] = i;
//			System.out.println(numeros1[i]);
//		}

//		System.out.println("Size array: " + numeros2.length);
//		for (int i = 0; i < numeros2.length; i++) {
//			System.out.println(numeros2[i]);
//		}

//		System.out.println("Size array: " + numeros3.length);
//		for (int i = 0; i < numeros3.length; i++) {
//			System.out.println(numeros3[i]);
//		}
		
		for (int i : numeros3) {
			System.out.println(i);
		}

	}
}
