package br.com.devdojo.javacore.padroesdeprojeto.classe;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingleton {
	// EAGER INITIALIZATION
//	private static final AviaoSingleton INSTANCE = new AviaoSingleton();
	
	// LAZY INITIALIZATION
	private static AviaoSingleton INSTANCE;
	
	private Set<String> assentosDisponiveis;
	
	public static AviaoSingleton getInstance() {
		if (INSTANCE == null) {
			// Melhor forma de evitar gargalo na aplicacao
			synchronized (AviaoSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new AviaoSingleton();
				}
			}
		}
		
		return INSTANCE;
	}

	private AviaoSingleton() {
		this.assentosDisponiveis = new HashSet<>();
		this.assentosDisponiveis.add("1A");
		this.assentosDisponiveis.add("1B");
	}
	
	public boolean bookAssento(String assento) {
		return assentosDisponiveis.remove(assento);
	}
	
}
