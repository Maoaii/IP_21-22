import java.util.Scanner;

/**
 * Main class. Handles all the input and output of information
 * 
 * @author Lucas Girotto
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int length = readInt(in); // Length of sequence of numbers
		Contest c = new Contest(readNumbers(in, length), readNumbers(in, length), length);

		runContest(in, c);

		in.close();
	}

	/**
	 * Sends the information to the system class to run the contest. Outputs the result
	 * 
	 * @param in: input reader
	 * @param c:  contest object
	 * @pre in != null && c != null
	 */
	private static void runContest(Scanner in, Contest c) {
		c.runContest();
		System.out.println(c.getCorrectGuesses() + "\n" + c.getScore());
	}

	/**
	 * Reads and stores the sequence of numbers
	 * 
	 * @param in:     input reader
	 * @param length: length of sequence of numbers
	 * @return the array of numbers
	 * @pre in != null && length != null
	 */
	private static int[] readNumbers(Scanner in, int length) {
		int[] tmp = new int[length];

		for (int i = 0; i < length; i++) {
			tmp[i] = in.nextInt();
		}

		in.nextLine();
		return tmp;
	}

	/**
	 * @param in: input reader
	 * @return an integer read
	 */
	private static int readInt(Scanner in) {
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}

}
