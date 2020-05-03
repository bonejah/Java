package br.com.deitel.cap.twenty.one;

public class EmptyStackException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// construtor sem argumentos
	public EmptyStackException() {
		this("Stack is empty");
	}
	
	// construtor de um argumento
	public EmptyStackException(String message) {
		super(message);
	}
}
