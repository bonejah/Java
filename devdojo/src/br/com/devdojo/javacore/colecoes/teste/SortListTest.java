package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		nomes.add("Bruno");
		nomes.add("Matheus");
		nomes.add("Leticia");
		nomes.add("Bianca");
		
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("================");
		nomes.add(0, "Jaspion");
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("================");
		Collections.sort(nomes);
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("================");
		List<Double> numeros = new ArrayList<>();
		numeros.add(1.5);
		numeros.add(1.3);
		numeros.add(1.9);
		numeros.add(2d);
		
		Collections.sort(numeros);
		for (Double numero : numeros) {
			System.out.println(numero);
		}
	}
}
