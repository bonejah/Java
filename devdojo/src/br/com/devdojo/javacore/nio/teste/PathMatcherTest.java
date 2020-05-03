package br.com.devdojo.javacore.nio.teste;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

 class FindlAllTest extends SimpleFileVisitor<Path> {
	 private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test}.{java}");
	 
	 @Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (matcher.matches(file.getFileName())) {
			System.out.println(file.getFileName());
		}
		
		return FileVisitResult.CONTINUE;
	}
 }

public class PathMatcherTest {

	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("devdojo/folder2/subpasta1/supbasta2");
		Path path2 = Paths.get(".bkp");
		Path path3 = Paths.get("bruno_lima");
		PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");
		matches(path1, "glob:.bkp");
		matches(path2, "glob:.bkp");
		System.out.println("=========================================================");
		matches(path1, "glob:*.bkp");
		matches(path1, "glob:**/*.bkp");
		matches(path1, "glob:*");
		matches(path1, "glob:**");
		System.out.println("=========================================================");
		matches(path1, "glob:*.???");
		matches(path1, "glob:**/*.???");
		matches(path1, "glob:**.???");
		System.out.println("=========================================================");
		matches(path3, "glob:{bruno*, lima*}");
		matches(path3, "glob:{bruno, lima}*");
		matches(path3, "glob:{bruno, lima}");
		System.out.println("=========================================================");
		System.out.println("=========================================================");
		
		Files.walkFileTree(Paths.get("./"), new FindlAllTest());
	}
	
	private static void matches(Path path, String glob) {
		PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
		System.out.println(pathMatcher.matches(path));
	}

}
