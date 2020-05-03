package br.com.devdojo.javacore.nio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {

	public static void main(String[] args) {
		String diretorioProjeto = "/Users/brunolima/Developer/Git/devdojo/folder/";
		String arquivoTxt = "../../arquivo_renomeado.txt";
		Path p1 = Paths.get(diretorioProjeto, arquivoTxt);
		System.out.println(p1);
		System.out.println(p1.normalize());
	}
	
}
