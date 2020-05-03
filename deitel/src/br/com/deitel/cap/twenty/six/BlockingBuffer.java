package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
	private final ArrayBlockingQueue<Integer> buffer; // buffer compartilhado

	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(1);
	}

	@Override
	public void set(int value) throws InterruptedException {
		buffer.put(value); // coloca o valor no buffer
		System.out.printf("%s%2d\t%s%d\n", "Producer writes ", value, "Buffer cells occupied: ", buffer.size());
	}

	@Override
	public int get() throws InterruptedException {
		int readValue = buffer.take(); // remove o valor do buffer
		System.out.printf("%s%2d\t%s%d\n", "Consumer reads ", readValue, "Buffer cells occupied: ", buffer.size());
		return readValue;
	}

}