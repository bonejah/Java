package br.com.devdojo.javacore.interfaces.teste;

import br.com.devdojo.javacore.interfaces.Produto;

public class ProdutoTeste {
	
	public static void main(String[] args) {
		Produto produto = new Produto("XBOX 4", 1, 1500);
		produto.calculaImposto();
		produto.calculaFrete();
		System.out.println(produto);
	}

}
