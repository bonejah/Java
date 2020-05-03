package br.com.devdojo.javacore.heranca.sobrescrita.teste;

import br.com.devdojo.javacore.heranca.sobrescrita.Pessoa;

public class PessoaTeste {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("JAPA GIRL");
		pessoa.setIdade(100);
		System.out.println(pessoa);
	}
}
