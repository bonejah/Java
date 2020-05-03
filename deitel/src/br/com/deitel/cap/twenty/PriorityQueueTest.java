package br.com.deitel.cap.twenty;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Double> queue = new PriorityQueue<Double>();

		// insere elementos na fila
		queue.add(3.2);
		queue.add(9.8);
		queue.add(5.4);

		System.out.print("Polling from queue: ");
		while (queue.size() > 0) {
			System.out.printf("%.1f ", queue.peek()); // visualiza o elemento superior
			queue.poll(); // remove elemento superior
		}
	}
}
