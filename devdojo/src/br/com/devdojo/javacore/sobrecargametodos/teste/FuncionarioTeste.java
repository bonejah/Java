package br.com.devdojo.javacore.sobrecargametodos.teste;

import br.com.devdojo.javacore.sobrecargametodos.Funcionario;

public class FuncionarioTeste {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario("Ze Carioca", "123.456.789-10", 1500.00, "27.122456-80");
//		funcionario.setNome("Ze Carioca");
//		funcionario.setCpf("123.456.789-10");
//		funcionario.setSalario(1500.00);
		funcionario.imprime();
		
		System.out.println("----------------------");
		
		Funcionario funcionario2 = new Funcionario("Toptal");
		funcionario2.imprime();
	}
	
}
