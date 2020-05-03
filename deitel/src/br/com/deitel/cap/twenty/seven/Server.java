package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	private JTextField enterField; // insere a mensagem do usuario
	private JTextArea displayArea; // exibe informacoes para o usuario
	private ObjectOutputStream output; // gera fluxo de saida para o cliente
	private ObjectInputStream input; // gera fluxo de entrada a partir do
											// cliente
	private ServerSocket server; // socket do servidor
	private Socket connection; // conexao com o cliente
	private int counter = 1; // contador do numero de conexoes

	// configura a GUI
	public Server() {
		super("Server");

		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				sendData(event.getActionCommand());
				enterField.setText("");
			}
		});

		add(enterField, BorderLayout.NORTH);

		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
	}

	// configura e executa o servidor
	public void runServer() {
		try {
			server = new ServerSocket(12345, 100);

			while (true) {
				try {
					waitForConnection(); // espera uma conexao
					getStreams(); // obtem fluxos de entrada e saida
					processConnection(); // processa a conexao
				} catch (EOFException eofException) {
					displayMessage("\nServer terminated connection.");
				} finally {
					closeConnection();
					++counter;
				}
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	private void waitForConnection() throws IOException {
		displayMessage("Waiting for connection\n");
		connection = server.accept(); // permite que o servidor aceite a conexao
		displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
	}
	
	private void getStreams() throws IOException {
		// configura o fluxo de saida para objetos
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); // esvazia buffer de saida para enviar as informacoes de cabecalho
		
		// configura o fluxo de entrada para objetos
		input = new ObjectInputStream(connection.getInputStream());
		displayMessage("\nGot I/O streams\n");
	}
	
	private void processConnection() throws IOException {
		String message = "Connection successful";
		sendData(message); // envia uma mensagem de conexao bem sucedida
		
		// ativa enterField de modo que usuario doservidor possa enviar mensagens
		setTextFieldEditable(true);
		
		// processas as mensagens enviadas pelo cliente
		do {
			try {
				message = (String) input.readObject(); // le uma nova mensagem
				displayMessage("\n" + message); // exibe a mensagem
			} catch (ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			}
		} while (!message.equals("CLIENT>>> TERMINATE"));
	}
	
	private void closeConnection() {
		displayMessage("\nTerminating connection");
		setTextFieldEditable(false); // desativa enterField
		
		try {
			output.close(); // fecha o fluxo de saida
			input.close(); // fecha o fluxo de entrada
			connection.close(); // fecha o socket
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	private void sendData(String message) {
		// envia o objeto ao cliente 
		try {
			output.writeObject("SERVER>>>> " + message);
			output.flush(); // esvazia a saida para o cliente
			displayMessage("\nSERVER>>>> " + message);
		} catch (IOException ioException) {
			displayArea.append("\nError writing object");
		}
	}
	
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				displayArea.append(messageToDisplay);
				
			}
		});
	}
	
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				enterField.setEditable(editable);
			}
		});
	}
}
