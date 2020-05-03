package br.com.deitel.cap.twenty.six;

import java.util.Random;

public class PrintTask implements Runnable {
	private final int sleepTime; // tempo de adormecimento aleatorio para a
									// Thread
	private final String taskName; // nome da tarefa
	private final static Random generator = new Random();

	public PrintTask(String name) {
		taskName = name; // configura o nome da tarefa
		// seleciona o tempo de adormecimento aleatorio entre 0 e 5 segundos
		sleepTime = generator.nextInt(5000);
	}

	@Override
	public void run() {
		try {
			System.out.printf("%s going to sleep for %d miliseconds.\n", taskName, sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException interruptedException) {
			System.out.printf("%s %s\n", taskName, "terminated prematurely due to interruption");
		}

		// Imprime o nome da tarefa
		System.out.printf("%s done sleeping\n", taskName);
	}
}
