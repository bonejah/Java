package fundamentos.desafios;

import java.util.Scanner;

public class CalculoIMC {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe seu peso:");
		double peso = teclado.nextDouble();

		System.out.println("Informe sua altura:");
		double altura = teclado.nextDouble();

		teclado.close();

		double imc = peso / (altura * altura);

		System.out.printf("IMC -> %.2f\n", imc);

		if (imc < 18.5) {
			System.out.println("Abaixo do peso");
		} else if (imc >= 18.5 && imc <= 24.9) {
			System.out.println("Peso normal");
		} else if (imc >= 25 && imc <= 29.9) {
			System.out.println("Sobrepeso");
		} else if (imc >= 30 && imc <= 34.9) {
			System.out.println("Obesidade Grau 1");
		} else if (imc >= 35 && imc <= 39.9) {
			System.out.println("Obesidade Grau 2");
		} else if (imc >= 40) {
			System.out.println("Obesidade Grau 3");
		}
	}

}
