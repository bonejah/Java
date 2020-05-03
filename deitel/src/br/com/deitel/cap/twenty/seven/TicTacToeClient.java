package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TicTacToeClient extends JFrame implements Runnable {
	private JTextField idField; // campo de texto para exibir a marca do jogador
	private JTextArea displayArea; // JTextArea para exibir a saida
	private JPanel boardPanel; // painel para o tabuleiro do jogo da velha
	private JPanel panel2; // painel para conter o tabuleiro
	private Square[][] board; // tabuleiro do jogo da velha
	private Square currentSquare; // quadrado atual
	private Socket connection; // conexao com o servidor
	private Scanner input; // entrada a partir do servidor
	private Formatter output; // saida para o servidor
	private String ticTacToeHost; // nome do host para o servidor
	private String myMark; // marca desse cliente
	private boolean myTurn; // determina de qual cliente é a vez
	private final String X_MARK = "X";
	private final String O_MARK = "O";

	public TicTacToeClient(String host) {
		ticTacToeHost = host; // configura o nome do servidor
		displayArea = new JTextArea(4, 30); // configura JTextArea
		displayArea.setEditable(false);
		add(new JScrollPane(displayArea), BorderLayout.SOUTH);

		boardPanel = new JPanel(); // configura o painel para os quadrados no
									// tabuleiro
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));
		board = new Square[3][3]; // cria o tabuleiro

		// faz um loop pelas linhas no tabuleiro
		for (int row = 0; row < board.length; row++) {
			// faz um loop pelas colunas do tabuleiro
			for (int column = 0; column < board[row].length; column++) {
				// cria um quadrado
				board[row][column] = new Square("", row * 3 + column);
				boardPanel.add(board[row][column]); // adiciona um quadrado
			}
		}

		idField = new JTextField(); // configura o campo de texto
		idField.setEditable(false);
		add(idField, BorderLayout.NORTH);

		panel2 = new JPanel(); // configura o painel que ira conter o boardPanel
		panel2.add(boardPanel, BorderLayout.CENTER); // adiciona o painel ao
														// tabuleiro
		add(panel2, BorderLayout.CENTER); // adiciona o painel ao conteiner

		setSize(300, 225); // configura o tamanho da janela
		setVisible(true); // mostra a janela
		startClient();
	}

	public void startClient() {
		// conecta-se ao servidor e obtem os fluxos
		try {
			// faz conexao com o servidor
			connection = new Socket(InetAddress.getByName(ticTacToeHost), 12345);

			// obtem os fluxos de entrada e saida
			input = new Scanner(connection.getInputStream());
			output = new Formatter(connection.getOutputStream());
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		// cria e inicia a thread de trabalhador para esse cliente
		ExecutorService worker = Executors.newFixedThreadPool(1);
		worker.execute(this);
	}

	// thread de controle que permite atualizacao continua da displayArea
	@Override
	public void run() {
		myMark = input.nextLine();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// envia a marca do jogador
				idField.setText("Youy are player \"" + myMark + "\"");

			}
		});

		myTurn = (myMark.equals(X_MARK)); // determina se é a vez do cliente

		while (true) {
			if (input.hasNextLine()) {
				processMessage(input.nextLine());
			}
		}
	}

	private void processMessage(String message) {
		if (message.equals("Valid move.")) {
			displayMessage("Valid move, please wait.\n");
			setMark(currentSquare, myMark); // configura a marca no quadrado
		} else if (message.equals("Invalid move, try again")) {
			displayMessage(message + "\n"); // exibe jogada inválida
			myTurn = true; // ainda é a vez desse cliente
		} else if (message.equals("Opponent moved")) {
			int location = input.nextInt(); // obtem posicao da jogada
			input.nextLine(); // pula uma nova linha depois da posicao int
			int row = location / 3; // calcula a linha
			int column = location % 3; // calcula a coluna

			setMark(board[row][column], (myMark.equals(X_MARK) ? O_MARK : X_MARK)); // marca
																					// a
																					// jogada
			displayMessage("Opponent moved. Your turn.\n");
			myTurn = true; // agora é a vez desse cliente
		} else {
			displayMessage(message + "\n"); // exibe a mensagem
		}
	}

	// exibe uma mensagem na displayArea
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				displayArea.append(messageToDisplay);
			}
		});
	}

	// metodo utilitario para configurar a marca sobre o tabuleiro na thread de
	// despacho de eventos
	private void setMark(final Square square, final String mark) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				square.setMark(mark);
			}
		});
	}

	// envia mensagem para o servidor indicando o quadrado clicado
	private void sendClickedSquare(int location) {
		if (myTurn) {
			output.format("%d\n", location);
			output.flush();
			myTurn = false;
		}
	}

	// configura o Square atual
	private void setCurrentSquare(Square square) {
		currentSquare = square;
	}

	// classe interna privada para os quadrados dos tabuleiros
	private class Square extends JPanel {
		private String mark; // marca a ser desenhada no quadrado
		private int location; // posicao do quadrado

		public Square(String squareMark, int squareLocation) {
			mark = squareMark;
			location = squareLocation;

			addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					setCurrentSquare(Square.this); // configura o quadrado atual

					// envia a posicao desse quadrado
					sendClickedSquare(getSquareLocation());
				}
			});
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(30, 30);
		}

		@Override
		public Dimension getMinimumSize() {
			return super.getMinimumSize();
		}

		public void setMark(String newMark) {
			mark = newMark;
			repaint();
		}

		public int getSquareLocation() {
			return location;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(0, 0, 29, 29); // desenho do quadrado
			g.drawString(mark, 11, 20);
		}

	}

}
