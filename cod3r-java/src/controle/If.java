package controle;

import java.util.Scanner;

public class If {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe a média: ");
		double media = scanner.nextDouble();

		boolean criterioAprovacaoAtingido = media >= 7.0 && media < 10.0;

		if (criterioAprovacaoAtingido) {
			System.out.println("Aprovado!");
			System.out.println("Parabéns!");
		}

		boolean criterioRecuperacaoAtingido = media < 7.0 && media >= 4.5;
		if (criterioRecuperacaoAtingido) {
			System.out.println("Recuperação!");
		}

		boolean criterioReprovacaoAtingido = media < 4.5 && media >= 0;
		if (criterioReprovacaoAtingido) {
			System.out.println("Reprovado!");
		}

		scanner.close();
	}

}
