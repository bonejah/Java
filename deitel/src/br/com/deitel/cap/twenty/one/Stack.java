package br.com.deitel.cap.twenty.one;

import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> elements; // ArrayList armazena elementos da pilha

	// construtor sem argumento cria uma pilha do tamanho padrao
	public Stack() {
		this(10); // tamanho padrao da pilha
	}

	// construtor cria uma pilha com o numero especificado de elementos
	public Stack(int capacity) {
		int initCapacity = capacity > 0 ? capacity : 10; // valida
		elements = new ArrayList<T>(initCapacity); // cria a ArrayList
	}

	// insere o elemento da pilha
	public void push(T pushValue) {
		elements.add(pushValue);
	}

	// retorna o elemento superior se nao estiver vazia, do contrario lança uma
	// EmptyStackException
	public T pop() {
		if (elements.isEmpty()) // se a pilha estiver vazia
			throw new EmptyStackException("Stack is empty, cannot pop!");
		
		return elements.remove(elements.size() - 1);
	}
}
