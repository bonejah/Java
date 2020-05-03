package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {
	public static void main(String[] args) {
		// cria novo pool de threads com duas threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// crua UnsynchronizedBuffer para armazenar ints
		Buffer sharedLocation = new UnsychonizedBuffer();
		
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed.");
		System.out.println("------\t\t-----\t---------------\t---------------\n");

		// executa Producer e Consumer, fornecendo-lhes acesso a sharedLocation
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.shutdown();
	}
}
