package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_5 {
	public static void main(String[] args) {
		int x, y, z, result;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter first number: ");
		x = input.nextInt();

		System.out.println("Enter second number: ");
		y = input.nextInt();

		System.out.println("Enter third number: ");
		z = input.nextInt();

		result = x * y * z;

		System.out.printf("Product is: %d\n", result);
	}
}
