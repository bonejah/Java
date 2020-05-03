package br.com.deitel.cap.twenty.one;

public class StackTest2 {
	public static void main(String[] args) {
		Double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Integer[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// Cria uma Stack< Double > e uma Stack< Integer >
		Stack<Double> doubleStack = new Stack<Double>(5);
		Stack<Integer> integerStack = new Stack<Integer>();

		// insere os elementos de doubleElements em doubleStack
		testPush("doubleStack", doubleStack, doubleElements);
		testPop("doubleStack", doubleStack);

		// insere os elementos de integerElements em integerStack
		testPush("integerStack", integerStack, integerElements);
		testPop("integerStack", integerStack);
	}

	// metodo generico testPush insere elementos em uma Stack
	public static <T> void testPush(String name, Stack<T> stack, T[] elements) {
		System.out.printf("\nPushing elementos into %s\n", name);

		// insere elementos na Stack
		for (T element : elements) {
			System.out.printf("%s ", element);
			stack.push(element);
		}
	}

	// metodo generico testPop remove elementos de uma Stack
	public static <T> void testPop(String name, Stack<T> stack) {
		// remove elementos da pilha

		try {
			System.out.printf("\nPopping elements from %s\n", name);
			T popValue; // armazena o elemento removido da pilha

			// remove todos os elementos da Stack
			while (true) {
				popValue = stack.pop();
				System.out.printf("%s ", popValue);
			}
		} catch (EmptyStackException emptyStackException) {
			System.out.println();
			emptyStackException.printStackTrace();
		}
	}
}
