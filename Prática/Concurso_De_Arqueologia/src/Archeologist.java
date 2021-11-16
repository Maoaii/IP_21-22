/**
 * @author Lucas Girotto 
 * Archeologist Class. Holds all the info regarding a single Archeologist,
 * like its' name, position in a given moment, his merit and if his license is valid.
 */
public class Archeologist {

	// Constants
	private static final int STARTING_POSITION = -1; // "-1" because plots begin at "0"
	private static final int STARTING_MERIT = 0;

	// Archeologist Instance variables
	private String name;
	private int position;
	private int merit;
	private boolean license;

	/**
	 * Archeologist Constructor
	 * 
	 * @param name
	 * @pre name != null && name.length() > 0 && name.length() < 40
	 */
	public Archeologist(String name) {
		this.name = name;
		position = STARTING_POSITION;
		merit = STARTING_MERIT;
		license = true;
	}

	/**
	 * Updates Archeologists' position by "leap"
	 * 
	 * @param leap
	 * @pre leap != null
	 * @return new Archeologist position
	 */
	public int updatePosition(int leap) {
		position += leap;
		return position;
	}

	/**
	 * @return Archeologist's current position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Adds merit to the Archeologist that discovered the treasure
	 * 
	 * @param treasure
	 * @pre treasure != null
	 */
	public void addMerit(int treasure) {
		merit += treasure;
	}

	/**
	 * Removes merit from Archeologist and increments merit loss multiplier
	 * 
	 * @param meritLoss
	 * @pre meritLoss != null
	 */
	public void removeMerit(int meritLoss) {
		merit -= meritLoss;
	}

	/**
	 * @return Archeologist's merit
	 */
	public int getMerit() {
		return merit;
	}

	/**
	 * @return true if Archeologist has a license, false if he doesn't
	 */
	public boolean getLicense() {
		return license;
	}

	/**
	 * Removes Archeologists license and sets his merit to 0
	 */
	public void removeLicense() {
		license = false;
		merit = 0;
	}

	/**
	 * @return Archeologist's name
	 */
	public String getName() {
		return name;
	}

}