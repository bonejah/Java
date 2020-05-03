package br.com.devdojo.javacore.assertions.test;

public class AssertTest {
	
	public static void main(String[] args) {
		calculaSalario(-7000);
		calcSalario(0);
	}
	
	private  static void calculaSalario(double salario) {
		assert(salario > 0) : "O salario não deve ser menor que ZERO";
		System.out.println("Calculou o salário de: " + salario);
	}
	
	public  static void calcSalario(double salario) {
		if (salario < 0);
		 throw new IllegalArgumentException("salario menor que ZERO!!!");
	}

}
