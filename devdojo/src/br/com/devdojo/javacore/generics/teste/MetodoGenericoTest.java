package br.com.devdojo.javacore.generics.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.devdojo.javacore.generics.Computador;

public class MetodoGenericoTest {
	
	public static void main(String[] args) {
		criarArray(new Cachorro());
		criarArray(new Gato());
		
		List<Computador> lsComputador = criarArray2(new Computador("MAC"));
		for (Computador computador : lsComputador) {
			System.out.println(computador);
		}
	}
	
	public static <T> void criarArray(T t) {
		List<T> lista = new ArrayList<>();
		lista.add(t);
		System.out.println(lista);
	}
	
	public static <T> List<T> criarArray2(T t) {
		List<T> lista = new ArrayList<>();
		lista.add(t);
		return lista;
	}

}
