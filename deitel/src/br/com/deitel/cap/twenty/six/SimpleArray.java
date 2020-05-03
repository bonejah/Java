package br.com.deitel.cap.twenty.six;

import java.util.Arrays;
import java.util.Random;

public class SimpleArray { // ATENCAO: NAO SEGURO PARA THREADS
	private final int[] array; // o array de inteiros compartilhado
	private int writeIndex = 0; // o indice o proximo elemento a ser gravado
	private final static Random generator = new Random();
	
	// constroi um SimpleArray de um dado tamanho
	public SimpleArray(int size) {
		array = new int[size];
	}
	
	public synchronized void add(int value) {
		int position = writeIndex; // armazena o indice de gravacao
		
		try {
			// coloca a thread para dormir por 0-499 milisegundos
			Thread.sleep(generator.nextInt(500));
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
		
		// coloca o elemento no valor correto
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.\n", Thread.currentThread().getName(), value, position);
		
		++writeIndex; // incrementa indice do elemento a ser gravado depois
		System.out.printf("Next write index: %d\n", writeIndex);
	}
	
	@Override
	public String toString() {
		return "\nContents of SimpleArray:\n" + Arrays.toString(array);
	}

}
