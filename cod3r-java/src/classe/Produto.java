package classe;

public class Produto {
	
	String nome;
	double preco;
	static double desconto = 0.25;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
	
	}

	public double precoComDesconto() {
		return this.preco * (1 - Produto.desconto);
	}
	
	public double precoComDesconto(double descontoDoGerente) {
		return this.preco * (1 - Produto.desconto + descontoDoGerente);
	}
}
