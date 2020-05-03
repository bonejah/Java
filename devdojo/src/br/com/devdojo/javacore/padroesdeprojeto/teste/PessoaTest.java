package br.com.devdojo.javacore.padroesdeprojeto.teste;

import br.com.devdojo.javacore.padroesdeprojeto.classe.Pessoa;

public class PessoaTest {
	
	public static void main(String[] args) {
		Pessoa bruno = new Pessoa.PessoaBuilder().nome("Bruno").nomeDoMeio("Paulo Costa").ultimoNome("Lima")
				.apelido("bonejah").nomeDoPai("Ze").build();
		
		System.out.println(bruno);
		
		
	}

}
