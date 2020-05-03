package br.com.devdojo.javacore.enumclasses.teste;

import br.com.devdojo.javacore.enumclasses.Cliente;
import br.com.devdojo.javacore.enumclasses.Cliente.TipoPagamento;
import br.com.devdojo.javacore.enumclasses.TipoCliente;

public class ClienteTeste {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente("ANA", TipoCliente.PESSOA_JURIDICA, TipoPagamento.APRAZO);
		System.out.println(cliente);
		System.out.println(TipoCliente.PESSOA_FISICA.getId());
		System.out.println(TipoCliente.PESSOA_JURIDICA.getId());
	}
}
