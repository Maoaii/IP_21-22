import java.util.Scanner;

/**
 * 
 * @author lucas
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int length = readInt(in);
		Contest c = new Contest(readNumbers(in, length), readNumbers(in, length), length);
		
		runContest(in, c);
		
		in.close();
	}
	
	/**
	 * 
	 * @param in
	 * @param c
	 */
	private static void runContest(Scanner in, Contest c) {
		c.runContest();
		System.out.println(c.getCorrectGuesses() + "\n" + c.getScore());
	}

	/**
	 * 
	 * @param in
	 * @param length
	 * @return
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
	 * 
	 * @param in
	 * @return
	 */
	private static int readInt(Scanner in) {
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}

}
