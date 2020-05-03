package br.com.devdojo.javacore.io.teste;

import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		Console console = System.console();
		char[] pw = console.readPassword("%s ", "pw: ");

		for (char pass : pw) {
			console.format("%c ", pass);
		}
		console.format("\n");
		
		String texto;
		while(true) {
			texto = console.readLine("%s", "Digite: ");
			console.format("esse texto %s foi digitado", retorno(texto));
		}
	}

	
	public static String retorno (String arg1) {
		return "entrada de dados :" + arg1;
	}
}
