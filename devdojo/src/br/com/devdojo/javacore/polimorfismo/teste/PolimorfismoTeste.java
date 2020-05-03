package br.com.devdojo.javacore.polimorfismo.teste;

import br.com.devdojo.javacore.polimorfismo.Gerente;
import br.com.devdojo.javacore.polimorfismo.RelatorioPagamento;
import br.com.devdojo.javacore.polimorfismo.Vendedor;

public class PolimorfismoTeste {

	public static void main(String[] args) {
		Gerente gerente = new Gerente("Bruno", 5000, 2000);
		Vendedor vendedor = new Vendedor("Yuri", 2000, 20000);
		
		RelatorioPagamento relatorioPagamento = new RelatorioPagamento();
//		relatorioPagamento.relatorioPagamentoGerente(gerente);
//		System.out.println("-------------------------------");
//		relatorioPagamento.relatorioPagamentoVendedor(vendedor);
		
		relatorioPagamento.relatorioPagamentoGenerico(gerente);
		System.out.println("-------------------------------");
		relatorioPagamento.relatorioPagamentoGenerico(vendedor);
	}
}
