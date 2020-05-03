package br.com.devdojo.javacore.optional.teste;

import java.util.Optional;

import br.com.devdojo.javacore.optional.Seguradora;

public class OptionalTest2 {

	public static void main(String[] args) {
		Seguradora seguradora = new Seguradora("SSSS");
		System.out.println(obterNomeSeguradoraOptional(seguradora));
	}

	private static String obterNomeSeguradoraOptional(Seguradora seguradora) {
		System.out.println(Optional.ofNullable(seguradora));
 
		return "";
	}

	private static String obterNomeSeguradora(Seguradora seguradora) {
		String nome = "";

		if (seguradora.getNome() != null) {
//			nome = seguradora.getNome();
		}

		return nome;
	}

}
