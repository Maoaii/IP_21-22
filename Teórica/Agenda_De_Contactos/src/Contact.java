/**
 * @author lucas
 * Handles each contact's information
 */
public class Contact {
	
	//Instance variables
	private String name, phone_number, email;
	
	/**
	 * 
	 * @param name
	 * @param phone_number
	 * @param email
	 * @pre name != null && phone_number != null && email != null
	 */
	public Contact(String name, String phone_number, String email) {
		this.name = name;
		this.phone_number = phone_number;
		this.email = email;
	}
	
	//Methods
	
	/**
	 * @return contact's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return contact's phone number
	 */
	public String getPhoneNumber() {
		return phone_number;
	}
	
	/**
	 * @return contact's email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Changes contact's phone number
	 * @param phone
	 * @pre phone != null
	 */
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
		return;
	}
	
	/**
	 * Changes contact's email
	 * @param email
	 * @pre email != null
	 */
	public void setEmail(String email) {
		this.email = email;
		return;
	}
	
	/**
	 * Checks if this contact has "name"
	 * @param name
	 * @pre name != null
	 * @return true if contact has "name"
	 */
	public boolean hasName(String name) {
		return this.name.equals(name);
	}
}
