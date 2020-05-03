package br.com.devdojo.javacore.completablefuture.teste;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import br.com.devdojo.javacore.completablefuture.Loja;

public class LojaTest {
	
	public static void main(String[] args) {
		Loja americanas = new Loja();
		Loja mapping = new Loja();
		Loja zara = new Loja();
		Loja pernambucanas = new Loja();
		
//		Long start = System.currentTimeMillis();
//		System.out.println(americanas.getPreco());
//		System.out.println(mapping.getPreco());
//		System.out.println(zara.getPreco());
//		System.out.println(pernambucanas.getPreco());
//		System.out.println(System.currentTimeMillis() - start + " ms");
		
		Long start = System.currentTimeMillis();
		Future<Double> precoAsyn1 = americanas.getPrecoAsynTunado();
		Future<Double> precoAsyn2 = mapping.getPrecoAsynTunado();
		Future<Double> precoAsyn3 = zara.getPrecoAsynTunado();
		Future<Double> precoAsyn4 = pernambucanas.getPrecoAsynTunado();
		Long end = System.currentTimeMillis();
		System.out.println("Tempo de invocação: " + (end - start) + " ms");
		
		enrolando();
		
		try {
			System.out.println(precoAsyn1.get());
			System.out.println(precoAsyn2.get());
			System.out.println(precoAsyn3.get());
			System.out.println(precoAsyn4.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Tempo que levou para pegar o resultado final: " + (System.currentTimeMillis() - start) + " ms");
	}
	
	public static void enrolando() {
		long soma = 0;
		for (int i = 0; i < 1000000; i++) {
			soma += i;
		}
//		System.out.println(soma);
	}


}
