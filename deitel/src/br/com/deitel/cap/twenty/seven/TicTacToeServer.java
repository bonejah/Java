package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TicTacToeServer extends JFrame {
	private String[] board = new String[9]; // tabuleiro de jogo da velha
	private JTextArea outputArea; // para gerar saida das jogadas
	private Player[] players; // array de Players
	private ServerSocket server; // socket de servidor para conectar com
									// clientes
	private int currentPlayer; // monitora o jogardor com a jogada atual
	private final static int PLAYER_X = 0; // constante para o primeiro jogador
	private final static int PLAYER_O = 1; // constante para o segundo jogador
	private final static String[] MARKS = { "X", "O" }; // array de marcas
	private ExecutorService runGame; // executa os jogadores
	private Lock gameLock; // para bloquear a sincronizacao do jogo
	private Condition otherPlayerConnected; // para esperar outro jogador
	private Condition otherPlayerTurn; // para esperar a jogada do outro jogador

	// configura o servidor de tic-tac-toe e a GUI que exibe as mensagens
	public TicTacToeServer() {
		super("Tic-Tac-Toe-Server"); // configura o titulo da janela

		// cria ExecutorService com uma Thread para cada jogador
		runGame = Executors.newFixedThreadPool(2);
		gameLock = new ReentrantLock(); // cria um bloqueio para o jogo

		// variavel de condicao para os dois jogadores sendo conectados
		otherPlayerConnected = gameLock.newCondition();

		// variavel de condicao apra a jogada do outro jogador
		otherPlayerTurn = gameLock.newCondition();

		for (int i = 0; i < 9; i++) {
			board[i] = new String(""); // cria tabuleiro de jogo da velha
		}

		players = new Player[2]; // cria array de jogadores
		currentPlayer = PLAYER_X; // configura jogador atual como o primeiro
									// jogador

		try {
			server = new ServerSocket(12345, 2); // configura ServerSocket
		} catch (IOException ioException) {
			ioException.printStackTrace();
			System.exit(1);
		}

		outputArea = new JTextArea(); // cria JTextArea para saida
		add(outputArea, BorderLayout.CENTER);
		outputArea.setText("Server awaiting connections\n");
		setSize(300, 300);
		setVisible(true);
	}

	// espera duas conexoes para que o jogo possa ser jogador
	public void execute() {
		// espera que cada cliente se conecte
		for (int i = 0; i < players.length; i++) {
			try { // espera a conexao, cria Player, inicia o executavel!
				players[i] = new Player(server.accept(), i);
				runGame.execute(players[i]); // executa o executavel do jogador
			} catch (IOException ioException) {
				ioException.printStackTrace();
				System.exit(1);
			}
		}

		gameLock.lock(); // bloqueia o jogo para sinalizar a thread do jogador X

		try {
			players[PLAYER_X].setSuspend(false); // retoma o jogador X
			otherPlayerConnected.signal(); // acorda a thread do jogador X
		} finally {
			gameLock.unlock(); // desbloqueia o jogo depois de sinalizar para o
								// jogador X
		}
	}

	// exibe uma mensagem na outputArea
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				outputArea.append(messageToDisplay);
			}
		});
	}

	public boolean validateAndMove(int location, int player) {
		// enquanto nao for o jogador atual, deve esperar a jogada
		while (player != currentPlayer) {
			gameLock.lock(); // bloqueia o jogo para que o outro jogador
								// prossiga

			try {
				otherPlayerTurn.wait(); // espera a jogada do jogador
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			} finally {
				gameLock.unlock(); // desbloqueia o jogo depois de esperar
			}
		}

		// se a posicao nao estiver ocupada faz a jogada
		if (!isOccupied(location)) {
			board[location] = MARKS[currentPlayer]; // configura uma jogada no
													// tabuleiro
			currentPlayer = (currentPlayer + 1) % 2; // troca o jogador

			// depois que novo jogador atual saiba que a jogada ocorreu
			players[currentPlayer].otherPlayerMoved(location);

			gameLock.lock(); // bloqueia jogo para sinalizar ao outro jogador a
								// prosseguir

			try {
				otherPlayerTurn.signal(); // sinaliza que o outro jogador
											// continue
			} finally {
				gameLock.unlock(); // desbloqueia o jogo depois de sinalizar
			}

			return true;
		} else // a jogada nao foi valida
			return false;
	}

	public boolean isOccupied(int location) {
		if (board[location].equals(MARKS[PLAYER_X]) || board[location].equals(MARKS[PLAYER_O]))
			return true; // posicao esta ocupada
		else
			return false; // posicao nao esta ocupada
	}

	// fim de jogo
	public boolean isGameOver() {
		return false;
	}

	public class Player implements Runnable {
		private Socket connection; // conexao com o cliente
		private Scanner input; // entrada do cliente
		private Formatter output; // saida para o cliente
		private int playerNumber; // monitora qual é o jogador
		private String mark; // marca para esse jogador
		private boolean suspend = true; // se a thread esta suspensa

		public Player(Socket socket, int number) {
			playerNumber = number; // armazena o numero desse jogador
			mark = MARKS[playerNumber]; // especifica a marca do jogador
			connection = socket; // armazena o socket para o cliente

			try { // obtem os fluxos a partir do Socket
				input = new Scanner(connection.getInputStream());
				output = new Formatter(connection.getOutputStream());
			} catch (IOException ioException) {
				ioException.printStackTrace();
				System.exit(1);
			}
		}

		public void otherPlayerMoved(int location) {
			output.format("Opponent moved\n");
			output.format("%d\n", location); // envia a posicao da jogada
			output.flush(); // esvazia a saida
		}

		@Override
		public void run() {

			// envia ao cliente a marca (X ou O), processa as mensagens do
			// cliente
			try {
				displayMessage("Player " + mark + " connected\n");
				output.format("%s\n", mark);
				output.flush(); // esvazia a saida

				// se for o jogador X, espera que o outro jogador chegue
				if (playerNumber == PLAYER_X) {
					output.format("%s\n%s", "Player X connected", "Waiting for another player\n");
					output.flush(); // esvazia a saida
					gameLock.lock(); // bloqueia o jogo para esperar o segundo
										// jogador

					try {
						while (suspend) {
							otherPlayerConnected.await(); // espera o jogador O
						}
					} catch (InterruptedException exception) {
						exception.printStackTrace();
					} finally {
						gameLock.unlock(); // desbloqueia o jogo depois do
											// segundo jogador
					}

					output.format("Player O connected, please wait\n");
					output.flush();
				} else {
					output.format("Player O connected, please wait\n");
					output.flush();
				}

				// enquanto jogo nao terminou
				while (!isGameOver()) {
					int location = 0; // inicializa a posicao da jogada

					if (input.hasNext())
						location = input.nextInt(); // obtem posicao da jogada

					// verifica uma jogada valida
					if (validateAndMove(location, playerNumber)) {
						displayMessage("\nlocation: " + location);
						output.format("Valid move.\n");
						output.flush();
					} else {
						output.format("Invalid move, try again\n");
						output.flush();
					}
				}
			} finally {
				try {
					connection.close(); // fecha a conexao com o cliente
				} catch (IOException ioException) {
					ioException.printStackTrace();
					System.exit(1);
				}
			}
		}

		public void setSuspend(boolean status) {
			suspend = status;
		}
	}
}
