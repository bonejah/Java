package br.com.deitel.cap.three;

import javax.swing.JOptionPane;

public class NameDialog {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What's your name?");
		String age = JOptionPane.showInputDialog("How old are you?");
		String message = String.format("Welcome, %s to Java Programming!\n You have %s years old!!", name, age);

		JOptionPane.showMessageDialog(null, message);
	}
}
