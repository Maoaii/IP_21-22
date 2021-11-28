/**
 * @author lucas Handles the management of contacts and retrieval of information
 */
public class Contact_Book {

	// Constants
	private static final int DEFAULT_CAPACITY = 50;
	private static final int GROWTH_FACTOR = 2;
	private static final int NOT_FOUND = -1;

	// Instance variables
	private int size;
	private Contact[] contacts;

	// Constructor
	public Contact_Book() {
		size = 0;
		contacts = new Contact[DEFAULT_CAPACITY];
	}

	public Contact_Iterator iterator() {
		return new Contact_Iterator(contacts, size);
	}

	/**
	 * @param name
	 * @pre name != null
	 * @return true if contact's name is in contact book, false if it isn't
	 */
	public boolean hasContact(String name) {
		return searchIndex(name) != NOT_FOUND;
	}

	/**
	 * @return number of contacts in contact book
	 */
	public int getNumberOfContacts() {
		return contacts.length;
	}

	/**
	 * Adds a new contact to contact book
	 * 
	 * @param name
	 * @param phone_number
	 * @param email
	 * @pre name != null && phone_number != null && email != null
	 */
	public void addContact(String name, String phone_number, String email) {
		if (isFull())
			grow();
		contacts[size++] = new Contact(name, phone_number, email);
	}

	/**
	 * Deletes contact that has given name
	 * 
	 * @param name
	 * @pre name != null
	 */
	public void deleteContact(String name) {
		contacts[searchIndex(name)] = contacts[size - 1];
		size--;
	}

	/**
	 * Consults phone number associated with "name"
	 * 
	 * @param name
	 * @pre name != null
	 * @return phone number of contact with "name"
	 */
	public String getPhone(String name) {
		return contacts[searchIndex(name)].getPhoneNumber();
	}

	/**
	 * Consults email associated with "name"
	 * 
	 * @param name
	 * @pre name != null
	 * @return email of contact with "name"
	 */
	public String getEmail(String name) {
		return contacts[searchIndex(name)].getEmail();
	}

	/**
	 * Changes the phone number associated with "name"
	 * 
	 * @param name
	 * @param phone_number
	 * @pre name != null && phone_number != null
	 */
	public void setPhoneNumber(String name, String phone_number) {
		contacts[searchIndex(name)].setPhoneNumber(phone_number);
	}

	/**
	 * Changes the email associated with "name"
	 * 
	 * @param name
	 * @param email
	 * @pre name != null && email != null
	 */
	public void setEmail(String name, String email) {
		contacts[searchIndex(name)].setEmail(email);
	}

	/**
	 * Checks if contact book is full
	 * 
	 * @return true if it's full, false it it isn't
	 */
	public boolean isFull() {
		return contacts.length == size;
	}

	/**
	 * Grows the contact book if it's needed
	 */
	public void grow() {
		Contact[] tmp = new Contact[GROWTH_FACTOR * contacts.length];

		for (int i = 0; i < contacts.length; i++)
			tmp[i] = contacts[i];

		contacts = tmp;
	}

	/**
	 * Method that returns the index of the person's name in the array Contacts (contact book)
	 * 
	 * @param name
	 * @pre name != null
	 * @return
	 */
	private int searchIndex(String name) {

		int i = 0;

		while (i < size && !contacts[i].hasName(name))
			i++;

		if (i < size)
			return i;
		else
			return NOT_FOUND;
	}
}
