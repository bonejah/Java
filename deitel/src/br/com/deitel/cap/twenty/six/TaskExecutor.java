package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
	public static void main(String[] args) {
		// cria e nomeia cada executavel
		PrintTask task1 = new PrintTask("task1");
		PrintTask task2 = new PrintTask("task2");
		PrintTask task3 = new PrintTask("task3");

		System.out.println("Starting Executor");

		// cria ExecutorService para gerenciar Threads
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(task1);
		threadExecutor.execute(task2);
		threadExecutor.execute(task3);

		// encerra threads trabalhadoras quando suas tarefas terminarem
		threadExecutor.shutdown();

		System.out.println("Tasks started, main ends.\n");
	}
}
