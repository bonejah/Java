package br.com.devdojo.javacore.classesinternars.teste;

import br.com.devdojo.javacore.classesinternars.teste.Externa.Interna;

class Externa {
	static class Interna {
		public void imprimir() {
			System.out.println("oi");
		}
	}
}

public class ClassesInternasEstaticasTest {
	
	public static void main(String[] args) {
		Interna interna = new Externa.Interna();
		interna.imprimir();
		Interna2 interna2 = new Interna2();
		interna2.imprimir();
	}
	
	static class Interna2 {
		public void imprimir() {
			System.out.println("oi imprimindo");
		}
	}

}
