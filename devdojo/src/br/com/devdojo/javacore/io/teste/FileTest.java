package br.com.devdojo.javacore.io.teste;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("arquivo.txt");
		try {
			if (file.exists()) {
				boolean delete = file.delete();
				System.out.println("Arquivo deletado? " + delete);
			}
			
			boolean newFile = file.createNewFile();
			System.out.println("Arquivo criado? " + newFile);
			System.out.println("Permissão de leitura? " + file.canRead());
			System.out.println("Caminho do arquivo: " + file.getPath());
			System.out.println("Caminho do absoluto do arquivo: " + file.getAbsolutePath());
			System.out.println("É um diretório: " + file.isDirectory());
			System.out.println("É oculto: " + file.isFile());
			System.out.println("Data última modificação: " + new Date(file.lastModified()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
