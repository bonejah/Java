package br.com.deitel.cap.twenty.seven;

import javax.swing.JFrame;

public class Client2Test {
	public static void main(String[] args) {
		Client2 client2 = new Client2();
		client2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client2.waitForPackets();
	}
}
