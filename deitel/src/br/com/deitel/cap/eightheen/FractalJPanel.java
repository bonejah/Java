package br.com.deitel.cap.eightheen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FractalJPanel extends JPanel {
	private Color color;
	private int level;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	public FractalJPanel(int currentLevel) {
		color = Color.BLUE;
		level = currentLevel;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g) {
		// caso basico: desenha uma linha conectando dois pontos dados
		if (level == 0) {
			g.drawLine(xA, yA, xB, yB);
		} else {
			// calcula ponto intermediario entre (xA, yA) e (xB, yB)
			int xC = (xA + xB) / 2;
			int yC = (yA + yB) / 2;

			// calcula o quarto ponto (xD,yD) que forma um
			// triangulo isoceles reto entre (xA, yA) e (xC, yC)
			// onde o angulo direito está a (xD, yD)
			int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
			int yD = yA + (yC - yA) / 2 - (xC - xA) / 2;

			// desenha recursivamente o Fractal
			drawFractal(level - 1, xD, yD, xA, yA, g);
			drawFractal(level - 1, xD, yD, xC, yC, g);
			drawFractal(level - 1, xD, yD, xB, yB, g);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		drawFractal(level, 100, 90, 290, 200, g);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
