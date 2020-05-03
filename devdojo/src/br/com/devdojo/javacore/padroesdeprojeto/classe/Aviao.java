package br.com.devdojo.javacore.padroesdeprojeto.classe;

import java.util.HashSet;
import java.util.Set;

public class Aviao {
	private Set<String> assentosDisponiveis;
	
	public Aviao() {
		this.assentosDisponiveis = new HashSet<>();
		this.assentosDisponiveis.add("1A");
		this.assentosDisponiveis.add("1B");
	}
	
	public boolean bookAssento(String assento) {
		return assentosDisponiveis.remove(assento);
	}
	
}
