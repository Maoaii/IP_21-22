/**
 * @author Lucas Girotto
 * Arqueologist Class
 * Holds all the info regarding a single Arqueologist,
 * like its' name, position in a given moment, his merit and if his license is valid.
 */
public class Arqueologist {
	
	//Constants
	private static final int STARTING_POSITION = -1;	//"-1" because plots begin at "0"
	private static final int STARTING_MERIT = 0;

	//Arqueologist Instance variables
	private String name;
	private int position;
	private int merit;
	private boolean license;
	
	/**
	 * Arqueologist Constructor
	 * @param name
	 * @pre name != null
	 */
	public Arqueologist(String name) {
		this.name = name;
		position = STARTING_POSITION;
		merit = STARTING_MERIT;
		license = true;
	}
	
	/**
	 * @return arqueologist's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return arqueologist's merit
	 */
	public int getMerit() {
		return merit;
	}
	
	/**
	 * @return true if arqueologist has a license, false if he doesn't
	 */
	public boolean getLicense() {
		return license;
	}
	
	/**
	 * Removes arqueologists license and sets its' merit to 0
	 */
	public void removeLicense() {
		license = false;
		merit = 0;
	}
	
	/**
	 * Adds merit to the arqueologist that discovered the treasure
	 * @param treasure
	 * @pre treasure != null
	 */
	public void addMerit(int treasure) {
		merit += treasure;
	}
	
	/**
	 * Removes merit from arqueologist and increments merit loss multiplier
	 */
	public void removeMerit(int meritLoss) {
		merit -= meritLoss;
	}
	
	/**
	 * Updates arqueologists' position by "leap"
	 * @param leap
	 * @pre leap != null
	 * @return new position
	 */
	public int updatePosition(int leap) {
		position += leap; 
		return position;
	}
	
	/**
	 * @return arqueologist's current position
	 */
	public int getPosition() {
		return position;
	}
}