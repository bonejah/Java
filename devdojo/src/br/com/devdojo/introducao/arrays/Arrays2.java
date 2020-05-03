package br.com.devdojo.introducao.arrays;

public class Arrays2 {

	public static void main(String[] args) {
		// byte, short, int, long, float, double => 0
		// char => '\u0000'
		// boolean => false
		// reference => null
		String [] nomes = new String[4];
		nomes[0] = "Naruto";
		nomes[1] = "Sasuke";
		nomes[2] = "Luffy";
		nomes[3] = "Kurosaki";
		
		System.out.println("Size array: " + nomes.length);
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
		
		System.out.println();
		System.out.println("===========================");
		
		nomes = new String[4];
		System.out.println("Size array: " + nomes.length);
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
	}
}
