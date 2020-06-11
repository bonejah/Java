package fundamentos.desafios;

import java.util.Scanner;

public class CalculaValorEmQuadradoEAoCubo {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe um numero: ");
		double numero = teclado.nextDouble();

		System.out.printf("O numero %.2f\nAo quadrado: %.2f\nAo cubo: %.2f", numero, Math.pow(numero, 2),
				Math.pow(numero, 3));

		teclado.close();
	}

}
