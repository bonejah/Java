package br.com.devdojo.javacore.nio.teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributeTest {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(
				"C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder2\\subpasta1\\supbasta2\\teste1.txt");
		PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
		System.out.println(posix.permissions());
		
	System.out.println("Alterando as permissões..");
	Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw-rw");
	Files.setPosixFilePermissions(path, permissions);
	posix = Files.readAttributes(path, PosixFileAttributes.class);
	System.out.println(posix.permissions());
	
	}

}
