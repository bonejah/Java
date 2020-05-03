package br.com.deitel.cap.fourtheen;

import javax.swing.JFrame;

public class ListFrameTest {
	public static void main(String[] args) {
		ListFrame listFrame = new ListFrame();
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(350, 150);
		listFrame.setVisible(true);
	}
}
