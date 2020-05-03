package br.com.devdojo.javacore.lambdas.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import br.com.devdojo.javacore.lambdas.Carro;
import br.com.devdojo.javacore.lambdas.ComparadorCarro;

public class LambdaMethodReferencesTest {

	public static void main(String[] args) {
		forEach(Arrays.asList("Bruno", "Leticia", "Bianca", "Matheus"), System.out::println);

		List<Carro> carros = Arrays.asList(new Carro("vermelho", 2011), new Carro("preto", 2019),
				new Carro("azul", 2000));
		System.out.println(carros);

//		Collections.sort(carros, new Comparator<Carro>() {
//			@Override
//			public int compare(Carro o1, Carro o2) {
//				return o1.getCor().compareTo(o2.getCor());
//			}
//		});
//		System.out.println(carros);

//		Collections.sort(carros, (o1, o2) -> o1.getCor().compareTo(o2.getCor()));
//		System.out.println(carros);

		Collections.sort(carros, ComparadorCarro::compareByColor);
		System.out.println(carros);

		ComparadorCarro comparadorCarro = new ComparadorCarro();
		Collections.sort(carros, comparadorCarro::compareByYear);
		System.out.println(carros);

		List<String> listNomes = Arrays.asList("Bruno", "Leticia", "Bianca", "Matheus");
		System.out.println(listNomes);
		listNomes.sort(String::compareTo);
		System.out.println(listNomes);

		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger2 = Integer::parseInt;
		System.out.println(stringToInteger.apply("1000"));
		BiPredicate<List<String>, String> contains = (lista, elemento) -> lista.contains(elemento);
		BiPredicate<List<String>, String> contains2 = List::contains;
		System.out.println("Contem nome Bruno? : " + contains2.test(listNomes, "Bruno"));
		
		Supplier<ComparadorCarro> comparadorSuplier = ComparadorCarro::new;
		comparadorSuplier.get();
		BiFunction<String, Integer, Carro> carroBiFunction = (s, i) -> new Carro(s, i);
		BiFunction<String, Integer, Carro> carroBiFunction2 = Carro::new;
		System.out.println(carroBiFunction2.apply("rosa", 1000));
		

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
