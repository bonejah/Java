package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.devdojo.javacore.colecoes.classes.Produto;

public class BinarySearchTest {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(2);
		numeros.add(0);
		numeros.add(4);
		numeros.add(3);
		
		// A lista já precisa estar ordenada senão da erro
		Collections.sort(numeros);
		// Posicao 	-> 0 1 2 3
		// Valor	-> 0 2 3 4
		int posicao = Collections.binarySearch(numeros, 3);
		System.out.println("Indice encontrado em: " + posicao);
		System.out.println("Objeto recuperado: " + numeros.get(posicao));
		
		System.out.println("=================================");
		
		List<Produto> produtos = new ArrayList<>();
		Produto produto1 = new Produto("123", "IPhone 7", 3500);
		Produto produto2 = new Produto("321", "Picanha", 100);
		Produto produto3 = new Produto("879", "Teclado", 1000.0);
		Produto produto4 = new Produto("012", "Samsung Galaxy 7", 3500);
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		Collections.sort(produtos, new ProdutoNomeComparator());
		Produto produto5 = new Produto("000", "Antena", 100);
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
		System.out.println(Collections.binarySearch(produtos, produto5, new ProdutoNomeComparator()));
		Integer [] arrayInteger = new Integer[4];
		arrayInteger[0] = 2;
		arrayInteger[1] = 0;
		arrayInteger[2] = 4;
		arrayInteger[3] = 3;
		Arrays.sort(arrayInteger);
		System.out.println(Arrays.binarySearch(arrayInteger, 1));
		
	}
}
