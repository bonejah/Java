package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_25 {
	public static void main(String[] args) {
		int a;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number: ");
		a = scanner.nextInt();

		if (a % 2 == 0)
			System.out.printf("The number %d is even", a);

		if (a % 2 == 1)
			System.out.printf("The number %d is odd", a);
	}
}
