package br.com.deitel.cap.twenty.seven;

import javax.swing.JFrame;

public class TicTacToeServerTest {
	public static void main(String[] args) {
		TicTacToeServer application = new TicTacToeServer();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.execute();
	}
}
