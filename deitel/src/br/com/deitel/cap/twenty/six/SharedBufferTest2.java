package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new SynchronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n", "Operation", "Buffer", "Occupied","---------", "------\t\t--------");
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.shutdown();
	}
}
