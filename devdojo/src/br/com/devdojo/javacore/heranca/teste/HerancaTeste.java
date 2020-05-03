package br.com.devdojo.javacore.heranca.teste;

import br.com.devdojo.javacore.heranca.Endereco;
import br.com.devdojo.javacore.heranca.Funcionario;
import br.com.devdojo.javacore.heranca.Pessoa;

public class HerancaTeste {
	
	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setRua("Rua das Couves 20");
		endereco.setBairro("25 de Março");
		
//		Pessoa pessoa = new Pessoa("JOSENILDO");
//		pessoa.setCpf("123.456.789-00");
//		pessoa.setNome("JOSENILDO");
//		pessoa.setEndereco(endereco);
//		pessoa.print();
		
		System.out.println("---------------------");
		
		Funcionario funcionario = new Funcionario("AUGUSTO FUNCIONARIO");
//		funcionario.setNome("AUGUSTO FUNCIONARIO");
		funcionario.setCpf("987.654.321-00");
		funcionario.setEndereco(endereco);
		funcionario.setSalario(5000.00);
//		funcionario.print();
		
	}

}
