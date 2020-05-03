package br.com.devdojo.javacore.metodos.teste;

import br.com.devdojo.javacore.metodos.Calculadora;

public class CalculadoraTeste {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		calculadora.somDoisNumeros();
		calculadora.subtraiDoisNumeros();
		calculadora.multiplicaDoisNumeros(5.2, 7);

		double divideDoisNumeros = calculadora.divideDoisNumeros(10, 2);
		System.out.println(divideDoisNumeros);

		calculadora.imprimeDoisNumerosDivididos(5, 0);

		int[] numeros = { 1, 2, 3, 4, 5 };
		calculadora.somaArray(numeros);
		calculadora.somaVarArgs(10, 20, 30);
	}

}
