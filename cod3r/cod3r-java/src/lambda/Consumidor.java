package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

	public static void main(String[] args) {
		
		Consumer<Produto> imprimir = p -> 
			System.out.printf("Nome produto: %s, preco: %.2f, desconto: %.2f\n" , p.nome, p.preco, p.desconto);
		
		Produto caneta = new Produto("Caneta Azul", 7.0, 0);
		Produto chaveiro = new Produto("Chaveiro", 10.0, 0);
		Produto lapis = new Produto("Lapis", 3.0, 0);
		Produto borracha = new Produto("Borraca", 3.0, 0);
		
		imprimir.accept(caneta);
		System.out.println();
		
		List<Produto> produtos = Arrays.asList(caneta, chaveiro, lapis, borracha);
		produtos.forEach(imprimir);
		System.out.println();
		
		produtos.forEach(System.out::println);
		
		
	}
}
