package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
	private JTextField enterField; // insere informacoes fornecidas pelo usuario
	private JTextArea displayArea; // exibe informacoes para o usuario
	private ObjectOutputStream output; // gera fluxo de saida para o servidor
	private ObjectInputStream input; // gera fluxo de entrada a partir do
										// servidor
	private String message = ""; // mensagem do servidor
	private String chatServer; // servidor de host para esse aplicativo
	private Socket client; // socket para comunicacao com o servidor

	public Client(String host) {
		super("Client");

		chatServer = host; // configura o servidor ao qual essse cliente se
							// conecta

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
		add(new JScrollPane(displayArea));
		setSize(300, 150);
		setVisible(true);
	}

	public void runClient() {
		// conecta-se ao servidor, obtem fluxos, processa a conexao
		try {
			connectToServer(); // cria um socket para fazer a conexao
			getStreams(); // obtem os fluxos de entrada e saida
			processConnection(); // processa a conexao
		} catch (EOFException eofException) {
			displayMessage("\nClient terminated connection.");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void connectToServer() throws IOException {
		displayMessage("Attempting connection\n");

		// cria Socket para fazer a conexao com o servidor
		client = new Socket(InetAddress.getByName(chatServer), 12345);

		// exibe informacoes sobre a conexao
		displayMessage("Connected to: " + client.getInetAddress().getHostName());
	}

	private void getStreams() throws IOException {
		// configura o fluxo de saida de objetos
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush(); // esvazia buffer de saida para enviar as informacoes de
						// cabecalho

		// configura o fluxo de entrada de objetos
		input = new ObjectInputStream(client.getInputStream());

		displayMessage("\nGot I/O streams\n");
	}

	private void processConnection() throws IOException {
		// ativa enterField de modo que o usuario cliente possa enviar as
		// mensagens
		setTextFieldEditable(true);

		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			} catch (ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			}
		} while (!message.equals("SERVER>>>> TERMINATE"));
	}

	private void closeConnection() {
		displayMessage("\nClosing connection");
		setTextFieldEditable(false);

		try {
			output.close();
			input.close();
			client.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private void sendData(String message) {
		// envia o objeto ao cliente
		try {
			output.writeObject("CLIENT>>>> " + message);
			output.flush(); // esvazia a saida para o cliente
			displayMessage("\nCLIENT>>>> " + message);
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
