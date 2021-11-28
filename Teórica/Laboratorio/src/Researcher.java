/**
 * 
 * @author lucas
 *
 */
public class Researcher {
	// Instance variables
	private String email;

	/**
	 * 
	 * @param email
	 */
	public Researcher(String email) {
		this.email = email;
	}

	/**
	 * @return researcher's email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public int compareTo(Researcher other) {
		return email.compareTo(other.getEmail());
	}
}
