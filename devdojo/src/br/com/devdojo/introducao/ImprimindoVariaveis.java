package br.com.devdojo.introducao;

public class ImprimindoVariaveis {
	// Voce pode escrever comentários assim

	/*
	 * Comentários tbem podem ser escritos assim
	 * 
	 */

	/**
	 * Comentário para métodos
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int idade = 10;
		double salarioDouble = 3000;
		float salarioFloat = 3000;
		byte idadeByte = 12;
		short idadeShort = 32767;
		boolean verdadeiro = true;
		boolean falso = false;
		long numeroGrande = 1000L;
		char caractere = '\u0041';
		String nome = "Bruno";

		System.out.println("Dados impressos");
		System.out.println("A idade é: " + idade);
		System.out.println("salarioDouble: " + salarioDouble);
		System.out.println("salarioFloat: " + salarioFloat);
		System.out.println("idadeByte: " + idadeByte);
		System.out.println("idadeShort: " + idadeShort);
		System.out.println("verdadeiro: " + verdadeiro);
		System.out.println("falso: " + falso);
		System.out.println("numeroGrande: " + numeroGrande);
		System.out.println("caractere: " + caractere);
		System.out.println("nome: " + nome);
	}

}
