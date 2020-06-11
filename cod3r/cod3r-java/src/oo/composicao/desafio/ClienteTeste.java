package oo.composicao.desafio;

public class ClienteTeste {
	
	public static void main(String[] args1) {
		Cliente c1 = new Cliente("Bruno");
		
		Compra compra1 = new Compra();
		compra1.adicionarItem("Caneta", 9.67, 100);
		compra1.adicionarItem(new Produto("Notebook", 1000.00), 2);
		
		Compra compra2 = new Compra();
		compra2.adicionarItem("Caderno", 20.00, 5);
		compra2.adicionarItem(new Produto("Impressora", 400.00), 2);
		
		
		c1.adicionarCompra(compra1); 
		c1.adicionarCompra(compra2); 
		
		System.out.println(c1.obterValorTotal());
		
		
	}

}
  