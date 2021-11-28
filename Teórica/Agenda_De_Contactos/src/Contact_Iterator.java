/**
 * @author lucas
 *
 */
public class Contact_Iterator {
	// Instance variables
	private Contact[] contacts; // Contacts array
	private int size; // Number of contacts in array
	private int nextIndex; // Index of next contact

	/**
	 * Iterator Constructor
	 * 
	 * @param contacts
	 * @param size
	 */
	public Contact_Iterator(Contact[] contacts, int size) {
		this.contacts = contacts;
		this.size = size;
		nextIndex = 0;
	}

	/**
	 * @return true if there are more contacts to iterate
	 */
	public boolean hasNext() {
		return nextIndex < size;
	}

	/**
	 * @pre hasNext();
	 */
	public Contact next() {
		return contacts[nextIndex++];
	}
}
