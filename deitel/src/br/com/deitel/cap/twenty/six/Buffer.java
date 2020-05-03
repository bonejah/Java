package br.com.deitel.cap.twenty.six;

public interface Buffer {
	// coloca o valor int no Buffer
	public void set (int value) throws InterruptedException;
	
	// retorna o valor int a partir de um Buffer
	public int get() throws InterruptedException;
}
