package br.com.deitel.cap.twenty.one;

public class StackTest {
	public static void main(String[] args) {
		double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// Cria uma Stack< Double > e uma Stack< Integer >
		Stack<Double> doubleStack = new Stack<Double>(5);
		Stack<Integer> integerStack = new Stack<Integer>();

		// insere os elementos de doubleElements em doubleStack
		testePushDouble(doubleStack, doubleElements);
		testPopDouble(doubleStack);

		// insere os elementos de integerElements em integerStack
		testePushInteger(integerStack, integerElements);
		testPopInteger(integerStack);
	}

	private static void testPopInteger(Stack<Integer> integerStack) {
		// remove elementos da pilha
		try {
			System.out.println("\nPopping elements from integerStack");
			int popValue; // armazena o elemento removido da pilha

			// remove todos os elementos da Stack
			while (true) {
				popValue = integerStack.pop();
				System.out.printf("%d ", popValue);
			}
		} catch (EmptyStackException emptyStackException) {
			System.err.println();
			emptyStackException.printStackTrace();
		}

	}

	private static void testePushInteger(Stack<Integer> integerStack, int[] integerElements) {
		System.out.println("\nPushing elements into integerStack");

		// insere elementos na Stack
		for (int value : integerElements) {
			System.out.printf("%d ", value);
			integerStack.push(value);
		}
	}

	private static void testPopDouble(Stack<Double> doubleStack) {
		// remove elementos da pilha
		try {
			System.out.println("\nPopping elements from doubleStack");
			double popValue; // armazena o elemento removido da pilha

			// remove todos os elementos da Stack
			while (true) {
				popValue = doubleStack.pop();
				System.out.printf("%.1f ", popValue);
			}
		} catch (EmptyStackException emptyStackException) {
			System.err.println();
			emptyStackException.printStackTrace();
		}
	}

	private static void testePushDouble(Stack<Double> doubleStack, double[] doubleElements) {
		System.out.println("\nPushing elements into doubleStack");

		// insere elementos na Stack
		for (double value : doubleElements) {
			System.out.printf("%.1f ", value);
			doubleStack.push(value);
		}
	}
}
