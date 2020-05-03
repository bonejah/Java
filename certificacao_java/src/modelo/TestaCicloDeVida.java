package modelo;

public class TestaCicloDeVida {

	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.ano = 2017;
		carro.modelo = "Ferrari";
		System.out.println(carro);
		
		carro = new Carro();
		System.out.println(carro);
		
		carro = null;
		System.out.println(carro);
		
		if (15 > 10) {
			Carro carro2 = new Carro();
			carro2.ano = 2010;
			System.out.println(carro2);
		}

		Carro carro3 = null;
		for (int i = 0; i < 10; i++) {
			carro3 = new Carro();
			carro3.ano = (2010 + i);
		}
		System.out.println(carro3);
		
		
		
	}
}
