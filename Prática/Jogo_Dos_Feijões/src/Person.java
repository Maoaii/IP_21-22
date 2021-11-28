/**
 * @author Lucas Girotto
 * Person class
 * Holds all the information about a single person
 */
public class Person {
	// Instance variables
	private String name;
	private int beansCollected;

	/**
	 * Person Constructor
	 * 
	 * @param name: person's name
	 * @pre name != null
	 */
	public Person(String name) {
		this.name = name;
		beansCollected = 0;
	}

	/**
	 * Collects beans from a pile
	 * 
	 * @param beans: collected
	 * @pre beans != null
	 */
	public void gatherPile(int beans) {
		beansCollected += beans;
	}

	/**
	 * @return beans collected
	 */
	public int getBeansCollected() {
		return beansCollected;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
