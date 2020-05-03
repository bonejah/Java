package br.com.devdojo.javacore.streams.teste;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import br.com.devdojo.javacore.streams.Pessoa;

public class StreamTest6 {

	// Reducao e sumarizacao de streams em um valor unico
	// Agrupamento de elementos
	// Particionamento de elementos
	
	public static void main(String[] args) {
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		System.out.println(pessoas.stream().count());
		
		Long total = pessoas.stream().collect(Collectors.counting());
		System.out.println(total);
		
		/////////////////////////////////////////////////////////////
		
		Optional<Pessoa> max = pessoas.stream().max(Comparator.comparing(Pessoa::getSalario));
		System.out.println(max.get());
		
		Optional<Pessoa> max2 = pessoas.stream().collect(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)));
		System.out.println(max2.get());
		
		Optional<Pessoa> max3 = pessoas.stream().collect(Collectors.minBy(Comparator.comparing(Pessoa::getSalario)));
		System.out.println(max3.get());
		
		/////////////////////////////////////////////////////////////
		
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());
		Double totalsalario = pessoas.stream().collect(Collectors.summingDouble(Pessoa::getSalario));
		System.out.println(totalsalario);
		
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).average());
		Double totalsalario2 = pessoas.stream().collect(Collectors.averagingDouble(Pessoa::getSalario));
		System.out.println(totalsalario2);
		
		/////////////////////////////////////////////////////////////
		
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", ")));
	}
}
