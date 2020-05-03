package br.com.devdojo.javacore.nio.teste;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Path dirZip = Paths.get("C:\\Users\\bplima\\Documents\\Desenvolvimento\\GitHub\\devdojo\\folder");
		Path dirFiles = Paths.get("folder");
		Path zipFile = dirZip.resolve("arquivo_zipado.zip");
		
		try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
				DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles);) {
			for (Path path : stream) {
				System.out.println(path);
				ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
				zip.putNextEntry(zipEntry);
				
				FileInputStream fileInputStream = new FileInputStream(path.toFile());
				BufferedInputStream bf = new BufferedInputStream(fileInputStream);
				byte[] buffer = new byte[2048];
				
				zip.write(buffer);
				int bytesRead;
				while((bytesRead = fileInputStream.read()) > 0) {
					zip.write(buffer, 0, bytesRead);
				}
				zip.close();
				fileInputStream.close();
				bf.close();
			}
		} catch (Exception e) {
		}
	}
}
