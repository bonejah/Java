package br.com.devdojo.javacore.io.teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {
	
	public static void main(String[] args) {
		File file = new File("arquivo2.txt");

		try (FileWriter fw = new FileWriter(file, true)) {
			FileReader fr = new FileReader(file);
			// fw.write("Escrevendo uma msg no arquivo\nE pulando uma linha");
			// fw.write("\nNova Linha");
			fw.flush();
			fw.close();

			char[] in = new char[500];
			int size = fr.read(in);
			System.out.println(size);
			for (char c : in) {
				System.out.print(c);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
