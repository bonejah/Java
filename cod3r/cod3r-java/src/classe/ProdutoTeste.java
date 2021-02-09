 package classe;

public class ProdutoTeste {

	public static void main(String[] args) {
		Produto produto = new Produto("MacBook Air", 10000.00);
		double precoFinal1 = produto.precoComDesconto(); 
		
		var produto2 = new Produto();
		produto2.nome = "Apple Watch";
		produto2.preco = 1000.00;
		Produto.desconto = 0.25;
		double precoFinal2 = produto2.precoComDesconto(0.1); 
		
		System.out.println("Produto 1:" + produto.nome);
		System.out.println("Preco: " + produto.preco);
		System.out.println("Preco Final: " + precoFinal1);
		
		System.out.println("===========================");
		
		System.out.println("Produto 2:" + produto2.nome);
		System.out.println("Preco: " + produto2.preco);
		System.out.println("PrecoFinal: " + precoFinal2);
		
	}
}
