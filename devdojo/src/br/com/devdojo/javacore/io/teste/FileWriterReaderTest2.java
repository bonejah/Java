package br.com.devdojo.javacore.io.teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File file = new File("arquivo2.txt");
				
		try {
			FileWriter fw = new FileWriter(file, true);
//			fw.write("Escrevendo uma msg no arquivo\nE pulando uma linha");
//			fw.write("\nNova Linha");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(file);
			char[] in = new char[500];
			int size = fr.read(in);
			System.out.println(size);
			for (char c : in) {
				System.out.println(c);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
