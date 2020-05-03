package br.com.deitel.cap.five;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Shapes extends JPanel {
	private int choice;

	public Shapes(int userChoice) {
		choice = userChoice;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < 10; i++) {
			switch (choice) {
			case 1: // desenha retangulos
				g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 10 + i * 10);
				break;
			case 2: // desenha elipses
				g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 10 + i * 10);
				break;
			}
		}
	}
}
