package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_16 {
	public static void main(String[] args) {	
		int a, b, result;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		a = scanner.nextInt();
			
		System.out.println("Enter second number: ");
		b = scanner.nextInt();
		
		if (a > b)
			System.out.println(a + " is larger");
		
		if (b > a)
			System.out.println(b + " is larger");
		
		if (a == b)
			System.out.println("These numbers are equal");
	}
}
