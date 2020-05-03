package br.com.devdojo.javacore.threads;

public class Conta {
	private int saldo = 50;

	public int getSaldo() {
		return saldo;
	}

	public void saque(int valor) {
		saldo = saldo - valor;
	}
}
