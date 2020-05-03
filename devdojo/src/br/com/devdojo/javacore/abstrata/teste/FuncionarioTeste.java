package br.com.devdojo.javacore.abstrata.teste;

import br.com.devdojo.javacore.abstrata.Gerente;
import br.com.devdojo.javacore.abstrata.Vendedor;

public class FuncionarioTeste {

	public static void main(String[] args) {
		Gerente gerente = new Gerente("Ana", "3232-7", 12000);
		gerente.calcularSalario();
		System.out.println(gerente);
		
		Vendedor vendedor = new Vendedor("Paulo", "31232-7", 4000, 1000);
		vendedor.calcularSalario();
		System.out.println(vendedor);
		
	}
}
