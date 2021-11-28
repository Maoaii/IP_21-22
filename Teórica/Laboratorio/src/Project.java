/**
 * 
 * @author lucas
 */
public class Project {
	// Instance variables
	private int id;
	private String description;
	private Researcher headResearcher;
	private int amountResearchers;
	private Researcher[] researchers;
	private int size;

	/**
	 * 
	 * @param id
	 * @param description
	 * @param emailHead
	 * @param amountResearchers
	 */
	public Project(int id, String description, Researcher headResearcher, int amountResearchers) {
		this.id = id;
		this.description = description;
		this.headResearcher = headResearcher;
		this.amountResearchers = amountResearchers;
		size = 0;
	}

	/**
	 * @return project's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return project's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return head researcher email
	 */
	public Researcher getEmailHead() {
		return headResearcher;
	}
	
	/**
	 * @return true if there is still space for researchers
	 */
	public boolean canAdd() {
		return amountResearchers >= size;
	}
	/**
	 * 
	 */
	public void addResearcher(Researcher researcher) {
		if (canAdd()) {
			int i=size-1;
				
			while (i >= 0 && researcher.compareTo(researchers[i]) < 0 && !isFull()){
				researchers[i+1] = researchers[i];
			i--;
			}
			
			researchers[size++] = researcher;
			size++;
			}
		}

	/**
	 * 
	 */
	public void removeResearcher(String email) {
		Researcher[] tmp = new Researcher[size];
		int j = 0;
		
		for (int i = 0; i < size; i++) {
			if (researchers[i].getEmail().equals(email)) {
				tmp[j] = researchers[i];
				j++;
			}
		}
		researchers = tmp;
		size--;
	}

	/**
	 * 
	 */
	public void orderProjects() {

	}
	
	/**
	 * 
	 * @return true if there's max amount of researchers on project
	 */
	public boolean isFull() {
		return researchers.length >= amountResearchers;
	}
}
