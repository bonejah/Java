package practice.java;

import java.util.Scanner;

public class _27_Java1DArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] a = new int [n];
		int value = 0;
		
		for (int i = 0; i < a.length; i++) {
			value = scan.nextInt();
			a[i] = value;
		}

		scan.close();

		// Prints each sequential element in array a
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
