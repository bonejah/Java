package br.com.devdojo.javacore.string.teste;

public class StringTest {

	public static void main(String[] args) {
		String nome = "Matheus";
		String sobreNome = new String("Lima");
		System.out.println(nome + " " + sobreNome);
		
		String nome2 = "Bianca";
		nome2 = nome2.concat(" Lima");
		System.out.println(nome2);
		
		String teste = "Goku";
		String teste2 = "goku";
		String teste3 = "    0123456789";
		System.out.println(teste.charAt(3));
		System.out.println(teste.equals(teste2));
		System.out.println(teste.equalsIgnoreCase(teste2));
		System.out.println(teste.length());
		System.out.println(teste.replace('o', 'a'));
		System.out.println(teste.toLowerCase());
		System.out.println(teste.toUpperCase());
		System.out.println(teste3.substring(0, 2));
		System.out.println(teste3.trim());
		
	}
}
