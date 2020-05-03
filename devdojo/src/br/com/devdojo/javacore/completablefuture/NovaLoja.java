package br.com.devdojo.javacore.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class NovaLoja {
	private String nome;

	public NovaLoja() {
	}

	public NovaLoja(String nome) {
		super();
		this.nome = nome;
	}

	public String getPreco() {
		double preco = calcularPreco();
		System.out.println("Preco: " + preco);
		Desconto.Codigo codigo = Desconto.Codigo.values()[ThreadLocalRandom.current()
				.nextInt(Desconto.Codigo.values().length)];

		return String.format("%s:%.2f:%s", nome, preco, codigo);

	}

	private double calcularPreco() {
		delay();
//		System.out.println(1 / 0);
		return ThreadLocalRandom.current().nextDouble() * 100;
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Loja [nome=" + nome + "]";
	}

	public static List<NovaLoja> lojas() {
		List<NovaLoja> lojas = Arrays.asList(new NovaLoja("americanas"), new NovaLoja("casasBahia"),
				new NovaLoja("bestBay"));
		return lojas;
	}
}
