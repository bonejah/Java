package br.com.devdojo.javacore.colecoes.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversaoArrayListTest {

	public static void main(String[] args) {
		// Transformando List em Array
		List<Integer> numeros = new ArrayList<>();
		numeros.add(10);
		numeros.add(3);
		numeros.add(2);
		numeros.add(7);
		
		Integer[] numerosArray = new Integer[numeros.size()];
		numeros.toArray(numerosArray);
		System.out.println(numeros);
		System.out.println(Arrays.toString(numerosArray));
		
		System.out.println("===========================");
		// Transformando Array me List
		
		Integer[] numerosArray2 = new Integer[4];
		numerosArray2[0] = 10;
		numerosArray2[1] = 9;
		numerosArray2[2] = 8;
		numerosArray2[3] = 7;
		
		List<Integer> numeros2 = Arrays.asList(numerosArray2);
		
		List<Integer> numeros3 = new ArrayList<>();
		numeros3.addAll(Arrays.asList(numerosArray2));
		numeros2.set(0, 1);
		numeros3.add(10);
		
		System.out.println(Arrays.toString(numerosArray2));
		System.out.println(numeros2);
		System.out.println(numeros3);
	}
}
