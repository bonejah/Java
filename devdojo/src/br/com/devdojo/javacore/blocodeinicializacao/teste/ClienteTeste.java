package br.com.devdojo.javacore.blocodeinicializacao.teste;

import br.com.devdojo.javacore.blocodeinicializacao.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		System.out.println("Exibindo quantidade de parcelas");
		
		for (int parcela : cliente.getParcelas()) {
			System.out.print(parcela + " ");
		}
	}
}
