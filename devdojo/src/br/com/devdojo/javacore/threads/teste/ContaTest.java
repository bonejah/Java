package br.com.devdojo.javacore.threads.teste;

import br.com.devdojo.javacore.threads.Conta;

public class ContaTest implements Runnable {
	private Conta conta = new Conta();

	public static void main(String[] args) {
		ContaTest contaTest = new ContaTest();
		Thread bruno = new Thread(contaTest, "Bruno");
		Thread leticia = new Thread(contaTest, "Leticia");

		leticia.start();
		bruno.start();
	}

	private synchronized void saque(int valor) {
//		synchronized (conta) {
			if (conta.getSaldo() >= valor) {
				System.out.println(Thread.currentThread().getName() + " está indo sacar");
				conta.saque(valor);
				System.out.println(Thread.currentThread().getName() + " completou o saque, saldo: " + conta.getSaldo());
			} else {
				System.out.println("Sem dinheiro para a " + Thread.currentThread().getName() + " efeturar o saque, saldo: "
						+ conta.getSaldo());
			}
//		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			saque(10);
			if (conta.getSaldo() < 0) {
				System.out.println("Oh meu Deus!");
			}

		}

	}
}
