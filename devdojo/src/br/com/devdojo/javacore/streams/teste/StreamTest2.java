package br.com.devdojo.javacore.streams.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		List<List<String>> nomes = new ArrayList<>();
		nomes.add(Arrays.asList("DevDojo", "Valeu por aumentar a letra"));
		nomes.add(Arrays.asList("William", "pq vc demorou 180 aulas pra isso?>"));
		System.out.println(nomes);

		Stream<String> stringStream = nomes.stream().flatMap(Collection::stream);
		stringStream.forEach(System.out::println);

		List<String> palavras = Arrays.asList("Ola", "Goku");
		List<String> collect2 = palavras.stream().map(p -> p.split("")).flatMap(Arrays::stream)
				.collect(Collectors.toList());

		System.out.println(collect2);

	}
}
