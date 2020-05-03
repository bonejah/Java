package br.com.devdojo.javacore.exception.checked;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResourcesTest {

	public static void main(String[] args) {
//		lerArquivoNew();
		lerArquivoLeitor();
	}
	
	@SuppressWarnings("resource")
	public static void lerArquivoLeitor() {
		try(Leitor1 leitor1 = new Leitor1(); Leitor2 leitor2 = new Leitor2()) {
			System.out.println("Arquivo lido com Leitor");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void lerArquivoOld() {
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("teste.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void lerArquivoNew() {
		try (Reader reader = new BufferedReader(new FileReader("teste.txt"))) {
			System.out.println("Arquivo lido com sucesso...");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
