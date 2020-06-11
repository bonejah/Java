package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	final String nome;
	final double preco;
	
	List<Item> itens = new ArrayList<Item>();

	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
}
