/**
 * @author Lucas Girotto
 * Plot class. 
 * Holds all the information regarding a single Plot, like the amount of treasure it has or if it has been dug up.
 */
public class Plot {
	
	//Constants
	private static final int MERIT_LOSS = 10;
	
	//Plot Instance variables
	private int treasure;
	private int meritLossMultiplier;
	private boolean dugUp;
	
	/**
	 * Plot Constructor
	 * @param treasure
	 * @pre treasure != null
	 */
	public Plot(int treasure) {
		this.treasure = treasure;
		dugUp = false;
		meritLossMultiplier = 1;
	}
	
	/**
	 * @return treasure value on this plot
	 */
	public int getTreasure() {
		return treasure;
	}
	
	/**
	 * Assigns new treasure value to this plot
	 * @param amount
	 */
	public void assignTreasure(int amount) {
		treasure = amount;
	}
	
	/**
	 * @return true if this plot has treasure, false if it does not
	 */
	public boolean hasTreasure() {
		if (treasure == 0)
			return false;
		
		return true;
	}
	
	/**
	 * When this plot is excavated, turn dugUp to true and remove its' treasure
	 */
	public void excavated() {
		dugUp = true;
		treasure = 0;
	}
	/**
	 * @return true if this plot has been dug up
	 */
	public boolean isDugUp() {
		return dugUp;
	}
	
	/**
	 * @return the amount of merit the arqueologist is going to loose
	 */
	public int meritLoss() {
		return MERIT_LOSS * meritLossMultiplier++;
	}
}
