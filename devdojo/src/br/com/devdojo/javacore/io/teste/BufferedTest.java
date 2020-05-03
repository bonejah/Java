package br.com.devdojo.javacore.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {

	public static void main(String[] args) {
		File file = new File("arquivo3.txt");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				BufferedReader br = new BufferedReader(new FileReader(file))) {
			bw.write("Escrevendo uma mensagem no arquivo");
			bw.newLine();
			bw.write("Escrevendo outra mensagem no arquivo");
			bw.flush();
			
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

