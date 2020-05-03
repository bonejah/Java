package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.devdojo.javacore.colecoes.classes.Consumidor;
import br.com.devdojo.javacore.colecoes.classes.Produto;

public class ConsumidorMapTest {
	
	public static void main(String[] args) {
		Consumidor consumidor = new Consumidor("Bruno", "12345678");
		Consumidor consumidor2 = new Consumidor("Leticia", "87654321");
		Produto produto1 = new Produto("123", "IPhone 7", 3500);
		Produto produto2 = new Produto("321", "Picanha", 100);
		Produto produto3 = new Produto("879", "Teclado", 1000.0);
		Produto produto4 = new Produto("012", "Samsung Galaxy 7", 3500);
		List<Produto> lsProduto1 = new ArrayList<>();
		lsProduto1.add(produto1);
		lsProduto1.add(produto2);
		List<Produto> lsProduto2 = new ArrayList<>();
		lsProduto2.add(produto3);
		lsProduto2.add(produto4);
		
		
		Map<Consumidor, List<Produto>> map = new HashMap<>();
		map.put(consumidor, lsProduto1);
		map.put(consumidor2, lsProduto2);
		for (Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
			System.out.println(entry.getKey().getNome());
			for (Produto produto : entry.getValue()) {
				System.out.println(produto);
			}
		}
		
	}

}
