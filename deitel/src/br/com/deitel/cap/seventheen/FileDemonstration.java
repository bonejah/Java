package br.com.deitel.cap.seventheen;

import java.io.File;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class FileDemonstration {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file or directory name: ");
		analyzePath(input.nextLine());
	}

	public static void analyzePath(String path) {
		File file = new File(path);

		if (file.exists()) {
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", file.getName(), " exists",
					(file.isFile() ? "is a file" : "is not a file"),
					(file.isDirectory() ? "is a directory" : "is not a directory"),
					(file.isAbsolute() ? "is a absolute path" : "is not a absolute path"), "Last modified: ",
					file.lastModified(), "Lenght: ", file.length(), "Path: ", file.getPath(), "Absolute path: ",
					file.getAbsolutePath(), "Parent: ", file.getParent());

			if (file.isDirectory()) {
				String[] directory = file.list();
				System.out.println("\n\nDirectory contents:\n");

				for (String directoryName : directory) {
					System.out.println(directoryName);
				}
			}
		} else {
			System.out.printf("%s %s", path, "does not exist.");
		}
	}
}
