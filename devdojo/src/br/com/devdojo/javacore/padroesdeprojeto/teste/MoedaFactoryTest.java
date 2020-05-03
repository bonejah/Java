package br.com.devdojo.javacore.padroesdeprojeto.teste;

import br.com.devdojo.javacore.padroesdeprojeto.classe.Moeda;
import br.com.devdojo.javacore.padroesdeprojeto.classe.MoedaFactory;
import br.com.devdojo.javacore.padroesdeprojeto.classe.Pais;

public class MoedaFactoryTest {
	
	public static void main(String[] args) {
		Moeda real = MoedaFactory.criarMoeda(Pais.BRASIL);
		System.out.println(real.getSimbolo());
		Moeda dolar = MoedaFactory.criarMoeda(Pais.EUA);
		System.out.println(dolar.getSimbolo());
	}

}
