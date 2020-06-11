package oo.composicao;

import java.util.ArrayList;

public class Compra {

	String cliente;
	ArrayList<Item> itens = new ArrayList<Item>();
	
	public double obterValorTotal() {
		double total = 0;
		
		for (Item item : itens) {
			total += item.preco * item.quantidade;
		}
		
		return total;
	}
	
	void adicionarItem(String nome, int quantidadem, double preco) {
		this.adicionarItem(new Item(nome, quantidadem, preco));
	}
	
	void adicionarItem(Item item) {
		this.itens.add(item);
		item.compra = this;
	}
	
}
