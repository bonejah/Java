package br.com.devdojo.javacore.classesinternars.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.devdojo.javacore.generics.Carro;

class Animal {
	public void andar() {
		System.out.println("Andando");
	}
}

public class ClassesAnonimasTest {
	
	public static void main(String[] args) {
		Animal animal = new Animal() {
			public void andar() {
				System.out.println("Andando anonimamente...");
			}
		};
		animal.andar();
		
		List<Carro> lsCarro = new ArrayList<>();
		lsCarro.add(new Carro("GOL"));
		lsCarro.add(new Carro("BWM"));
		lsCarro.add(new Carro("Audi"));
		
//		Collections.sort(lsCarro, new Comparator<Carro>() {
//			public int compare(Carro o1, Carro o2) {
//				return o1.getNome().compareTo(o2.getNome());
//			}
//		});
		
		// Java 1.8 - Lambda
		Collections.sort(lsCarro, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		
		for (Carro carro : lsCarro) {
			System.out.println(carro);
		}
	}

}
