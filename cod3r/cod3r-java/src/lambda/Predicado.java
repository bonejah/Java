package lambda;

import java.util.function.Predicate;

public class Predicado {

	public static void main(String[] args) {
		
		Predicate<Produto> isCaro = prod -> (prod.preco * (1 - prod.desconto)) >= 750;
				
		Produto macBookAir = new Produto("MacBook Air", 20000.00, 0.75);
		Produto penDrive = new Produto("Pen Drive", 50.00, 0.0);
		
		System.out.println("MacBook Air é caro: " + isCaro.test(macBookAir));
		System.out.println("Pendrive é caro: " + isCaro.test(penDrive));
	}
	
}
