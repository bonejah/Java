package br.com.devdojo.javacore.io.teste;

import java.io.File;
import java.io.IOException;

public class FileDiretorioTest {

	public static void main(String[] args) throws IOException {
		File diretorio = new File("folder");
		boolean dir = diretorio.mkdir();
		System.out.println("Diret�rio criado?: " + dir);

		File arquivo = new File(diretorio, "arquivo_teste.txt");
		boolean arq = arquivo.createNewFile();
		System.out.println("Arquivo criado? " + arq);

		File arquivoRenomeado = new File(diretorio, "arquivo_renomeado.txt");
		boolean renamed = arquivo.renameTo(arquivoRenomeado);
		System.out.println("Renomeado? " + renamed);

		File diretorioRenomeado = new File("folder_new");
		boolean dirRenamed = diretorio.renameTo(diretorioRenomeado);
		System.out.println("Renomeado? " + dirRenamed);
		buscarArquivos();
	}

	public static void buscarArquivos() {
		File file = new File("folder_new");
		String[] listFiles = file.list();
		for (String fille : listFiles) {
			System.out.println(fille);
		}

	}
}
