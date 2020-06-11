package oo.composicao;

public class CarroTeste {

	public static void main(String[] args) {
		Carro carro = new Carro();
		System.out.println("Carro está ligado? " + carro.estaLigado());
		
		carro.ligar();
		System.out.println("Carro está ligado? " + carro.estaLigado());
		
		System.out.println("Giros do carro: " + carro.motor.giros());

		carro.acelerar();
		carro.acelerar();
		carro.acelerar();
		carro.acelerar();
		
		carro.frear();
		carro.frear();
		carro.frear();
		carro.frear();
		carro.frear();
		carro.frear();
		
		// Faltou Encapsulamento!!!
//		carro.motor.fatorInjecao = -30;
		
		System.out.println("Giros do carro: " + carro.motor.giros());
	}
	
	
	
}
