package br.com.devdojo.javacore.streams.teste;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.devdojo.javacore.streams.Pessoa;

public class StreamTest4 {

	public static void main(String[] args) {
		Optional<Integer> reduce = getStream().stream().reduce((x, y) -> x + y);
		System.out.println(reduce.get());

		Integer reduce2 = getStream().stream().reduce(0, (x, y) -> x + y);
		System.out.println(reduce2);

		Optional<Integer> reduce3 = getStream().stream().reduce(Integer::sum);
		System.out.println(reduce3.get());

		Optional<Integer> reduce4 = getStream().stream().reduce(Integer::max);
		System.out.println(reduce4.get());

		Stream<Pessoa> pessoas = Pessoa.bancoDePessoas().stream();
		Optional<Double> reduce5 = pessoas.filter(p -> p.getSalario() > 40).map(Pessoa::getSalario).reduce(Double::sum);
		System.out.println(reduce5.get());

		pessoas = Pessoa.bancoDePessoas().stream();
		Double somaDouble = pessoas.filter(p -> p.getSalario() > 40).mapToDouble(Pessoa::getSalario).sum();
		System.out.println(somaDouble);

	}

	private static List<Integer> getStream() {
		return Arrays.asList(1, 2, 3, 4, 5, 6);
	}

}
