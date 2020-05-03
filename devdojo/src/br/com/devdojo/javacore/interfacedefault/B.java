package br.com.devdojo.javacore.interfacedefault;

public interface B {
	
	default void oi() {
		System.out.println("Dentro do oi de B");
	}

}
