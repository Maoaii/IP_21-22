/**
 * @author Lucas Girotto
 * Item class. 
 * Represents the item that is going to be bought. Holds a name and its' price
 */
public class Item {

	// Instance variables
	private String name;
	private int value;

	/**
	 * Constructor
	 * 
	 * @param name:  name for item
	 * @param value: value of item
	 * @pre name != null && value != null
	 */
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return item's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return item's value
	 */
	public int getValue() {
		return value;
	}
}