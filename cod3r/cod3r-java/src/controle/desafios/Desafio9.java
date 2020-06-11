package controle.desafios;

import java.util.Scanner;

public class Desafio9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int maiorNumero = 0;
		int contador = 0;
		
		do {
			int valorInformado = scanner.nextInt();
			
			if (valorInformado > maiorNumero) {
				maiorNumero = valorInformado;
			}
			
			contador++;
			
		} while (contador != 10);
		
		System.out.println("Maior número é: " + maiorNumero);
		

		scanner.close();
		
	}
	
}
