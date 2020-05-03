package br.com.deitel.cap.eightheen;

public class FactorialCalculator3 {
	// declaraçao recursiva de metodo factorial
	public static long factorial(long number) {
		long result = 1;
		// declaracao interativa de metodo factorial
		for (long i = number; i >= 1; i--) {
			result *= i;
		}

		return result;
	}

	public static void main(String[] args) {
		for (int counter = 0; counter <= 10; counter++) {
			System.out.printf("%d! = %d\n", counter, factorial(counter));
		}
	}
}
