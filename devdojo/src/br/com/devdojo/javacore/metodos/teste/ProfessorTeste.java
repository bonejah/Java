package br.com.devdojo.javacore.metodos.teste;

import br.com.devdojo.javacore.metodos.Professor;

public class ProfessorTeste {

	public static void main(String[] args) {
		Professor prof1 = new Professor();
		prof1.nome = "Jaspion";
		prof1.matricula = "YOP2121";
		prof1.rg = "12.456.678-0";
		prof1.cpf = "222.222.222-11";
		
		System.out.println("Dentro do teste");
		System.out.println(prof1.nome);
		prof1.imprime();
		System.out.println(prof1.nome);
	}
}
