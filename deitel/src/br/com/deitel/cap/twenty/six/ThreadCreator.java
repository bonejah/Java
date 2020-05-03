package br.com.deitel.cap.twenty.six;

public class ThreadCreator {
	public static void main(String[] args) {
		System.out.println("Creating threads");
		
		// cria cada Thread com um novo Runnable selecionado
		Thread thread1 = new Thread(new PrintTask("task1"));
		Thread thread2 = new Thread(new PrintTask("task2"));
		Thread thread3 = new Thread(new PrintTask("task3"));
		
		System.out.println("Threads created, starting tasks.");
		
		// inicia threads e coloca no estado executavel
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
