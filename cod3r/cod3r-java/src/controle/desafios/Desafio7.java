package controle.desafios;

import java.util.Scanner;

public class Desafio7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe um valor (valor negativo -> Sair do programa)");
		int valorInformado = scanner.nextInt();
		
		int total = 0;
		
		while(valorInformado >= 0) {
			total += valorInformado;
			System.out.printf("Total: %d\n\n", total);
			
			System.out.println("Informe um valor (valor negativo -> Sair do programa)");
			valorInformado = scanner.nextInt();
		}
		
		System.out.println("Bye!!!");

		scanner.close();
	}
}
