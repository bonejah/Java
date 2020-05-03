package br.com.devdojo.javacore.colecoes.teste;

import br.com.devdojo.javacore.colecoes.classes.Celular;

public class EqualsTest {

	public static void main(String[] args) {
//		String nome1 = "Bruno";
//		String nome2 = "Bruno";
//		System.out.println(nome1 == nome2);
//		
//		String nome3 = "Leticia";
//		String nome4 = new String("Leticia");
//		System.out.println(nome3 == nome4);
//		
//		Integer int1 = 5;
//		Integer int2 = new Integer(5);
//		System.out.println(int1 == int2);
//		System.out.println(int1.equals(int2));
		
		Celular c1 = new Celular("IPhone7", "1234");
		Celular c2 = new Celular("IPhone7", "1234");
		System.out.println(c1.equals(c2));
	}
}
