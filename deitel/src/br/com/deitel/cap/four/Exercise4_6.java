package br.com.deitel.cap.four;

public class Exercise4_6 {
	public static void main(String[] args) {
		int count = 0;
		int numero = 1;
		int total = 0;

		while (count < 10) {
			total += numero;
			count++;
			numero += 1;
		}

		System.out.printf("A soma dos numeros de 1 a 10 é: %d\n", total);
	}
}
