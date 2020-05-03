package br.com.deitel.cap.fourtheen;

import javax.swing.JFrame;

public class KeyDemoFrameTest {
	public static void main(String[] args) {
		KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
		keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyDemoFrame.setSize(350, 150);
		keyDemoFrame.setVisible(true);
	}
}
