package controle.desafios;

import java.util.Scanner;

public class Desafio1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor, informe um número: ");
		int numero = scanner.nextInt();
		
		if (numero >= 0 && numero <= 10) {
			if (numero %2 == 0) {
				System.out.printf("Número %d é par!", numero);
			}
		} else {
			System.out.println("Por favor, informe um número válido [0 - 10]");
		}

		scanner.close();
	}
}
