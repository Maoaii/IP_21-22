/**
 * Contest class (System Class). Handles all the logic behind the contest, i.e., matching the
 * sequences and counting the correct guesses
 * 
 * @author Lucas Girotto
 */
public class Contest {
	// Constants
	private static final int CONSECUTIVE = 3;
	private static final int ISOLATED = 1;

	// Instance variables
	private Person layman;
	private Person telepath;
	private int score;
	private int correctGuesses;

	/**
	 * Contest Constructor
	 * 
	 * @param numbersL: layman's sequence of numbers
	 * @param numbersT: telepath's sequence of numbers
	 * @param length:   length of the sequences
	 * @pre numbersL != null && numbersT != null && length != null
	 */
	public Contest(int[] numbersL, int[] numbersT, int length) {
		layman = new Person(numbersL, length);
		telepath = new Person(numbersT, length);

		score = 0;
		correctGuesses = 0;
	}

	/**
	 * Runs the contest. The telepath tries to guess the layman's sequence of numbers. Gets 3 points
	 * for each consecutive guess and 1 point for isolated guesses
	 */
	public void runContest() {
		int[] laymanSeq = layman.getNumbers();
		int[] telepathSeq = telepath.getNumbers();
		int size = layman.getSize();

		// Loop through both both arrays and add up the score based on correct guesses
		for (int number = 0; number < size; number++) {

			// If it's a correct guess:
			if (laymanSeq[number] == telepathSeq[number]) {

				// If we're at the start of the array
				if (number == 0) {

					// Check only the right side
					if (laymanSeq[number + 1] != telepathSeq[number + 1])
						score += ISOLATED;
					else
						score += CONSECUTIVE;
				}

				// If we're at the end of the array
				else if (number == size - 1) {

					// Check only the left side
					if (laymanSeq[number - 1] != telepathSeq[number - 1])
						score += ISOLATED;
					else
						score += CONSECUTIVE;

				}

				// Else, we're at the "middle"
				else {

					// Check both left and right
					if (laymanSeq[number - 1] != telepathSeq[number - 1]
							&& laymanSeq[number + 1] != telepathSeq[number + 1])
						score += ISOLATED;
					else
						score += CONSECUTIVE;
				}
				correctGuesses++;
			}
		}
	}

	/**
	 * @return the telepath's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the amount of correct guesses from telepath
	 */
	public int getCorrectGuesses() {
		return correctGuesses;
	}
}
