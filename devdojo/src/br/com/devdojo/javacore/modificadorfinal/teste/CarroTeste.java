package br.com.devdojo.javacore.modificadorfinal.teste;

import br.com.devdojo.javacore.modificadorfinal.Carro;
import br.com.devdojo.javacore.modificadorfinal.Subaru;

public class CarroTeste {
	
	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.setNome("GOL");
		carro.setMarca("VW");
		System.out.println(carro);
		System.out.println(Carro.VELOCIDADE_FINAL);
		carro.getComprador().setNome("TADEU");
		System.out.println(carro);
		
		Subaru subaru = new Subaru();
		
	}

}
