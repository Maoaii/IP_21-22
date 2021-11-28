import java.util.Scanner;
/**
 * @author Lucas Girotto
 * Main class
 * Deals with input, output, and sending info to BeanGame manager
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		BeanGame game = new BeanGame(getInt(in));
		
		populatePiles(in, game);
		
		playGame(game);
		
		whoWon(game);
		
		in.close();
	}
	
	/**
	 * Populates the bean piles
	 * @param in: input reader
	 * @param game: game manager
	 * @pre in != null && game != null
	 */
	private static void populatePiles(Scanner in, BeanGame game) {
		for (int pile = 0; pile < game.getSize(); pile++) {
			game.populatePiles(in.nextInt(), pile);
		}
		
	}
	
	/**
	 * Starts the game loop
	 * @param game: game manager
	 * @pre game != null
	 */
	private static void playGame(BeanGame game) {
		game.gameLoop();
	}
	
	/**
	 * See's who won the game
	 * @param game: game manager
	 * @pre game != null
	 */
	private static void whoWon(BeanGame game) {
		if (game.belaWon())
			System.out.printf("Bela ganha com %d contra %d\n", game.getBelaBeans(), game.getAlexBeans());
		else if (game.alexWon())
			System.out.printf("Alex ganha com %d contra %d\n", game.getAlexBeans(), game.getBelaBeans());
		else
			System.out.printf("Alex e Bela empatam a %d\n", game.getBelaBeans());
	}
	
	/**
	 * @param in: input reader
	 * @pre in != null 
	 * @return integer read
	 */
	private static int getInt(Scanner in) {
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}
}
