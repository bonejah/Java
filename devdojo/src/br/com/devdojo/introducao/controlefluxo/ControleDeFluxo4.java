package br.com.devdojo.introducao.controlefluxo;

public class ControleDeFluxo4 {

	public static void main(String[] args) {
		int contador = 0;

		while (contador < 10) {
			System.out.println(++contador);
		}

		do {
			System.out.println("Dentro do DO WHILE");
		} while (contador < 10);

		for (int i = 0; i < 10; i++) {
			System.out.println("Dentro do FOR: " + i);
			
			if (i == 5) {
				break;
			}
		}
	}
}
