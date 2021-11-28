/**
 * 
 * @author lucas
 *
 */
public class Laboratory {
	//Constants
	private static final int GROWTH_FACTOR = 2;
	
	// Instance variables
	private Project[] projects;
	private int size;
	
	

	/**
	 * Lab Constructor
	 * @param projects: 
	 */
	public Laboratory(Project[] projects) {
		this.projects = projects;
		size = 0;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Project getProject(int id) {
		return projects[id];
	}
	
	/**
	 * 
	 */
	public void addProject() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ProjectIterator iterator() {
		return new ProjectIterator(projects, size);
	}
	
	/**
	 * Checks if Project array is full
	 * 
	 * @return true if it's full, false it it isn't
	 */
	public boolean isFull() {
		return projects.length == size;
	}

	/**
	 * Grows the Project array if it's needed
	 */
	public void grow() {
		Project[] tmp = new Project[GROWTH_FACTOR * projects.length];

		for (int i = 0; i < projects.length; i++)
			tmp[i] = projects[i];

		projects = tmp;
	}
}
