package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.devdojo.javacore.colecoes.classes.Produto;

public class IteratorTest {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		Produto produto1 = new Produto("123", "IPhone 7", 3500, 10);
		Produto produto2 = new Produto("321", "Picanha", 100, 10);
		Produto produto3 = new Produto("879", "Teclado", 1000.0, 0);
		Produto produto4 = new Produto("012", "Samsung Galaxy 7", 3500, 0);
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);

		System.out.println(produtos.size());
//		for (Produto produto : produtos) {
//			if (produto.getQuantidade() == 0) {
//				produtos.remove(produto);
//			}
//		}
		System.out.println(produtos.size());
		System.out.println("=============");

		Iterator<Produto> produtoIterator = produtos.iterator();
		while (produtoIterator.hasNext()) {
			if (produtoIterator.next().getQuantidade() == 0) {
				produtoIterator.remove();
			}
		}
		System.out.println(produtos.size());
	}

}
