package br.com.devdojo.javacore.lambdas.teste;

import java.util.function.Predicate;

import br.com.devdojo.javacore.comportamentoporparamentro.Carro;
import br.com.devdojo.javacore.lambdas.CarroPredicate;

public class LambdaPredicateTest {

	public static void main(String[] args) {
		CarroPredicate carroPredicate = new CarroPredicate() {
			@Override
			public boolean test(Carro carro) {
				return carro.getCor().equals("verde");
			}
		};
		System.out.println(carroPredicate.test(new Carro("verde", 2019)));

		CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
		System.out.println(carroPredicate2.test(new Carro("verde", 2019)));
		
		Predicate<Carro> carroPredicate3 = (Carro carro) -> carro.getCor().equals("verde");
		System.out.println(carroPredicate3.test(new Carro("verde", 2019)));
	}

}
