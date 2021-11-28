/**
 * @author Lucas Girotto 
 * BeanGame manager 
 * Deals with all the logic behind a game of beans
 *
 */
public class BeanGame {

	// Instance variables
	private int size;
	private Pile[] piles;
	private Person alex;
	private Person bela;

	/**
	 * Game Constructor
	 * 
	 * @param numberOfPiles: piles to be creates
	 * @pre numberOfPile != null && numberOfPile >= 2 && numberOfPile <= 100
	 */
	public BeanGame(int numberOfPiles) {
		piles = new Pile[numberOfPiles];
		size = numberOfPiles;

		alex = new Person("Alex");
		bela = new Person("Bela");
	}

	/**
	 * Handles all the logic behind the game loop, like who plays in what round and their strategy
	 * for playing
	 */
	public void gameLoop() {

		int firstPile = 0;
		int lastPile = size - 1;
		int belaRounds = 1;

		for (int round = 0; round < size; round++) {
			// Alex rounds
			if (round % 2 == 0) {
				// Gather biggest pile
				if (piles[firstPile].getBeans() > piles[lastPile].getBeans()) {
					alex.gatherPile(piles[firstPile].getBeans());
					firstPile++;
				} else {
					alex.gatherPile(piles[lastPile].getBeans());
					lastPile--;
				}
			}
			// Bela rounds
			else {
				// If it's a pair round for bela, take biggest pile
				if (belaRounds % 2 == 0) {
					if (piles[firstPile].getBeans() > piles[lastPile].getBeans()) {
						bela.gatherPile(piles[firstPile].getBeans());
						firstPile++;
					} else {
						bela.gatherPile(piles[lastPile].getBeans());
						lastPile--;
					}
				}
				// If it's a for bela, take smallest pile
				else {
					if (piles[firstPile].getBeans() > piles[lastPile].getBeans()) {
						bela.gatherPile(piles[lastPile].getBeans());
						lastPile--;
					} else {
						bela.gatherPile(piles[firstPile].getBeans());
						firstPile++;
					}
				}
				// Advance a round made for bela
				belaRounds++;
			}

		}
	}

	/**
	 * Populates piles with beans
	 * 
	 * @param beansAmount: beans for pile
	 * @param pile:        to be assigned beans
	 * @pre beansAmount != null && pile != null && beansAmount <= 200 && beansAmount >= 1
	 */
	public void populatePiles(int beansAmount, int pile) {
		piles[pile] = new Pile(beansAmount);
	}

	/**
	 * @return true if bela won
	 */
	public boolean belaWon() {
		return bela.getBeansCollected() > alex.getBeansCollected();
	}

	/**
	 * @return true if alex won
	 */
	public boolean alexWon() {
		return bela.getBeansCollected() < alex.getBeansCollected();
	}

	/**
	 * @return beans bela collected
	 */
	public int getBelaBeans() {
		return bela.getBeansCollected();
	}

	/**
	 * @return beans alex collected
	 */
	public int getAlexBeans() {
		return alex.getBeansCollected();
	}

	/**
	 * @return amount of piles
	 */
	public int getSize() {
		return size;
	}

}
