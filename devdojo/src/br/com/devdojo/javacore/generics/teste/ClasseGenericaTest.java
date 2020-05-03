package br.com.devdojo.javacore.generics.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.devdojo.javacore.generics.Carro;
import br.com.devdojo.javacore.generics.Computador;

public class ClasseGenericaTest {
	public static void main(String[] args) {
		List<Carro> carrosDisponiveis = new ArrayList<>();
		carrosDisponiveis.add(new Carro("Gol"));
		carrosDisponiveis.add(new Carro("BMW"));

		ObjetoAlugavel<Carro> carroAlugavel = new ObjetoAlugavel<Carro>(carrosDisponiveis);
		Carro carro = carroAlugavel.alugarObjetoDisponivel();
		carroAlugavel.devolverObjeto(carro);

		System.out.println("============================");

		List<Computador> computadoresDisponiveis = new ArrayList<>();
		computadoresDisponiveis.add(new Computador("MAC"));
		computadoresDisponiveis.add(new Computador("Acer"));

		ObjetoAlugavel<Computador> computadorDisponivel = new ObjetoAlugavel<Computador>(computadoresDisponiveis);
		Computador computador = computadorDisponivel.alugarObjetoDisponivel();
		computadorDisponivel.devolverObjeto(computador);
	}

}

class ObjetoAlugavel<T> {
	private List<T> obejtosDisponiveis;

	public ObjetoAlugavel(List<T> obejtosDisponiveis) {
		this.obejtosDisponiveis = obejtosDisponiveis;
	}

	public T alugarObjetoDisponivel() {
		T t = obejtosDisponiveis.remove(0);
		System.out.println("Alugando o objeto: " + t);
		System.out.println("Objeto disponiveis: " + obejtosDisponiveis);
		return t;
	}

	public void devolverObjeto(T t) {
		System.out.println("Devolvendo o objeto: " + t);
		obejtosDisponiveis.add(t);
		System.out.println("Objetos disponiveis: " + obejtosDisponiveis);
	}
}
