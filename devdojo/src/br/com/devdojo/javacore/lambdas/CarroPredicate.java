package br.com.devdojo.javacore.lambdas;

import br.com.devdojo.javacore.comportamentoporparamentro.Carro;

@FunctionalInterface
public interface CarroPredicate {
	boolean test(Carro carro);
}
