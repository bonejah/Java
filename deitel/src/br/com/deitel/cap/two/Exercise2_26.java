package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_26 {
	public static void main(String[] args) {
		int a, b;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first number: ");
		a = scanner.nextInt();
		
		System.out.println("Enter Second number: ");
		b = scanner.nextInt();

		if (a % b == 0)
			System.out.printf("The number %d is multiple %d", a, b);	
		else 
			System.out.printf("The number %d is not multiple %d", a, b);
	}
}
