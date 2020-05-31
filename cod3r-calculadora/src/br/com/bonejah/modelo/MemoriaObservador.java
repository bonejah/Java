package br.com.bonejah.modelo;

@FunctionalInterface
public interface MemoriaObservador {

	void valorAlterado (String novoValor);
	
}
