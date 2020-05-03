package br.com.deitel.cap.twenty.two;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();

		// utiliza o método queue
		queue.enqueue(-1);
		queue.print();
		queue.enqueue(0);
		queue.print();
		queue.enqueue(1);
		queue.print();
		queue.enqueue(5);
		queue.print();

		// remove objetos da pilha
		try {
			int removedItem;

			while (true) {
				removedItem = queue.dequeue();
				System.out.printf("\n%d dequeued\n", removedItem);
				queue.print();
			}
		} catch (EmptyListException emptyListException) {
			emptyListException.printStackTrace();
		}
	}
}
