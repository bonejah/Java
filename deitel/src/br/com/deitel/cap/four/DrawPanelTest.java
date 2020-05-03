package br.com.deitel.cap.four;

import javax.swing.JFrame;

public class DrawPanelTest {
	public static void main(String[] args) {
		// cria um painel que contem o nosso desenho
		DrawPanel drawPanel = new DrawPanel();
		
		// cria um novo quadro para armazenar o painel
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(drawPanel);
		application.setSize(250, 250);
		application.setVisible(true);
	}
}
