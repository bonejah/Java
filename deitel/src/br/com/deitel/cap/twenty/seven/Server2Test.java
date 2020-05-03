package br.com.deitel.cap.twenty.seven;

import javax.swing.JFrame;

public class Server2Test {
	public static void main(String[] args) {
		Server2 server2 = new Server2();
		server2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server2.waitForPackets();
	}
}
