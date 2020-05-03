package br.com.deitel.cap.eightheen;

public class FactorialCalculator {
	// metodo recursivo fatorial(assume que seu parametro é >=0
	public static long factorial(long number) {
		if (number <= 1) // testa o caso basico
			return 1; // casos basicos: 0! = 1 e 1! = 1
		else // passo de recursao
			return number * factorial(number - 1);
	} // fim do metodo fatorial

 	// gera saida de fatoriais para valores 0-21
	public static void main(String[] args) {
		// calcula fatorial de 0 a 21
		for (int count = 0; count <= 21; count++) {
			System.out.printf("%d! = %d\n", count, factorial(count));
		}
	}

}
