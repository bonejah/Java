package br.com.devdojo.javacore.classesinternars.teste;

public class ClassesInternasTest {
	public static void main(String[] args) {
		ClassesInternasTest externa = new ClassesInternasTest();
		Interna interna = externa.new Interna();
		Interna interna2 = new ClassesInternasTest().new Interna();
		
		interna.verClasseExterna();
		interna2.verClasseExterna();
		System.out.println(externa.nome);
	}

	private String nome = "Bruno Lima";
	
	class Interna {
		private void verClasseExterna() {
			System.out.println(nome);
			System.out.println(this);
			System.out.println(ClassesInternasTest.this);
		}
	}
}
