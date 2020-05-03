package br.com.devdojo.javacore.modificadorstatic.teste;

import br.com.devdojo.javacore.modificadorstatic.Carro;

public class CarroTeste {

	public static void main(String[] args) {
		Carro bmw = new Carro("BMW", 200);
		Carro audi = new Carro("AUDI", 170);
		Carro mercedes = new Carro("MERCEDES", 270);
		
		bmw.imprime();
		audi.imprime();
		mercedes.imprime();
		
		Carro.setVelocidadeLimite(100);
		
		bmw.imprime();
		audi.imprime();
		mercedes.imprime();
		
	}
}
