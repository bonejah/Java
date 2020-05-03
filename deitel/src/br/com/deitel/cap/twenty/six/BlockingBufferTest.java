package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest {
	public static void main(String[] args) {
		// cria novo pool de threas com duas threads
		ExecutorService executorService = Executors.newCachedThreadPool();

		// cria BlockingBuffer para armazenar ints
		Buffer sharedLocation = new BlockingBuffer();
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.shutdown();
	}
}
