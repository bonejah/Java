package br.com.devdojo.javacore.metodos.teste;

import br.com.devdojo.javacore.metodos.Estudante;

public class EstudanteTeste {

	public static void main(String[] args) {
		Estudante estudante = new Estudante();
		estudante.setNome("Bruno");
		estudante.setIdade(37);
		estudante.setNotas(new double[] { 1, 7, 7 });
		estudante.imprime();
		System.out.println("Foi aprovado? " + estudante.isAprovado());
	}

}
