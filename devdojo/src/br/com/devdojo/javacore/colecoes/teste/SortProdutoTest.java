package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.devdojo.javacore.colecoes.classes.Produto;


class ProdutoNomeComparator implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
	
}

public class SortProdutoTest {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		Produto produto1 = new Produto("123", "IPhone 7", 3500);
		Produto produto2 = new Produto("321", "Picanha", 100);
		Produto produto3 = new Produto("879", "Teclado", 1000.0);
		Produto produto4 = new Produto("012", "Samsung Galaxy 7", 3500);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		Collections.sort(produtos);
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
		System.out.println("================================");
		
		Collections.sort(produtos, new ProdutoNomeComparator());
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
		System.out.println("================================");
		
		Produto[] produtosArray = new Produto[4];
		produtosArray[0] = new Produto("987", "Produto1", 799.99);
		produtosArray[1] = new Produto("765", "Produto2", 699.99);
		produtosArray[2] = new Produto("543", "Produto3", 599.99);
		produtosArray[3] = new Produto("321", "Produto4", 499.99);
		Arrays.sort(produtosArray);
//		System.out.println(Arrays.toString(produtosArray));
		for (Produto produto : produtosArray) {
			System.out.println(produto);
		}
	
		
	}
}
