package br.com.devdojo.introducao.operadores;

public class OperadoresDeAtribuicao {
	
	public static void main(String[] args) {
		int salario = 1800;
		int numero = 10;
//		salario = salario + 1000;
		salario += 1000;
		System.out.println(salario);
		
		salario = salario + (int) (salario * 0.1);
		System.out.println(salario);
		
		System.out.println(numero %= 2);
	}
}

