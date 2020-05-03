package br.com.deitel.cap.seven;

import javax.swing.JFrame;

public class DrawRainbowTest {
	public static void main(String[] args) {
		DrawRainbow drawRainbow = new DrawRainbow();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(drawRainbow);
		application.setSize(400, 250);
		application.setVisible(true);
	}
}
