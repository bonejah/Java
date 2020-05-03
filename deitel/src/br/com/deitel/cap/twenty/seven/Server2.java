package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Server2 extends JFrame {
	private JTextArea displayArea; // exibe os pacotes recebidos
	private DatagramSocket socket; // socket para conectar ao cliente

	public Server2() {
		super("Server2");

		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);

		try {
			socket = new DatagramSocket(5000);
		} catch (SocketException socketException) {
			socketException.printStackTrace();
			System.exit(1);
		}
	}

	// espera que os pacotes cheguem, exibe os dados e ecoa o pacote para o
	// cliente
	public void waitForPackets() {
		while (true) {
			try {
				byte[] data = new byte[100]; // configura o pacote
				DatagramPacket receivePacket = new DatagramPacket(data, data.length);

				// espera receber o pacote
				socket.receive(receivePacket);

				// exibe informacoes a partir do pacote recebido
				displayMessage("\nPackt received: " + "\nFrom host: " + receivePacket.getAddress() + "\nHost port: "
						+ receivePacket.getPort() + "\nLenght: " + receivePacket.getLength() + "\nContaining:\n\t"
						+ new String(receivePacket.getData(), 0, receivePacket.getLength()));
			} catch (IOException ioException) {
				displayMessage(ioException + "\n");
				ioException.printStackTrace();
			}
		}
	}

	private void sendPacketToClient(DatagramPacket receivePacket) throws IOException {
		displayMessage("\n\nEcho data to client...");

		// cria o pacote a enviar
		DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(),
				receivePacket.getAddress(), receivePacket.getPort());
		socket.send(sendPacket); // envia o pacote ao cliente
		displayMessage("Packet sent\n");
	}

	private void displayMessage(final String message) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				displayArea.append(message);
			}
		});
	}
}
