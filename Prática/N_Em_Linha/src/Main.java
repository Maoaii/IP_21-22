import java.io.*;
import java.util.Scanner;

/**
 * Main class. Handles all the input and output of messages
 * 
 * @author Lucas Girotto
 */
public class Main {
	// Constants
	private static final int TIE = 0;
	private static final int P1 = 1;
	private static final int P2 = -1;
	private static final String TIE_MESSAGE = "Jogo %s: empate\n";
	private static final String P1_MESSAGE = "Jogo %s: ganhou o jogador 1\n";
	private static final String P2_MESSAGE = "Jogo %s: ganhou o jogador 2\n";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		Scanner file = new Scanner(new FileReader(in.nextLine()));

		int NumBoards = file.nextInt();
		file.nextLine();

		for (int i = 0; i < NumBoards; i++) {
			int rows = file.nextInt();
			int cols = file.nextInt();
			int n = file.nextInt();
			file.nextLine();

			char[][] board = createBoard(file, rows, cols, n);

			Game game = new Game(board, n);
			printWinner(game.playGame(), i);

		}

		in.close();
		file.close();
	}

	/**
	 * Creates and returns the board
	 * 
	 * @param file: file reader
	 * @param rows: rows for the board
	 * @param cols: columns for the board
	 * @param n:    characters in line needed for a win
	 * @pre file != null && rows != null && cols != null && n != null
	 * @return a board with all the characters in place
	 */
	private static char[][] createBoard(Scanner file, int rows, int cols, int n) {
		char[][] tmpBoard = new char[rows][cols];

		for (int r = 0; r < rows; r++) {

			String line = file.nextLine();

			for (int c = 0; c < cols; c++) {

				tmpBoard[r][c] = line.charAt(c);
			}
		}
		return tmpBoard;
	}

	/**
	 * Prints out in the console who won the game
	 * 
	 * @param winner: player that won
	 * @param game:   current game
	 * @pre winner != null && game != null
	 */
	private static void printWinner(int winner, int game) {
		if (winner == TIE)
			System.out.printf(TIE_MESSAGE, game + 1);
		else if (winner == P1)
			System.out.printf(P1_MESSAGE, game + 1);
		else if (winner == P2)
			System.out.printf(P2_MESSAGE, game + 1);
	}
}
