package controle.desafios;

import java.util.Scanner;

public class Desafio5 {

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
		
		switch (countDivisores) {
		case 0:
			System.out.println("Número é primo.");
			 break;
		default: 	
			System.out.println("Número não é primo.");
		}
		

		scanner.close();
	}
}
