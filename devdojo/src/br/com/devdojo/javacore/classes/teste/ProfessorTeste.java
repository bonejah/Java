package br.com.devdojo.javacore.classes.teste;

import br.com.devdojo.javacore.classes.Professor;

public class ProfessorTeste {

	public static void main(String[] args) {
		Professor prof1 = new Professor();
		prof1.nome = "Tadeu";
		prof1.matricula = "YOP2121";
		prof1.rg = "12.456.678-0";
		prof1.cpf = "222.222.222-11";
		
		System.out.println(prof1.nome);
		System.out.println(prof1.matricula);
		System.out.println(prof1.rg);
		System.out.println(prof1.cpf);
		
		System.out.println("----------------");
		
		Professor prof2 = new Professor();
		prof2.nome = "LUCAS";
		prof2.matricula = "UID5678";
		prof2.rg = "12.456.678-0";
		prof2.cpf = "222.222.222-11";
		
		System.out.println(prof2.nome);
		System.out.println(prof2.matricula);
		System.out.println(prof2.rg);
		System.out.println(prof2.cpf);
		
		System.out.println("----------------");
		
		prof1 = prof2;
		System.out.println(prof1.nome);
		System.out.println(prof1.matricula);
		System.out.println(prof1.rg);
		System.out.println(prof1.cpf);
		
	}
	
}
