package br.com.devdojo.javacore.nio.teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AtributosBasicosTest {

	public static void main(String[] args) throws IOException {
		Date primeiroDezembro = new GregorianCalendar(2018, Calendar.DECEMBER, 1).getTime();
		File file = new File("C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder\\teste1.txt");
		file.createNewFile();
		file.setLastModified(primeiroDezembro.getTime());
		System.out.println(file.lastModified());
		
		
		Path path = Paths.get("C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder\\teste1_path.txt");
		Files.createFile(path);
		FileTime fileTime = FileTime.fromMillis(primeiroDezembro.getTime());
		Files.setLastModifiedTime(path, fileTime);
		System.out.println(Files.getLastModifiedTime(path));
		System.out.println(Files.isReadable(path));
		System.out.println(Files.isWritable(path));
		System.out.println(Files.isExecutable(path));
		
		// BasicFileAttribtes, PosixFileAttributes, DosFileAttributes
		BasicFileAttributes atributosBasicos = Files.readAttributes(path, BasicFileAttributes.class);
		System.out.println(atributosBasicos.creationTime());
		System.out.println(atributosBasicos.lastAccessTime());
		System.out.println(atributosBasicos.lastModifiedTime());
		System.out.println(atributosBasicos.isDirectory());
		System.out.println(atributosBasicos.isSymbolicLink());
		System.out.println(atributosBasicos.isRegularFile());
		
		System.out.println("------------------------------");
		
		// BasiFileAttributeView, PosixFileAttributeView, DosFileAttributeView, FileOwnerAttributeView, Ac1FileAttributeView
		FileTime lastModified = atributosBasicos.lastModifiedTime();
		FileTime created = atributosBasicos.creationTime();
		FileTime lastAccess = FileTime.fromMillis(System.currentTimeMillis());
		
		BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		atributosBasicos = Files.readAttributes(path, BasicFileAttributes.class);
		basicView.setTimes(lastModified, lastAccess, created);
		System.out.println(atributosBasicos.creationTime());
		System.out.println(atributosBasicos.lastAccessTime());
		System.out.println(atributosBasicos.lastModifiedTime());
		System.out.println(atributosBasicos.isDirectory());
		System.out.println(atributosBasicos.isSymbolicLink());
		System.out.println(atributosBasicos.isRegularFile());
		
		
		
	}
}
