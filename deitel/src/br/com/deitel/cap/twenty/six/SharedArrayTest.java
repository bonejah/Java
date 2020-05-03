package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
	public static void main(String[] args) {
		// constroi o objeto compartilhado
		SimpleArray simpleArray = new SimpleArray(6);

		// cria duas tarefas a serem gravadas no SimpleArray compartilhado
		ArrayWriter writer1 = new ArrayWriter(1, simpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, simpleArray);

		// executa as tarefas com um ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);

		executorService.shutdown();

		try {
			// espera 1 minuto por ambos os gravadores terminarem a execucao
			boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

			if (tasksEnded)
				System.out.println(simpleArray);
			else
				System.out.println("Timed out while waiting for tasks to finish.");
		} catch (InterruptedException interruptedException) {
			System.out.println("Interrupted while waiting for tasks to finish.");
		}

	}
}
