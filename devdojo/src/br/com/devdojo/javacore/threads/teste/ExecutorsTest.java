package br.com.devdojo.javacore.threads.teste;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadTrabalhadoraExecutor implements Runnable {
	private String num;
	
	public ThreadTrabalhadoraExecutor(String num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " iniciou: " + num);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " finalizou: " + num);
	}	
	
}

public class ExecutorsTest {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
//		ExecutorService es = Executors.newFixedThreadPool(4);
//		ExecutorService es = Executors.newCachedThreadPool();
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(new ThreadTrabalhadoraExecutor("1"));
		es.execute(new ThreadTrabalhadoraExecutor("2"));
		es.execute(new ThreadTrabalhadoraExecutor("3"));
		es.execute(new ThreadTrabalhadoraExecutor("4"));
		es.execute(new ThreadTrabalhadoraExecutor("5"));
		es.shutdown();
		
		while(!es.isTerminated()) {}
		System.out.println(es.isTerminated());
		System.out.println("Finalizado");
		
		
	}
	

}
