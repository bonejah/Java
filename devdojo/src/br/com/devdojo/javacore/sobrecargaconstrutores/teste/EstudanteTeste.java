package br.com.devdojo.javacore.sobrecargaconstrutores.teste;

import br.com.devdojo.javacore.sobrecargaconstrutores.Estudante;

public class EstudanteTeste {
	
	public static void main(String[] args) {
		Estudante estudante = new Estudante("1221212", "Willian", new double[] {1,2,3});
		estudante.imprime();
		System.out.println("---------------------------------------------------------");
		Estudante estudante2 = new Estudante("1221212", "Willian", new double[] {1,2,3}, "17/11/1981");
		estudante2.imprime();
	}

}
