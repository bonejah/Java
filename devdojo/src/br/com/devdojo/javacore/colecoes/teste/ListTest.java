package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<String>();
		List<String> nomes2 = new ArrayList<String>();
		nomes.add("Bruno");
		nomes.add("Leticia");
		nomes2.add("Bianca");
		nomes2.add("Matheus");
		System.out.println("Size: " + nomes.size());

//		nomes.forEach(System.out::println); // Java 1.8
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("======================");
		
		nomes.addAll(nomes2);
		nomes.remove(0);
		System.out.println("Size: " + nomes.size());
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("======================");
		
		nomes.removeAll(nomes2);
		System.out.println("Size: " + nomes.size());
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		
	}
}
