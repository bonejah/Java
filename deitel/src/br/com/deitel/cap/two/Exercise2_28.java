package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_28 {
	public static void main(String[] args) {
		float a;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first number: ");
		a = scanner.nextInt();

		System.out.printf("Diameter is: %2.0f\n", (2 * a));
		System.out.printf("Circunference is: %2.1f\n", (2 * Math.PI * a));
		System.out.printf("Area is: %2.3f\n", (Math.PI * Math.pow(a, 2)));
	}
}
