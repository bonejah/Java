package challenges;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		TicTacToe game = new TicTacToe();
		
		game.printBoard();
		System.out.println("Player X enter your coordinates: ");
		String play = input.nextLine();
		game.markCoordinates(play);

		game.printBoard();
		System.out.println("Player O enter your coordinates: ");
		play = input.nextLine();
		game.markCoordinates(play);

		while (true) {
			game.printBoard();
			System.out.println("Player X enter your coordinates: ");
			play = input.nextLine();
			game.markCoordinates(play);
			
			if (game.isGameWon()) {
				System.out.println("Player X WIN!!!");
				input.close();
				System.exit(0);
			}

			game.printBoard();
			System.out.println("Player O enter your coordinates: ");
			play = input.nextLine();
			game.markCoordinates(play);

			if (game.isGameWon()) {
				System.out.println("Player O WIN!!!");
				input.close();
				System.exit(0);
			}
		}
	}
}

class TicTacToe {
	private char board[][] = { { 'N', 'N', 'N' }, { 'N', 'N', 'N' }, { 'N', 'N', 'N' } };
	private String boardExample[][] = { { "0 0", "0 1", "0 2" }, { "1 0", "1 1", "1 2" }, { "2 0", "2 1", "2 2" } };
	private char currentPlayer = 'X';

	public void printBoard() {

		System.out.println("Board Example:");
		for (int row = 0; row < boardExample.length; row++) {
			for (int col = 0; col < boardExample.length; col++) {
				if (col == 2) {
					System.out.println(" " + boardExample[row][col]);
					break;
				}
				
				System.out.printf(" %s, ", boardExample[row][col]);
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("YOUR BOARD:");
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (col == 2) {
					System.out.println(" " + board[row][col]);
					break;
				}
				
				System.out.printf(" %s, ", board[row][col]);
			}
		}
		
		System.out.println();
	}

	public boolean isBoardFull() {
		return false;
	}

	public boolean markCoordinates(String line) {
		String[] marks = line.split(" ");
		Integer rowInt = new Integer(marks[0]);
		Integer colInt = new Integer(marks[1]);

		if (board[rowInt][colInt] == 'N') {
			board[rowInt][colInt] = currentPlayer;
			
			if (currentPlayer == 'X') {
				currentPlayer = 'O';
			} else {
				currentPlayer = 'X';
			}
			return true;
		}

		return false;
	}

	public boolean isGameWon() {
		boolean rowsWon, colsWon, diagWon;
		rowsWon = colsWon = diagWon = false;

		for (int i = 0; i < board.length; i++) {
			
			if (board[0][i] != 'N' && board[1][i] != 'N' && board[2][i] != 'N') {
				// check rows
				if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) {
					rowsWon = true;
					break;
				}
			}
			
			if (board[i][0] != 'N' &&  board[i][1] != 'N' && board[i][2] != 'N') {
				// check cols
				if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) {
					colsWon = true;
					break;
				}
			}
		}
		
		// check diag
		if (board[0][0] != 'N' && board[1][1] != 'N' && board[2][2] != 'N') {
			if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) {
				diagWon = true;
			}
		}
		
		// check diag
		if (board[0][2] != 'N' && board[1][1] != 'N' && board[2][0] != 'N') {
			if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
				diagWon = true;
		}
		
//		return rowsWon && colsWon && diagWon;
		return rowsWon || colsWon || diagWon;
	}

}
