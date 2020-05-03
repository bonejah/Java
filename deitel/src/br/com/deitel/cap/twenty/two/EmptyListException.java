package br.com.deitel.cap.twenty.two;

public class EmptyListException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5993303574068744596L;

	public EmptyListException() {
		this("list");
	}

	public EmptyListException(String message) {
		super(message + "is empty");
	}
}
