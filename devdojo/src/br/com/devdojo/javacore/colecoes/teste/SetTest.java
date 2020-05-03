package br.com.devdojo.javacore.colecoes.teste;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.devdojo.javacore.colecoes.classes.Produto;

public class SetTest {

	public static void main(String[] args) {
		Produto produto1 = new Produto("123", "IPhone 7", 3500, 10);
		Produto produto2 = new Produto("321", "Picanha", 100, 10);
		Produto produto3 = new Produto("879", "Teclado", 1000.0, 0);
		Produto produto4 = new Produto("012", "Samsung Galaxy 7", 3500, 0);
//		Produto produto5 = new Produto("012", "Samsung Galaxy 7", 3500, 0);
		
//		Set<Produto> produtosSet = new HashSet<>(); // Nao mantem a ordem de insercao
		Set<Produto> produtosSet = new LinkedHashSet<>(); // Mantem a ordem de insercao
		produtosSet.add(produto1);
		produtosSet.add(produto2);
		produtosSet.add(produto3);
		produtosSet.add(produto4);
//		produtosSet.add(produto5);
		for (Produto produto : produtosSet) {
			System.out.println(produto);
		}
		
	}
}
