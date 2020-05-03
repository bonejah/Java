package br.com.devdojo.javacore.classesinternars.teste;

public class ClassesLocaisTest {
	private String nome = "Bruno";
	
	public void fazAlgumaCoisa(String valor) {
		final String sobreNome = "Lima";
		
		class Interna {
			public void imprimeNomeExterno() {
				System.out.println(nome);
				System.out.println(sobreNome);
				System.out.println(valor);
			}
		}
		
		Interna interna = new Interna();
		interna.imprimeNomeExterno();
	}

	public static void main(String[] args) {
		ClassesLocaisTest externa = new ClassesLocaisTest();
		externa.fazAlgumaCoisa("valor");
	}
}
