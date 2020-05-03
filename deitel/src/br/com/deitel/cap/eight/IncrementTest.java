package br.com.deitel.cap.eight;

public class IncrementTest {
	public static void main(String[] args) {
		Increment increment = new Increment(5);

		System.out.printf("Before incrementing: %s\n\n", increment);

		for (int i = 1; i <= 3; i++) {
			increment.addIncrementToTotal();
			System.out.printf("After increment: %d: %s\n", i, increment);
		}
	}
}
