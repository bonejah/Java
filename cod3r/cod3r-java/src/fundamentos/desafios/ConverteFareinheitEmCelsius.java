package fundamentos.desafios;

import java.util.Scanner;

public class ConverteFareinheitEmCelsius {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Informe uma temperatura em Fahrenheit: ");

		double tempFahreinheit = entrada.nextDouble();
		double tempCelsius = (tempFahreinheit - 32) * (5.0 / 9.0);

		System.out.printf("Temperatura %.2f fahreinheit -> Convertida em Celsius: %.2f", tempFahreinheit, tempCelsius);
		entrada.close();
	}

}
