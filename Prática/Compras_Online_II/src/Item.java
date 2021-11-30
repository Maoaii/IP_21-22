/**
 * @author Lucas Girotto Item class. Represents the item that is going to be bought. Holds a name
 *         and its' price
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

	/**
	 * 
	 * @param other
	 * @return positive int if price of this item is higher or it has the same price but comes first
	 *         in the alphabet
	 */
	public int compareTo(Item other) {
		Integer a = value;
		if (a.compareTo(other.getValue()) == 0)
			return other.getName().compareTo(name);
		else
			return a.compareTo(other.getValue());
	}
}