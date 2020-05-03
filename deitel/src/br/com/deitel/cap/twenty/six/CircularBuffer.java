package br.com.deitel.cap.twenty.six;

public class CircularBuffer implements Buffer {
	private final int[] buffer = { -1, -1, -1 }; // buffer compartilhado
	private int occupiedCells = 0; // conta numero de buffers compartilhado
	private int writeIndex = 0; // indice do proximo elemento em que gravar
	private int readIndex = 0; // indice do proprio elemento a ler

	@Override
	public synchronized void set(int value) throws InterruptedException {
		while (occupiedCells == buffer.length) {
			System.out.printf("Buffer is full. Producer waits.\n");
			wait();
		}

		buffer[writeIndex] = value; // configura o novo valor do buffer

		// atualiza indice de gravacao circular
		writeIndex = (writeIndex + 1) % buffer.length;
		++occupiedCells; // mais uma celula do buffer esta cheia
		displayState("Producer writes " + value);
		notifyAll();
	}

	@Override
	public synchronized int get() throws InterruptedException {
		while (occupiedCells == 0) {
			System.out.printf("Buffer is empty. Consumer waits.\n");
			wait();
		}

		int readValue = buffer[readIndex + 1] % buffer.length;
		--occupiedCells;
		displayState("Consumer reads " + readValue);
		notifyAll();

		return readValue;
	}

	public void displayState(String operation) {
		System.out.printf("%s%s%d)\n%s", operation, "buffer cells occupied: ", occupiedCells, "buffer cells: ");

		for (int value : buffer) {
			System.out.printf("  %2d  ", value);
		}

		System.out.printf("\n                ");

		for (int i = 0; i < buffer.length; i++) {
			System.out.println("---- ");
		}

		System.out.printf("\n                ");

		for (int i = 0; i < buffer.length; i++) {
			if (i == writeIndex && i == readIndex)
				System.out.print(" WR "); // indice de gravacao e leitura
			else if (i == writeIndex)
				System.out.print(" W "); // so grava
			else if (i == readIndex)
				System.out.print(" R "); // so le indice
			else
				System.out.print("   "); // nao faz nada
		}
	}
}
