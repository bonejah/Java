package br.com.devdojo.introducao.operadores;

public class Operadores {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 21;
		
		System.out.println("Num1 = " + num1);
		System.out.println("Num2 = " + num2);
		System.out.println("A soma e: " + (num1 + num2));
		System.out.println("A subtração e: " + (num1 - num2));
		System.out.println("A multiplicação e: " + (num1 * num2));
		System.out.println("A divisão e: " + (num1 / num2));
		System.out.println("A soma " + (num1 + num2) + " é : " + (((num1 + num2)%2) == 0 ? "Par" : "Impar"));
	}

}
