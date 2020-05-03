package br.com.devdojo.javacore.nio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTest {
	
	public static void main(String[] args) {
		Path dir = Paths.get("/Users/brunolima/Developer/Git/devdojo/folder");
		Path file = Paths.get("/Users/brunolima/Developer/Git/devdojo/folder/subpasta/arquivo_renomeado2.txt");
		Path pathToFile = dir.relativize(file);
		System.out.println(pathToFile);
		
		Path absoluto1 = Paths.get("/home/brunolima");
		Path absoluto2 = Paths.get("/usr/local");
		Path absoluto3 = Paths.get("/home/brunolima/java");
		Path relativo1 = Paths.get("temp");
		Path relativo2 = Paths.get("temp/Funcionario.java");
		
		System.out.println("1: "+ absoluto1.relativize(absoluto3));
		System.out.println("2: "+ absoluto3.relativize(absoluto1));
		System.out.println("3: "+ absoluto1.relativize(absoluto2));
		System.out.println("4: "+ relativo1.relativize(relativo2));
		System.out.println("5: "+ relativo1.relativize(relativo1));
	}
	
}
