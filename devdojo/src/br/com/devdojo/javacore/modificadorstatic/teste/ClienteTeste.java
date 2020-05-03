package br.com.devdojo.javacore.modificadorstatic.teste;

import br.com.devdojo.javacore.modificadorstatic.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		System.out.println("Exibindo quantidade de parcelas");
		
		for (int parcela : Cliente.getParcelas()) {
			System.out.print(parcela + " ");
		}
		
		System.out.println();
		
		for (int parcela : Cliente.getParcelas()) {
			System.out.print(parcela + " ");
		}
		
		System.out.println();
		
		for (int parcela : Cliente.getParcelas()) {
			System.out.print(parcela + " ");
		}
		
		System.out.println();
	}
}
