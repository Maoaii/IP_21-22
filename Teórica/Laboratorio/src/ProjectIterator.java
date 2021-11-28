/**
 * 
 * @author lucas
 *
 */
public class ProjectIterator {
	//Instance variables
	private Project[] projects;
	private int size;
	private int nextIndex;
	
	/**
	 * 
	 * @param projects
	 * @param size
	 */
	public ProjectIterator(Project[] projects, int size) {
		this.projects = projects;
		this.size = size;
		nextIndex = 0;
	}
	
	/**
	 * @return
	 */
	public boolean hasNext() {
		return nextIndex < size;
	}
	
	/** 
	 * @return
	 */
	public Project next() {
		return projects[nextIndex++];
	}
}
