package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_15 {
	public static void main(String[] args) {
		int a, b, result;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		a = scanner.nextInt();
			
		System.out.println("Enter second number: ");
		b = scanner.nextInt();
		
		System.out.println("The sum is: " + (a+b));
		System.out.println("The subtraction is: " + (a-b));
		System.out.println("The product is: " + (a*b));
		System.out.println("The division is: " + (a/b));
		System.out.println("The rest is: " + (a%b));		
	}
}
