package br.com.deitel.cap.twenty.seven;

import javax.swing.JFrame;

public class ClientTest {
	public static void main(String[] args) {
		Client application;
		
		if(args.length == 0)
			application = new Client("127.0.0.1"); // conecta-se ao host local
		else
			application = new Client(args[0]); // utiliza argumentos para se conectar
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();
	}
}
