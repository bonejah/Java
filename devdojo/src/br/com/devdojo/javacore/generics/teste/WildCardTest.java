package br.com.devdojo.javacore.generics.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal {
	public abstract void consulta();
}

class Cachorro extends Animal {
	@Override
	public void consulta() {
		System.out.println("Consultando o cachorro....");
	}
}

class Gato extends Animal {
	@Override
	public void consulta() {
		System.out.println("Consultando o gato....");
	}
}

public class WildCardTest {

	public static void main(String[] args) {
		Cachorro[] cachorros = { new Cachorro(), new Cachorro() };
		Gato[] gatos = { new Gato(), new Gato() };
		consultaAnimais(cachorros);
		consultaAnimais(gatos);
		
		System.out.println("************************************");
		
		List<Cachorro> lsCachorro = new ArrayList<>();
		List<Gato> lsGato = new ArrayList<>();
		lsCachorro.add(new Cachorro());
		lsGato.add(new Gato());
//		consultaAnimaisList(lsCachorro); // DA ERRO
//		consultaAnimaisList(lsCachorro); // DA ERRO
		List<Animal> lsAnimal = new ArrayList<>();
		lsAnimal.add(new Cachorro());
		lsAnimal.add(new Gato());
		consultaAnimaisList(lsAnimal);
		
//		ordenaLista(lsCachorro); // Erro de compilaçao

	}

	public static void consultaAnimais(Animal[] animals) {
		for (Animal animal : animals) {
			animal.consulta();
		}
	}
	

	public static void consultaAnimaisList(List<? extends Animal> animals) {
		for (Animal animal : animals) {
			animal.consulta();
		}
//		animals.add(new Cachorro()); // Da erro
	}
	
	public static void consultaCachorroList(List<? super Cachorro> cachorroList) {
		Cachorro cachorro = new Cachorro();
		Animal animal = new Cachorro();
		Object obj = new Cachorro();
		
		cachorroList.add(new Cachorro());
		cachorroList.add(cachorro);
		cachorroList.add((Cachorro) animal);
		cachorroList.add((Cachorro) obj);
	}
	
	public static void ordenaLista(List<? extends Comparable> lista) {
		Collections.sort(lista);
	}
	
	

}
