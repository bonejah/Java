package br.com.devdojo.javacore.concorrencia.teste;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class CallableTest implements Callable<String> {

	@Override
	public String call() throws Exception {
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		
		for (int i = 0; i < count; i++) {
			System.out.println(Thread.currentThread().getName() + " executando...");
		}
		
		return "Trabalho finalizado, o numero aleatorio é: " + count;
	}
	
	public static void main(String[] args) {
		CallableTest callableTest = new CallableTest();
		ExecutorService es = Executors.newCachedThreadPool();
		Future<String> result = es.submit(callableTest);
		String s = null;
		
		try {
			 s = result.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println(s);
		es.shutdown();
	}

}
