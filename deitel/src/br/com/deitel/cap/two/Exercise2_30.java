package br.com.deitel.cap.two;

import java.util.Scanner;

public class Exercise2_30 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Report a number with 5 digits: ");
		int numInformado = scanner.nextInt();

		int num1 = numInformado / 10000;
		int num2 = (numInformado / 1000) % 10;
		int num3 = ((numInformado / 100) % 10);
		int num4 = ((numInformado / 10) % 10);
		int num5 = ((numInformado / 1) % 10);
		
		System.out.printf("Número digitado: %d %d %d %d %d", num1, num2, num3, num4, num5);
	}
}
