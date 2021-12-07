/**
 * Normal iterator for the collection of albums
 * 
 * @author Lucas Girotto
 */
public class CollectionIterator {
	// Instance variables
	private Album[] collection;
	private int size;
	private int nextIndex;

	/**
	 * Normal Iterator Constructor
	 * 
	 * @param collection: collection of arrays to be iterated over
	 * @param size:       size of the collection
	 * @pre collection != null && size != null
	 */
	public CollectionIterator(Album[] collection, int size) {
		this.collection = collection;
		this.size = size;
		nextIndex = 0;
	}

	/**
	 * @return true if there are more albums to iterate
	 */
	public boolean hasNext() {
		return nextIndex < size;
	}

	/**
	 * @return the next album to be iterated over
	 * @pre this.hasNext();
	 */
	public Album next() {
		return collection[nextIndex++];
	}
}
