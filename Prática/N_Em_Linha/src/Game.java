/**
 * Game class. Handles the algorithm that checks wins or ties
 * 
 * @author Lucas Girotto
 */
public class Game {
	// Constants
	private static final int WIN = 1;
	private static final int COUNTER_RESET = 1;
	private static final char P1_CHAR = 'o';
	private static final char P2_CHAR = 'x';
	private static final int P1_ID = 1;
	private static final int P2_ID = -1;
	private static final int TIE_ID = 0;

	// Instance variables
	private char[][] board;
	private int n;

	/**
	 * Game constructor
	 * 
	 * @param board: board to play on
	 * @param n:     characters in line needed to win
	 * @pre board != null && n != null
	 * 
	 */
	public Game(char[][] board, int n) {
		this.board = board;

		this.n = n;
	}

	/**
	 * Plays the game given the board and checks if anyone won
	 * 
	 * @return an integer that identifies the player that won, or it it was a tie
	 */
	public int playGame() {
		int winP1 = 0;
		int winP2 = 0;
		int rows = board.length;
		int cols = board[0].length;

		// Check for a win on rows
		for (int row = 0; row < rows; row++) {
			int counter1 = COUNTER_RESET;
			for (int col = 0; col < cols - 1; col++) {

				// Check if an element matches the next one, incrementing or reseting the counter
				if (board[row][col] == board[row][col + 1])
					counter1++;
				else
					counter1 = COUNTER_RESET;

				// Assigns a win to the player that won
				if (counter1 == n) {
					if (board[row][col] == P1_CHAR)
						winP1 = WIN;
					else if (board[row][col] == P2_CHAR)
						winP2 = WIN;
				}
			}

		}

		// Check for a win on columns
		for (int col = 0; col < cols; col++) {
			int counter2 = COUNTER_RESET;

			// Check if an element matches the next one, incrementing or reseting the counter
			for (int row = 0; row < rows - 1; row++) {
				if (board[row][col] == board[row + 1][col])
					counter2++;
				else
					counter2 = COUNTER_RESET;

				// Assigns a win to the player that won
				if (counter2 == n) {
					if (board[row][col] == P1_CHAR)
						winP1 = WIN;
					else if (board[row][col] == P2_CHAR)
						winP2 = WIN;
				}
			}
		}
		
		// Check for ties or winners
		if (winP1 == winP2)
			return TIE_ID;
		else if (winP1 > winP2)
			return P1_ID;
		else
			return P2_ID;
	}
}
