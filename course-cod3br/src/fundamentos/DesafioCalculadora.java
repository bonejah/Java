package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {

	public static void main(String[] args) {
		calculadoraComTernario();
//		calculadoraComIf();

	}

	private static void calculadoraComTernario() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe um numero: ");
		double num1 = teclado.nextDouble();
		
		System.out.println("Informe um numero: ");
		double num2 = teclado.nextDouble();
		
		System.out.println("Informe uma operacao (+, -, *, /, %)");
		String operacao = teclado.next();
		
		teclado.close();

		double resultado = operacao.equals("+") ? num1 + num2 : 0;
		resultado = operacao.equals("-") ? num1 - num2 : resultado;
		resultado = operacao.equals("*") ? num1 * num2 : resultado;
		resultado = operacao.equals("/") ? num1 / num2 : resultado;
		resultado = operacao.equals("%") ? num1 % num2 : resultado;
		
		System.out.printf("%.2f %s %.2f = %.2f", num1, operacao, num2, resultado);
	}

	private static void calculadoraComIf() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Escolha uma operacao: ");
		System.out.println("1 -> Para somar (+)");
		System.out.println("2 -> Para subtrair (-)");
		System.out.println("3 -> Para multiplicar (*)");
		System.out.println("4 -> Para dividir (/)");
		System.out.println("5 -> Para resto (%)");
		System.out.println("0 -> SAIR do programa!!!");
		int operacao = teclado.nextInt();

		if (operacao == 0) {
			System.out.println("Voce decidiu sair, Bye!!!");
			teclado.close();
			System.exit(0);
		}

		System.out.println("Informe um numero: ");
		int num1 = teclado.nextInt();

		System.out.println("Informe outro numero: ");
		int num2 = teclado.nextInt();

		teclado.close();

		int resultado = 0;

		if (operacao == 1) {
			resultado = num1 + num2;
		} else if (operacao == 2) {
			resultado = num1 - num2;
		} else if (operacao == 3) {
			resultado = num1 * num2;
		} else if (operacao == 4) {
			resultado = num1 / num2;
		} else if (operacao == 5) {
			resultado = num1 % num2;
		}

		System.out.println("Resultado: " + resultado);

	}
}
