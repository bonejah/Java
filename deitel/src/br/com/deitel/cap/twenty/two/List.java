package br.com.deitel.cap.twenty.two;

public class List<T> {
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name;

	public List() {
		this("list");
	}

	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}

	// insere o item na frente de List
	public void insertAtFront(T insertItem) {
		if (isEmpty()) // firstNode e lastNode referenciam o mesmo objeto
			firstNode = lastNode = new ListNode<T>(insertItem);
		else
			firstNode = new ListNode<T>(insertItem, firstNode);
	}

	// insere o item no fima de List
	public void insertAtBack(T insertItem) {
		if (isEmpty()) // firstNode e lastNode referenciam o mesmo objeto
			firstNode = lastNode = new ListNode<T>(insertItem);
		else
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
	}

	// remove o primeiro no de List
	public T removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);

		T removedItem = firstNode.data; // recupera dados sendo removidos

		// atualiza referencias firstNode e lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;

		return removedItem;
	}

	public T removeFromBack() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);

		T removedItem = lastNode.data; // recupera dados sendo removidos

		// atualiza referencias firstNode e lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else {
			ListNode<T> current = firstNode;

			// faz loop enquanto no atual na referencia lastNode
			while (current.nextNode != lastNode)
				current = current.nextNode;

			lastNode = current; // atual é o novo lastNode
			current.nextNode = null;
		}

		return removedItem;
	}

	public boolean isEmpty() {
		return firstNode == null; // retorna true se a lista estiver vazia
	}

	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty %s\n", name);
			return;
		}

		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;

		// enquanto nao estiver no fim de lista, gera saida dos dados do no
		// atual
		while (current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}

		System.out.println("\n");
	}
}
