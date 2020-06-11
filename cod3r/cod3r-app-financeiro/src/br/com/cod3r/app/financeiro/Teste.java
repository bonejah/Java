package br.com.cod3r.app.financeiro;

import java.util.ServiceLoader;

import br.com.cod3r.app.Calculadora;

public class Teste {

	public static void main(String[] args) {
//		CalculadoraImpl calculadora = new CalculadoraImpl();
		Calculadora calculadora = ServiceLoader
					.load(Calculadora.class)
					.findFirst()
					.get();
		System.out.println(calculadora.soma(2, 3, 4));
//		System.out.println(calculadora.getLoggerClass());

//		OperacoesAritmeticas op = new OperacoesAritmeticas();
//		System.out.println(op.soma(4, 5, 6));
		
//		try {
//			Field fieldId = CalculadoraImpl.class.getDeclaredFields()[0];
//			fieldId.setAccessible(true);
//			fieldId.set(calculadora, "def");
//			fieldId.setAccessible(false);
//			
//			System.out.println(calculadora.getId());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
