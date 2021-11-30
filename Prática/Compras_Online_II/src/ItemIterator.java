/**
 * 
 * @author lucas
 *
 */
public class ItemIterator {
	// Instance variables
	private Item[] items;
	private int size;
	private int nextIndex;

	/**
	 * Iterator Constructor
	 * 
	 * @param items: items to be iterated over
	 * @param size:  size of shopping bag
	 * @pre items != null && size != null
	 */
	public ItemIterator(Item[] items, int size) {
		this.items = items;
		this.size = size;
		nextIndex = 0;
	}

	/**
	 * @return true if there's still items to check
	 */
	public boolean hasNext() {
		return nextIndex < size;
	}

	/**
	 * @return the next item to be checked
	 */
	public Item next() {
		return items[nextIndex++];
	}
}
