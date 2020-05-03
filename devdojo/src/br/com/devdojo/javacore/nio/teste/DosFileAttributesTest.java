package br.com.devdojo.javacore.nio.teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest {

	public static void main(String[] args) {
		Path path = Paths.get(
				"C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder2\\subpasta1\\supbasta2\\teste1.txt");

		try {
			if (!Files.exists(path)) {
				Files.createFile(path);
			}

			Files.setAttribute(path, "dos:hidden", true);
			Files.setAttribute(path, "dos:readonly", true);

			DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
			System.out.println(dos.isHidden());
			System.out.println(dos.isReadOnly());
			System.out.println("=====================================================");

			DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
			dosView.setHidden(false);
			dosView.setReadOnly(false);
			dos = Files.readAttributes(path, DosFileAttributes.class);
			System.out.println(dos.isHidden());
			System.out.println(dos.isReadOnly());
			
			System.out.println("=====================================================");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
