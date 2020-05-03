package br.com.devdojo.javacore.padroesdeprojeto.classe;

import java.util.HashSet;
import java.util.Set;

public enum AviaoSingletonEnum {
	INSTANCE;
	
	private Set<String> assentosDisponiveis;
	
	private AviaoSingletonEnum() {
		this.assentosDisponiveis = new HashSet<>();
		this.assentosDisponiveis.add("1A");
		this.assentosDisponiveis.add("1B");
	}
	
	public boolean bookAssento(String assento) {
		return assentosDisponiveis.remove(assento);
	}
	
	public static void agendarAssento(String assento) {
		AviaoSingletonEnum aviaoSingleton = AviaoSingletonEnum.INSTANCE;
		System.out.println(aviaoSingleton.bookAssento(assento));
	}

}
