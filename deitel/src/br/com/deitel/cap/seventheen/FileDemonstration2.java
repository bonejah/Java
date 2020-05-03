package br.com.deitel.cap.seventheen;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDemonstration2 extends JFrame {
	private JTextArea outputArea;
	private JScrollPane scrollPane;

	public FileDemonstration2() {
		super("Testing class file");

		outputArea = new JTextArea();
		scrollPane = new JScrollPane(outputArea);
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);

		analyzePath();
	}

	private File getFileOrDirectory() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = jFileChooser.showOpenDialog(this);

		if (result == JFileChooser.CANCEL_OPTION) {
			System.exit(1);
		}

		File fileName = jFileChooser.getSelectedFile();

		if ((fileName == null) || (fileName.getName().equals(""))) {
			JOptionPane.showMessageDialog(this, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		return fileName;
	}

	public void analyzePath() {
		File name = getFileOrDirectory();

		if (name.exists()) {
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", name.getName(), " exists",
					(name.isFile() ? "is a file" : "is not a file"),
					(name.isDirectory() ? "is a directory" : "is not a directory"),
					(name.isAbsolute() ? "is a absolute path" : "is not a absolute path"), "Last modified: ",
					name.lastModified(), "Lenght: ", name.length(), "Path: ", name.getPath(), "Absolute path: ",
					name.getAbsolutePath(), "Parent: ", name.getParent());

			if (name.isDirectory()) {
				String[] directory = name.list();
				System.out.println("\n\nDirectory contents:\n");

				for (String directoryName : directory) {
					System.out.println(directoryName);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, name + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);

		}
	}

}
