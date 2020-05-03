package br.com.deitel.cap.twenty.two;

public class StackComposition<T> {
	private List<T> stackList;

	public StackComposition() {
		stackList = new List<T>("stack");
	}

	public void push(T object) {
		stackList.insertAtFront(object);
	}

	public T pop() throws EmptyListException {
		return stackList.removeFromFront();
	}

	public void print() {
		stackList.print();
	}
}
