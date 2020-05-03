package br.com.devdojo.javacore.completablefuture.teste;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import br.com.devdojo.javacore.completablefuture.Loja;

public class LojaTest2 {

	public static void main(String[] args) {
		List<Loja> lojas = Arrays.asList(new Loja("americanas"), new Loja("casasBahia"), new Loja("bestBay"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"), new Loja("walmart"),
				new Loja("walmart"));

		System.out.println("Total de lojas: " + lojas.size());
		
//		acharPrecos(lojas);
		acharPrecos2(lojas);
//		acharPrecos3(lojas);
//		acharPrecos4(lojas);

		System.out.println();

		// NumeroThreads = Ncpu * Ucpu * (1+W/C)
		// Ncpu = numero de cores disponiveis
		System.out.println("Total de processadores: " + Runtime.getRuntime().availableProcessors());
		// Ucpu = quantidade de utilizacao da CPU (0-1)
		// W/C = wait time e compute time

		final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		});

		acharPrecos4(lojas, executor);

	}

	private static List<String> acharPrecos(List<Loja> lojas) {
		System.out.println("Stream Sequencial");
		long start = System.currentTimeMillis();

		List<String> listLojas = lojas.stream()
				.map(loja -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(listLojas);
		return listLojas;
	}

	private static List<String> acharPrecos2(List<Loja> lojas) {
		System.out.println("Stream Paralelo");
		long start = System.currentTimeMillis();

		List<String> listLojas = lojas.stream().parallel()
				.map(loja -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(listLojas);
		return listLojas;
	}

	private static List<String> acharPrecos3(List<Loja> lojas) {
		System.out.println("Completable Future Sequencial");
		long start = System.currentTimeMillis();

		List<String> listLojas = lojas.stream()
				.map(loja -> CompletableFuture
						.supplyAsync(() -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco())))
				.map(CompletableFuture::join).collect(Collectors.toList());

		System.out.println("Tempo de invocacao: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(listLojas);
		return listLojas;
	}

	private static List<String> acharPrecos4(List<Loja> lojas) {
		System.out.println("Completable Future");
		long start = System.currentTimeMillis();

		List<CompletableFuture<String>> precoFuturo = lojas.stream()
				.map(loja -> CompletableFuture
						.supplyAsync(() -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco())))
				.collect(Collectors.toList());

		List<String> listLojas = precoFuturo.stream().map(CompletableFuture::join).collect(Collectors.toList());

		System.out.println("Tempo de invocacao: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(listLojas);
		return listLojas;
	}

	private static List<String> acharPrecos4(List<Loja> lojas, Executor executor) {
		System.out.println("Completable Future");
		long start = System.currentTimeMillis();

		List<CompletableFuture<String>> precoFuturo = lojas.stream()
				.map(loja -> CompletableFuture.supplyAsync(
						() -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco()), executor))
				.collect(Collectors.toList());

		List<String> listLojas = precoFuturo.stream().map(CompletableFuture::join).collect(Collectors.toList());

		System.out.println("Tempo de invocacao: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(listLojas);
		return listLojas;
	}

}
