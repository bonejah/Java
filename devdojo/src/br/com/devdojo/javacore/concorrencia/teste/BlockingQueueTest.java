package br.com.devdojo.javacore.concorrencia.teste;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		Thread t1 = new Thread(new RemoveQueue(bq));
		System.out.println("Elementos da lista inicial: " + bq.toString());
		
		bq.put("Bruno");
		System.out.println(bq.peek());
		System.out.println("Tentando colocar outro valor...");
		t1.start();
		
		bq.put("Leticia");
		System.out.println("Inserindo outro valor...");
		System.out.println("Elementos da lista final: " + bq.toString());
	}

	static class RemoveQueue implements Runnable {
		private BlockingQueue<String> bq;

		public RemoveQueue(BlockingQueue<String> bq) {
			this.bq = bq;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " entrando em espera por 2 segundos.");

			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Removendo o valor: " + bq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
