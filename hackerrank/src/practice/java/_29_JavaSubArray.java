package practice.java;

import java.util.Scanner;

public class _29_JavaSubArray {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sizeArray = scan.nextInt();
		int[] array = new int[sizeArray];
		
		for (int i = 0; i < sizeArray; i++) {
			array[i] = scan.nextInt();
		}
		
		int totalNumberSubArraysNegatives = 0;
		
		/// 1, -2, 4, -5, 1
		
		for (int i = 0; i < sizeArray; i++) {
			System.out.println("Passada " + i + " no for do 'i'");
			
			for(int j = 0; j < sizeArray; j++) {
				System.out.println("Passada " + j + " no for do 'j'");
				
				int sum = 0;
				
				for (int k = i; k <= j; k++) {
					System.out.println("Passada " + k + " no for do 'k'");
					System.out.println("Soma: " + sum + " + " +  array[k]);
					sum = sum + array[k];
					System.out.println("Resultado: " + sum);
				}
				
				if (sum < 0) {
					totalNumberSubArraysNegatives++;
					System.out.println("Total subarrays negatives: " + totalNumberSubArraysNegatives);
				}
				
				System.out.println("*******************************");
			}
			
			System.out.println("===================================");
		}
		
		System.out.println(totalNumberSubArraysNegatives);
		
		scan.close();
		
	}

}
