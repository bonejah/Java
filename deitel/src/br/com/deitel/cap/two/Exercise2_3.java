package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_3 {
	public static void main(String[] args) {
		int c, thisIsAVariable, q76345;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		int value = scanner.nextInt();
		
		System.out.println("This is a Java program");
		System.out.println("This is a Java\nprogram");
		System.out.printf("%s\n%s\n", "This is a Java", "program");
		
		if (value != 7)
			System.out.println("This variable number is not equal to 7");
	}
}
