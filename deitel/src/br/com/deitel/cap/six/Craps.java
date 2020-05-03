package br.com.deitel.cap.six;

import java.util.Random;

public class Craps {
	// cria gerador de numeros aleatorios para uso no metodo rollDice
	private static final Random randomNumbers = new Random();

	// enumeracao com constantes que representam o status do jogo
	private enum Status {
		CONTINUE, WON, LOST
	};

	// constantes que representam lancamentos comuns dos dados
	private static final int SNAKE_EYES = 1;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_ELEVEN = 11;
	private static final int BOX_CARDS = 12;

	// joga uma partida de craps
	public void play() {
		int myPoint = 0; // pontos se nao ganhar ou perder na rolagem.
		Status gameStatus; // pode conter CONTINUE, WON ou LOST
		int sumOfDice = rollDice(); // primeira rolagem dos dados

		switch (sumOfDice) {
		case SEVEN: // ganha com 7 no primeiro lancamento
		case YO_ELEVEN:
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES: // perde com 2 no primeiro lancamento
		case TREY: // perde com 3 no primeiro lancamento
		case BOX_CARDS: // perde com 12 no primeiro lancamento
			gameStatus = Status.LOST;
			break;
		default: // nao ganhou nem perdeu, entao registra pontuacao
			gameStatus = Status.CONTINUE; // jogo nao terminou
			myPoint = sumOfDice; // informa a pontuacao
			System.out.printf("Point is %d\n", myPoint);
			break;
		}

		// enquanto o jogo nao estiver completo
		while (gameStatus == Status.CONTINUE) {
			sumOfDice = rollDice(); // lanca os dados novamente

			// determina o status do jogo
			if (sumOfDice == myPoint) // vitoria por pontuacao
				gameStatus = Status.WON;
			else if (sumOfDice == SEVEN) // perde obtendo 7 antes de atingir a
											// pontuacao
				gameStatus = Status.LOST;
		}

		if (gameStatus == Status.WON)
			System.out.println("Player wins");
		else
			System.out.println("Player loses");
	}

	public int rollDice() {
		// seleciona valores aleatorios dos dados
		int die1 = 1 + randomNumbers.nextInt(6); // Primeiro lancamento do dado
		int die2 = 1 + randomNumbers.nextInt(6); // Segundo lancamento do dado
		int sum = die1 + die2; // soma os valores dos dados

		System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);

		return sum;
	}
}
