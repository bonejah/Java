package fundamentos.desafios;

import java.util.Scanner;

public class CalculaArea {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe a base do triangulo: ");
		double base = teclado.nextDouble();
		
		System.out.println("Informe a altura do triangulo: ");
		double altura = teclado.nextDouble();
		
		double area = (base * altura) / 2;

		System.out.printf("A area do triangulo eh: %.2f", area);

		teclado.close();
	}

}
