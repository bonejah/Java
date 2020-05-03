package br.com.devdojo.javacore.lambdas.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import br.com.devdojo.javacore.lambdas.Carro;

public class LambdaConsumerTest {

	public static void main(String[] args) {
		forEach(Arrays.asList("Bruno", "Leticia", "Bianca", "Matheus"), (String s) -> System.out.println(s));
		
		List<Integer> list = map(Arrays.asList("Bruno", "Leticia", "Bianca", "Matheus"), (String s) -> s.length());
		System.out.println(list);
		
		List<Carro> carros = Arrays.asList(new Carro("vermelho", 2011), new Carro("preto", 2019));
		List<String> listaCoresCarros = map(carros, (Carro carro) -> carro.getCor());
		System.out.println(listaCoresCarros);
		
		
		Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
		System.out.println(pares.test(1000));
		IntPredicate impar = (int i) -> i % 2 == 1;
		System.out.println(impar.test(999));
	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T e : list) {
			c.accept(e);
		}
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();

		for (T e : list) {
			result.add(f.apply(e));
		}
		return result;
	}

}
