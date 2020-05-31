package fundamentos.primitivos;

public class Temperatura {

	public static void main(String[] args) {
		// (F  - 32) x 5/9 => C
		final double AJUSTE = 32;
		final double FATOR = 5.0 / 9.0;
		
		double fahrenheit = 35.5;
		double celsius = (fahrenheit - AJUSTE) * FATOR;
		System.out.println("A temperatura: " + fahrenheit + " em fahreinhet convertida para celsius é: " + celsius);
		
		fahrenheit = 150;
		celsius = (fahrenheit - AJUSTE) * FATOR;
		System.out.println("A temperatura: " + fahrenheit + " em fahreinhet convertida para celsius é: " + celsius);
		
	}
	
}
