package br.com.devdojo.javacore.exception.checked;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
	
	public static void main(String[] args) {
		System.out.println(criarArquivo() == true ? "Arquivo criado com sucesso" : "Erro ao criar o arquivo");
	}
	
	public static boolean criarArquivo() {
		File file = new File("teste.txt");
		
		try {
			file.createNewFile();
			return true;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
