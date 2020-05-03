package br.com.devdojo.javacore.streams.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devdojo.javacore.streams.Pessoa;

public class StreamTest {

	public static void main(String[] args) {
		// Pegar os 3 primeiros nomes com menos de 25 anos ordenados pelo nome
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		System.out.println(pessoas);

		Collections.sort(pessoas, (p1, p2) -> p1.getNome().compareTo(p2.getNome()));
		System.out.println(pessoas);
		List<String> nomes = new ArrayList<>();

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() < 25) {
				nomes.add(pessoa.getNome());
				if (nomes.size() >= 3)
					break;
			}
		}
		System.out.println(nomes);

		List<String> nomesStream = pessoas.stream().filter(p -> p.getIdade() < 25)
				.sorted(Comparator.comparing(Pessoa::getNome)).limit(3).map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(nomesStream);

		long totalPessoas = pessoas.stream().filter(p -> p.getIdade() < 25).distinct().map(Pessoa::getNome).count();
		System.out.println(totalPessoas);

		pessoas.stream().forEach(System.out::println);

	}

}
