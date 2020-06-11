package lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		
		Produto produto = new Produto("iPad", 3235.89, 0.13);
		
		/**
		 * 1. A partir do produto calcular o preco real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8.5%) / < 2500 (isento)
		 * 3. Frete: >= 3000 (adiciona R$100) / < 3000 (adiciona R$50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$1234,56
		 */
		
		Function<Produto, Double> precoFinal;
		UnaryOperator<Double> impostoMunicipal;
		UnaryOperator<Double> frete;
		UnaryOperator<Double> arredondar;
		Function<Double, String> formatar;
		
		precoFinal = p -> p.preco * (1 - p.desconto);
		impostoMunicipal = preco -> preco >= 2500.00 ? preco * 1.085 : preco;
		frete = preco -> preco > 3000 ? preco + 100.00 : preco + 50.00;
		arredondar = preco -> Double.parseDouble(String.format("%.2f", preco));
		formatar = preco -> "R$" + preco;
		
		String resultado = precoFinal
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(produto);
		
		System.out.println(resultado);
	}
	
}
