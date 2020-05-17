package practice.java;

import java.util.Scanner;

public class _29_JavaSubArray {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sizeArray = scan.nextInt();
		int[] array = new int[sizeArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
		}
		
		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
		}
		
		scan.close();
		
	}

}
