package br.com.devdojo.javacore.colecoes.teste;

import java.util.NavigableSet;
import java.util.TreeSet;

import br.com.devdojo.javacore.colecoes.classes.Celular;
import br.com.devdojo.javacore.colecoes.classes.Produto;

public class TreeSetTest {

	public static void main(String[] args) {
		Produto produto1 = new Produto("123", "IPhone 7", 3500);
		Produto produto2 = new Produto("321", "Picanha", 100);
		Produto produto3 = new Produto("879", "Teclado", 1000.0);
		Produto produto4 = new Produto("012", "Samsung Galaxy 7", 5500);
		Celular celular = new Celular("IPhone 7", "12112");
		
		NavigableSet<Produto> pNavigableSet = new TreeSet<>();
		pNavigableSet.add(produto1);
		pNavigableSet.add(produto2); 
		pNavigableSet.add(produto3);
		pNavigableSet.add(produto4);
		for (Produto produto : pNavigableSet) {
			System.out.println(produto);
		}
		
		for (Produto produto : pNavigableSet.descendingSet()) {
			System.out.println(produto);
		}
		
		System.out.println("===============");
		// lower <
		// floor <=
		// higher > 
		// celling >=
		System.out.println(pNavigableSet.lower(produto4));
		System.out.println(pNavigableSet.floor(produto4));
		System.out.println(pNavigableSet.higher(produto4));
		System.out.println(pNavigableSet.ceiling(produto4));
		
		
		
		
//		NavigableSet<Celular> cNavigableSet = new TreeSet<>(new CelularComparatorNome());
//		cNavigableSet.add(celular);
//		for (Celular celular2 : cNavigableSet) {
//			System.out.println(celular2);
//		}
		
	}
}
