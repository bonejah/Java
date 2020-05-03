package br.com.devdojo.javacore.padroesdeprojeto.teste;

import br.com.devdojo.javacore.padroesdeprojeto.classe.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {
	
	public static void main(String[] args) {
		AviaoSingletonEnum.agendarAssento("1A");
		AviaoSingletonEnum.agendarAssento("1A");
	}
	
}
