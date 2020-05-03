package br.com.devdojo.introducao.controlefluxo;

public class ControleDeFluxo1 {

	public static void main(String[] args) {
		int idade = 50;
		float salario = 2000;
		boolean c = false;
		String categoria;
		
		if (c == true) {
			System.out.println("Entrou no clube");
		} else {
			System.out.println("Não fez nada...");
		}
		
		if (idade >= 18 ) {
			System.out.println("Entrou no clube...");
		} else {
			System.out.println("Não pode entrar no clube!");
		}
		
		if (idade < 15) {
			categoria = "Categoria infantil";
		} else if (idade >= 15 && idade < 18) {
			categoria = "Categoria juvenil";
		} else {
			categoria = "Categoria adulto";
		}
		
		System.out.println(categoria);
	}
}
