package br.com.deitel.cap.six;

public class MethodOverLoad {
	public void testOverLoadMethods() {
		System.out.printf("Square of integer 7 is %d\n", square(7));
		System.out.printf("Square of double 7.5 is %f\n", square(7.5));
	}

	private double square(double doubleValue) {
		System.out.printf("\nCalled square with double argument: %f\n", doubleValue);
		return doubleValue * doubleValue;
	}

	private int square(int intValue) {
		System.out.printf("\nCalled square with int argument: %d\n", intValue);
		return intValue * intValue;
	}
}
