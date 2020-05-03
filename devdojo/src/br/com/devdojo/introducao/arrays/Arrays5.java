package br.com.devdojo.introducao.arrays;

public class Arrays5 {

	public static void main(String[] args) {
		int[][] numeros = new int[2][2];
		numeros[0][0] = 30;
		numeros[0][1] = 60;
		numeros[1][0] = 40;
		numeros[1][1] = 80;
		
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				System.out.println(numeros[i][j]);	
			}
		}
		
		System.out.println("======================");
		
		for (int[] ref : numeros) {
			for (int i : ref) {
				System.out.println(i);
			}
		}
		
	}
}
