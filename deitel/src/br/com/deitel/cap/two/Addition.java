// Programa de adição que exibe a soma de dois números

package br.com.deitel.cap.two;

import java.util.Scanner;

public class Addition {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number1;
		int number2;
		int sum;

		System.out.printf("Enter first integer:");
		number1 = input.nextInt();

		System.out.printf("Enter second integer:");
		number2 = input.nextInt();

		sum = number1 + number2;

		System.out.printf("Sum is %d\n", sum);
	}
}
