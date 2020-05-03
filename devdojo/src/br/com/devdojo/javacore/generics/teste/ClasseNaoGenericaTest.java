package br.com.devdojo.javacore.generics.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.devdojo.javacore.generics.Carro;
import br.com.devdojo.javacore.generics.Computador;

public class ClasseNaoGenericaTest {

	public static void main(String[] args) {
		CarroAlugavel carroAlugado = new CarroAlugavel();
		Carro carro = carroAlugado.alugaCarroDisponivel();
		System.out.println("Usando o carro por um mês");
		carroAlugado.devolverCarro(carro);
		
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		
		ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
		Computador computador = computadorAlugavel.alugaComputadorDisponivel();
		System.out.println("Usando o computador por um mês");
		computadorAlugavel.devolverComputador(computador);
	}
}

class CarroAlugavel {
	private List<Carro> carrosDisponiveis = new ArrayList<>();

	{
		carrosDisponiveis.add(new Carro("Gol"));
		carrosDisponiveis.add(new Carro("BMW"));
	}

	public Carro alugaCarroDisponivel() {
		Carro carro = carrosDisponiveis.remove(0);
		System.out.println("Alugando o carro: " + carro.getNome());
		System.out.println("Carros disponiveis: " + carrosDisponiveis);
		return carro;
	}

	public void devolverCarro(Carro carro) {
		System.out.println("Devolvendo o carro: " + carro.getNome());
		carrosDisponiveis.add(carro);
		System.out.println("Carros disponiveis: " + carrosDisponiveis);
	}
}

class ComputadorAlugavel {
	private List<Computador> computadorDisponiveis = new ArrayList<>();

	{
		computadorDisponiveis.add(new Computador("MAC"));
		computadorDisponiveis.add(new Computador("Chrome"));
	}

	public Computador alugaComputadorDisponivel() {
		Computador computador = computadorDisponiveis.remove(0);
		System.out.println("Alugando o computador: " + computador.getNome());
		System.out.println("Computador disponiveis: " + computadorDisponiveis);
		return computador;
	}

	public void devolverComputador(Computador computador) {
		System.out.println("Devolvendo o computador: " + computador.getNome());
		computadorDisponiveis.add(computador);
		System.out.println("Computador disponiveis: " + computadorDisponiveis);
	}
}