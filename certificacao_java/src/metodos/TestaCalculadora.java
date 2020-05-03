package metodos;

class Calculadora {
	
	public int soma (int... numeros) {
		int soma = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			soma += numeros[i];
		}
		
		return soma;
	}
	
}

public class TestaCalculadora {
	
	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		System.out.println(calculadora.soma(new int[] {1,2}));
		System.out.println(calculadora.soma(1, 1));
		System.out.println(calculadora.soma(1, 2, 3));
		System.out.println(calculadora.soma(1, 2, 3, 4));
		System.out.println(calculadora.soma(1));
		System.out.println(calculadora.soma());
	}
	
}
