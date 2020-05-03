package br.com.devdojo.javacore.nio.teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest {

	public static void main(String[] args) {
		Path p1 = Paths.get("folder/arquivo_renomeado.txt.");
		System.out.println(p1.toAbsolutePath());

		File file = p1.toFile();
		Path path = file.toPath();
		System.out.println(path.toAbsolutePath());

//		Path path2 = Paths.get("folder2");
		Path path2 = Paths.get("folder2/subpasta1/supbasta2");
		Path arquivo = Paths.get("folder2/subpasta1/supbasta2/teste1.txt");

		try {
//			Files.createDirectory(path2);
			if (Files.notExists(path2.getParent())) {
				Files.createDirectories(path2.getParent());
			}

			if (Files.notExists(arquivo)) {
				Files.createFile(arquivo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path source = Paths.get("folder2/subpasta1/supbasta2/teste1.txt");
		Path target = Paths.get("folder2/subpasta1/supbasta2/teste1_copia.txt");

		try {
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			Files.deleteIfExists(target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
