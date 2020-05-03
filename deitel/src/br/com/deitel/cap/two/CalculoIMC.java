package br.com.deitel.cap.two;

import java.util.Scanner;

public class CalculoIMC {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Report your weight: ");
		double peso = input.nextDouble();

		System.out.println("Report your height: ");
		double altura = input.nextDouble();

		double imc = peso / (altura * altura);

		if (imc < 18.5)
			System.out.printf("Underweight: less than 18.5, your imc = %2.0f", imc);

		if (imc >= 18.5 && imc <= 24.9)
			System.out.printf("Normal: between 18.5 and 24.9, your imc = %2.0f", imc);

		if (imc >= 25 && imc <= 29.9)
			System.out.printf("Overweight: between 25 and 29.9, your imc = %2.0f", imc);

		if (imc >= 30)
			System.out.printf("Obese: 30 or greater, your imc = %2.0f", imc);
	}
}
