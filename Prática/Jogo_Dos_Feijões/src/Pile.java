/**
 * @author Lucas Girotto 
 * Pile object Class
 * Holds all the information of each pile of beans
 */
public class Pile {

	// Instance variables
	private int beans;

	/**
	 * Pile of beans Constructor
	 * 
	 * @param beans: beans on the pile
	 * @pre beans != null && beans >= 1 && beans <= 200
	 */
	public Pile(int beans) {
		this.beans = beans;
	}

	/**
	 * @return amount of beans on pile
	 */
	public int getBeans() {
		return beans;
	}

	/**
	 * Removes beans from pile
	 */
	public void removeBeans() {
		beans = 0;
	}
}
