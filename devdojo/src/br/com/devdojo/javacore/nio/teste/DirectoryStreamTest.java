package br.com.devdojo.javacore.nio.teste;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest {
	
	public static void main(String[] args) {
		Path dir = Paths.get(
				"C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder2\\subpasta1\\supbasta2");
		
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
			for (Path path : stream) {
				System.out.println(path);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
