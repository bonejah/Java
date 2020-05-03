package br.com.deitel.cap.five;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapeTest {
	public static void main(String[] args) {
		//obtem a escolha do usuario
		String input = JOptionPane.showInputDialog("Enter 1 to draw rectangles\n" + 
		"Enter 2 to draw ovals");
		
		int choice = Integer.parseInt(input); // converte a entrada em int
		
		Shapes panel = new Shapes(choice);
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(300, 300);
		application.setVisible(true);
		
	}
}
