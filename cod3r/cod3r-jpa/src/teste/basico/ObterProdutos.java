package teste.basico;

import java.util.List;

import infra.ProdutoDAO;
import umpramuitos.Produto;

public class ObterProdutos {
	
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.obterTodos();
		
		produtos.stream().forEach(p -> System.out.println("Produto => " + p.getNome()));
		
		double precoTotalProdutos = produtos.stream()
			.map(p -> p.getPreco())
			.reduce(0.0, (t, p) -> t + p)
			.doubleValue();
		
		System.out.println("O valor total dos produtos é: " + precoTotalProdutos);
		
		dao.fechar();
	}

}
