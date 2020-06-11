package lambda;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {
	
	public static void main(String[] args) {

		System.out.println("BinaryOperator usando Double");
		
		BinaryOperator<Double> calculo = (x, y) -> { return x + y; };
		System.out.println(calculo.apply(7.0, 3.0));

		calculo = (x, y) -> x * y;
		System.out.println(calculo.apply(7.0, 3.0));
		
		System.out.println();
		
		System.out.println("BinaryOperator usando Integer");
		
		BinaryOperator<Integer> calculo2 = (x, y) -> { return x + y; };
		System.out.println(calculo2.apply(7, 3));

		calculo2 = (x, y) -> x * y;
		System.out.println(calculo2.apply(7, 3));
		
	}

}
