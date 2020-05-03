package br.com.devdojo.javacore.completablefuture.teste;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devdojo.javacore.completablefuture.Desconto;
import br.com.devdojo.javacore.completablefuture.NovaLoja;
import br.com.devdojo.javacore.completablefuture.Orcamento;

public class NovaLojaTest {

	public static void main(String[] args) {
		List<NovaLoja> lojas = NovaLoja.lojas();
//		lojas.stream().forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
		acharPrecos2(lojas); 
	}
	
	private static List<String> acharPrecos2(List<NovaLoja> lojas) {
		System.out.println("Stream Paralelo");
		long start = System.currentTimeMillis();
		
		List<String> collect = lojas.stream()
			.map(NovaLoja::getPreco)
			.map(Orcamento::parse)
			.map(Desconto::calcularDesconto)
			.collect(Collectors.toList());
		
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
	
		return collect;
	}
}
