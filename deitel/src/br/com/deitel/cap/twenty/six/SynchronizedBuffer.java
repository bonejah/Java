package br.com.deitel.cap.twenty.six;

public class SynchronizedBuffer implements Buffer {
	private int buffer = -1; // compartilhado pelas threads producer e consumer
	private boolean occupied = false; // se o buffer estiver ocupado

	@Override
	public synchronized void set(int value) throws InterruptedException {
		// enquanto nao houver posicoes vazias, coloca a thread em estado de
		// espera
		while (occupied) {
			// envia informacoes de thread e as informacoes de buffer para a
			// saida, entao espera
			System.out.println("Producer tries to write");
			displayState("Buffer full, Producer waits");
			wait();
		}

		buffer = value; // configura o novo valor do buffer

		// indica que a produtora nao pode armazenar outro valor
		// ate a consumidora recuperar valor atual de buffer
		occupied = true;

		displayState("Producer writes " + buffer);

		notifyAll(); // instrui thread(s) em espera a entrar no estado executavel
	}

	@Override
	public synchronized int get() throws InterruptedException {
		// enquanto os dados nao sao lidos, coloca a thread em estado de espera
		while (occupied) {
			// envia informacoes de thread e as informacoes de buffer para a
			// saida, entao espera
			System.out.println("Consumer tries to read");
			displayState("Buffer full, Consumer waits");
			wait();
		}

		// indica que a produtora nao pode armazenar outro valor
		// ate a consumidora recuperar valor atual de buffer
		occupied = false;

		displayState("Consumer writes " + buffer);

		notifyAll(); // instrui thread(s) em espera a entrar no estado executavel
		return buffer;
	}

	public void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer, occupied);
	}
}
