package br.com.deitel.cap.fourtheen;

import javax.swing.JFrame;

public class BorderLayoutFrameTest {
	public static void main(String[] args) {
		BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame();
		borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayoutFrame.setSize(300, 200);
		borderLayoutFrame.setVisible(true);
	}
}
