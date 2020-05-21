package controle.desafios;

import java.util.Random;
import java.util.Scanner;

public class Desafio6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Sorteando numero entre 0 e 100...");

		Random random = new Random();
		int valorGerado = random.nextInt(101);
		System.out.println(valorGerado);

		for (int tentativas = 10; tentativas >= 0; tentativas--) {
			System.out.println("Informe um numero e tente adivinhar: ");
			int numeroInformado = scanner.nextInt();

			if (numeroInformado == valorGerado) {
				System.out.printf("Parabens você acertou o número escolhido: %d, você digitou %d!", valorGerado,
						numeroInformado);
				break;
			} else if (numeroInformado > valorGerado) {
				System.out.println("O número informado é maior que o valor escolhido, tente novamente!");
				System.out.printf("Você ainda tem %d tentativas\n\n", tentativas);
			} else if (numeroInformado < valorGerado) {
				System.out.println("O número informado é menor que o valor escolhido, tente novamente!");
				System.out.printf("Você ainda tem %d tentativas\n\n", tentativas);
			}
		}

		scanner.close();

	}
}
