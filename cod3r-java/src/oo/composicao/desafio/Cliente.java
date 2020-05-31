package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	final String nome;
	final List<Compra> compras = new ArrayList<Compra>();

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	double obterValorTotal() {
		double total = 0;
		
		for (Compra compra : compras) {
			total += compra.obterValorTotal();
		}
		
		return total;
	}

	public void adicionarCompra(Compra compra) {
		this.compras.add(compra);
	}

}
