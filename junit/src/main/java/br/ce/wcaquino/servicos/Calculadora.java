package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroExecption;

public class Calculadora {

	public int soma(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) throws NaoPodeDividirPorZeroExecption {
		if (b == 0) {
			throw new NaoPodeDividirPorZeroExecption("Nao pode dividir por zero");
		}
		return a / b;
	}

}
