package br.com.devdojo.javacore.nio.teste;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class AchaTodosOsBKP extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		if (file.getFileName().toString().endsWith("bkp")) {
			System.out.println(file.getFileName());
		}

		return FileVisitResult.CONTINUE;
	}
}

class PrintDirs extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("pre: " + dir);
		if(dir.getFileName().toString().endsWith(".txt")) {
			return FileVisitResult.TERMINATE;
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		System.out.println("file: " + file.getFileName());
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("post: " + dir);
		return super.postVisitDirectory(dir, exc);
	}
}

public class FileVisitorTest {

	public static void main(String[] args) throws IOException {
//		Files.walkFileTree(Paths
//				.get("C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder2\\subpasta1\\supbasta2"),
//				new AchaTodosOsBKP());
		
		Files.walkFileTree(Paths
				.get("C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder2\\subpasta1\\supbasta2"),
				new PrintDirs());
	}
}
