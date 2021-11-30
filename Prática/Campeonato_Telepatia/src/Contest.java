/**
 * 
 * @author lucas
 *
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
	 * 
	 * @param numbersL
	 * @param numbersT
	 */
	public Contest(int[] numbersL, int[] numbersT, int length) {
		layman = new Person(numbersL, length);
		telepath = new Person(numbersT, length);

		score = 0;
		correctGuesses = 0;
	}

	/**
	 * 
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
					if (laymanSeq[number + 1] != telepathSeq[number + 1]) {
						score += ISOLATED;
					}
					else {
						score += CONSECUTIVE;
					}
				}
				// If we're at the end of the array
				else if (number == size - 1) {
					// Check only the left side
					if (laymanSeq[number - 1] != telepathSeq[number - 1]) {
						score += ISOLATED;
					}
					else {
						score += CONSECUTIVE;
					}
				}
				// Else, we're at the "middle"
				else {
					// Check both left and right
					if (laymanSeq[number - 1] != telepathSeq[number - 1] && laymanSeq[number + 1] != telepathSeq[number + 1]) {
						score += ISOLATED;
					}
					else if (laymanSeq[number - 1] == telepathSeq[number - 1] && laymanSeq[number + 1] != telepathSeq[number + 1]){
						score += CONSECUTIVE;
					}
					else if (laymanSeq[number - 1] != telepathSeq[number - 1] && laymanSeq[number + 1] == telepathSeq[number + 1]) {
						score += CONSECUTIVE;
					}
					else {
						score += CONSECUTIVE;
					}
				}
				correctGuesses++;
			}
		}
	}

	/**
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * 
	 * @return
	 */
	public int getCorrectGuesses() {
		return correctGuesses;
	}
}
