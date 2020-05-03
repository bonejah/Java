package br.com.devdojo.javacore.interfacedefault;

public interface A {

	default void oi() {
		System.out.println("Dentro do oi de A");
	}

}
