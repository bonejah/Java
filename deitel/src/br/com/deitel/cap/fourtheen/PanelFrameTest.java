package br.com.deitel.cap.fourtheen;

import javax.swing.JFrame;

public class PanelFrameTest {
	public static void main(String[] args) {
		PanelFrame panelFrame = new PanelFrame();
		panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelFrame.setSize(450, 200);
		panelFrame.setVisible(true);
	}
}
