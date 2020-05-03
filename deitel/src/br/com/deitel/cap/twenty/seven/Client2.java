package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.DirectoryStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client2 extends JFrame {
	private JTextField enterField; // para inserir mensagens
	private JTextArea displayArea; // para exibir mensagens
	private DatagramSocket socket; // socket para conectar ao servidor

	public Client2() {
		super("Client2");

		enterField = new JTextField("Type message here");
		enterField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					String message = event.getActionCommand();
					displayArea.append("\nSending packet containing: " + message + "\n");
					byte[] data = message.getBytes();

					// cria sendPacket
					DatagramPacket sendPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 5000);

					socket.send(sendPacket); // envia pacote
					displayArea.append("Packet sent\n");
					displayArea.setCaretPosition(displayArea.getText().length());
				} catch (IOException ioException) {
					displayMessage(ioException + "\n");
					ioException.printStackTrace();
				}
			}
		});

		add(enterField, BorderLayout.NORTH);
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);

		try {
			socket = new DatagramSocket();
		} catch (SocketException socketException) {
			socketException.printStackTrace();
			System.exit(1);
		}
	}

	public void waitForPackets() {
		while (true) {
			try {
				byte[] data = new byte[100]; // Configure o pacote
				DatagramPacket receivePacket = new DatagramPacket(data, data.length);
				socket.receive(receivePacket); /// espera o pacote

				// exibe o counteudo do pacote
				displayMessage("\nPacket received:" + "\nFrom host: " + receivePacket.getAddress() + "\nHost port: "
						+ receivePacket.getPort() + "\nLength: " + receivePacket.getLength() + "\nContaining:\n\t"
						+ new String(receivePacket.getData(), 0, receivePacket.getLength()));
			} catch (IOException ioException) {
				displayMessage(ioException + "\n");
				ioException.printStackTrace();
			}
		}
	}

	// manipula a displayAre na thread de despacho de eventos
	public void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				displayArea.append(messageToDisplay);
			}
		});
	}
}
