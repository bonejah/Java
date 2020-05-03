package br.com.devdojo.javacore.exception.checked;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest2 {
	
	public static void main(String[] args) {
		try {
			criarArquivo();
			abrirArquivo();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void criarArquivo() throws IOException {
		File file = new File("teste.txt");
		boolean fileCreated = file.createNewFile();
		System.out.println("Arquivo criado com sucesso");
//		System.out.println(fileCreated);
	}
	
	public static void abrirArquivo() {
		try {
			System.out.println("Abrindo arquivo...");
			System.out.println("Executando a leitura do arquivo...");
			throw new Exception();
//			System.out.println("Escrevendo no arquivo...");
		} catch (Exception e) {
			System.out.println("Dentro do catch");
			e.printStackTrace();
		} finally {
			System.out.println("Fechar o arquivo...");
		}
	}
}
