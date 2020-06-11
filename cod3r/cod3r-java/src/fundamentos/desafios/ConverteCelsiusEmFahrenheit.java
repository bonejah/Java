package fundamentos.desafios;

import java.util.Scanner;

public class ConverteCelsiusEmFahrenheit {
	
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Informe uma temperatura em Celsius: ");

		double tempCelsius = entrada.nextDouble();
		double tempFahreinheit = (1.8 * tempCelsius) + 32;

		System.out.printf("Temperatura %.2f Celsius -> Convertida em Fahreinheit: %.2f", tempCelsius, tempFahreinheit);
		entrada.close();
	}

}
