package br.com.devdojo.javacore.optional.teste;

import java.util.Optional;

public class OptionalTest1 {
	String nome;
	
	public static void main(String[] args) {
		OptionalTest1 op1 = new OptionalTest1();
		Optional<String> optional1  = Optional.of("BPCL");
		Optional<String> optional2  = Optional.empty();
		Optional<String> optional3  = Optional.ofNullable(op1.nome);
		
		System.out.println(optional1);
		System.out.println(optional2);
		System.out.println(optional3);
		
		System.out.println(optional1.get());
		System.out.println(optional2.orElse("vazio"));
		System.out.println(optional3.orElse("vazio"));
		
	}

}
