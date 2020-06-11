package controle.desafios;

import java.util.Scanner;

public class Desafio3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double media = 0;
		double nota = 0;
		
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Informe a nota: ");
			nota += scanner.nextDouble();
		}

		media = nota / 2;
		
		if (media >= 7) {
			System.out.println("Aprovado");
		} else if (media < 7 && media >= 4) {
			System.out.println("Recuperação");
		} else {
			System.out.println("Reprovado");
		}
		
		scanner.close();
	}
}
