package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircularBufferTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		CircularBuffer sharedLocation = new CircularBuffer();
		sharedLocation.displayState("Initial State");

		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.shutdown();
	}
}
