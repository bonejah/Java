class Motor {
	
}

class Carro {
	int ano;
	char primeiraLetra;
	boolean usado;
	Motor motor;
	String marca;
}

public class Teste {

	public static void main(String[] args) {
		int[] valores = new int[10]; 
		System.out.println(valores[0]);
		System.out.println(valores[1]);
		
		boolean valor = false;
		int x = 15;
		double v = 10.2d;
		long l = 13l;
		float f = 13.1f;
		
		double d2 = 3.1E2;
		System.out.println(d2);
		
		float f2 = 2e3f;
		System.out.println(f2);
		
		long x2 = 1_234_567_891_234l;
		System.out.println(x2);
		
		int idade;
		if (args.length > 10) {
			idade = 15;
		} else {
			System.out.println("faca outra coisa");
			idade = 7;
		}
		System.out.println(idade);
		
		Carro carro = new Carro();
		System.out.println("Ano do carro: " + carro.ano);
		System.out.println("Primeira Letra: " + (carro.primeiraLetra == 0));
		System.out.println("Carro usado: " + carro.usado);
		
		Motor motor = new Motor();
		System.out.println("Motor do carro: " + carro.motor);
		
		System.out.println("Marca do carro: " + carro.marca);
	}
}
