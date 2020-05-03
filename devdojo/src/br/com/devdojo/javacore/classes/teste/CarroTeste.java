package br.com.devdojo.javacore.classes.teste;

import br.com.devdojo.javacore.classes.Carro;

public class CarroTeste {

	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.modelo = "GOL";
		carro.placa = "XPT1234";
		carro.velocidadeMaxima = 120;

		System.out.println(carro.modelo);
		System.out.println(carro.placa);
		System.out.println(carro.velocidadeMaxima);
	}
	
}
