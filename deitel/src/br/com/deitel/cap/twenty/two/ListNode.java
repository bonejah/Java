package br.com.deitel.cap.twenty.two;

// classe para representar um no em uma lista
public class ListNode<T> {
	T data; // dados para esse no
	ListNode<T> nextNode; // referencia para o proximo no na lista

	// construtor crua uma ListNode que referencia o objeto
	public ListNode(T object) {
		this(object, null);
	}

	// construtor crua ListNode que referencia o objeto
	// especificado e a proxima ListNode
	public ListNode(T object, ListNode<T> node) {
		data = object;
		nextNode = node;
	}

	public T getData() {
		return data;
	}

	public ListNode<T> getNextNode() {
		return nextNode;
	}
}
