package br.com.deitel.cap.twenty.two;

public class StackCompositionTest {
	public static void main(String[] args) {
		StackComposition<Integer> stack = new StackComposition<Integer>();

		// utiliza o metodo push
		stack.push(-1);
		stack.print();
		stack.push(0);
		stack.print();
		stack.push(1);
		stack.print();
		stack.push(5);
		stack.print();

		// remove itens pilha
		try {
			int removedItem;

			while (true) {
				removedItem = stack.pop();
				System.out.printf("\n%d popped\n", removedItem);
				stack.print();
			}
		} catch (EmptyListException emptyListException) {
			emptyListException.printStackTrace();
		}
	}
}
