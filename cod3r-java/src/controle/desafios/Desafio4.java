package controle.desafios;

import java.util.Scanner;

public class Desafio4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe um número: ");
		int numero = scanner.nextInt();
		
		int countDivisores = 0;
		
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				countDivisores++;
			}
		}
		
		if (countDivisores == 0) {
			System.out.println("Número é primo.");
		} else {
			System.out.println("Número não é primo.");
		}
		

		scanner.close();
	}
}
