/**
 * @author Lucas Girotto 
 * System class that handles the global management of Plots and Archeologists
 * and receives input from main
 */
public class Contest_Manager {

	// Instance variables
	// Archeologists
	private Archeologist arch1;
	private Archeologist arch2;

	// Plots
	private int size;
	private Plot[] plots;

	/**
	 * Contest constructor
	 * 
	 * @param name1
	 * @param name2
	 * @param amountOfPlots
	 * @pre name1 != null && name2 != null && amountOfPlots != null
	 */
	public Contest_Manager(String name1, String name2, int amountOfPlots) {

		// Create two Archeologists
		arch1 = new Archeologist(name1);
		arch2 = new Archeologist(name2);

		// Create new terrain with "amountOfPlots"
		size = amountOfPlots;
		plots = new Plot[amountOfPlots];
	}

	/**
	 * Populates "plot" with "treasure"
	 * 
	 * @param treasure
	 * @param plot
	 * @pre treasure != null && plot != null
	 */
	public void populatePlots(int treasure, int plot) {
		plots[plot] = new Plot(treasure);
	}

	/**
	 * Prints out the plots on the screen, showing which ones have treasure (*) or not (-)
	 * 
	 * @return a string with "*" or "-", representing the terrain with its' treasures
	 */
	public String printTerrain() {

		String terrain = "";

		// Loop through all the plots and check if they have treasure.
		// If they do, add "*" to string, otherwise, "-".
		for (int i = 0; i < size; i++) {
			if (plots[i].hasTreasure())
				terrain += "*";
			else
				terrain += "-";
		}

		return terrain;
	}

	/**
	 * Loops through the plots and adds up all the treasures
	 * 
	 * @return the sum of the treasures on all plots
	 */
	public int computeRichness() {

		int richness = 0;

		for (int i = 0; i < size; i++) {
			richness += plots[i].getTreasure();
		}

		return richness;
	}

	/**
	 * Returns the merit of "name" Archeologist
	 * 
	 * @param name
	 * @pre name != null
	 * @return merit associated with Archeologist "name"
	 */
	public int computeArchMerit(String name) {
		if (arch1.getName().equals(name))
			return arch1.getMerit();
		else
			return arch2.getMerit();
	}

	/**
	 * Computes an excavation, depending on the Archeologist
	 * 
	 * @param leap
	 * @param name
	 * @pre leap != null && name != null
	 */
	public void computeExcavation(int leap, String name) {
		if (arch1.getName().equals(name))
			excavatePlot(leap, arch1);
		else
			excavatePlot(leap, arch2);
	}

	/**
	 * Handles the updating of a plot and Archeologist's info when a plot is excavated, i.e., arch
	 * merit, plot treasure
	 * 
	 * @param leap
	 * @param arch
	 * @pre leap != null && arch != null
	 */
	public void excavatePlot(int leap, Archeologist arch) {

		// Update Archeologist position
		arch.updatePosition(leap);

		// Add treasure to Archeologist merit
		Plot plot = plots[arch.getPosition()];
		arch.addMerit(plot.getTreasure());

		// Remove merit from Archeologist if that plot has already been dug up
		if (plot.isDugUp())
			arch.removeMerit(plot.meritLoss());

		// Update plot's treasure and make it dug up
		plot.excavated();
	}

	/**
	 * @return the number of plots in the contest
	 */
	public int getNumberOfPlots() {
		return size;
	}

	/**
	 * @return false if both Archeologists have lost their license, true if atleast one still has it
	 */
	public boolean bothHaveLicense() {
		return arch1.getLicense() || arch2.getLicense();
	}

	/**
	 * Checks to see if "name" Archeologist is taking part in the contest
	 * 
	 * @param name
	 * @pre name != null
	 * @return true if "name" corresponds to an Archeologist, false if it doesn't
	 */
	public boolean checkArchExists(String name) {
		return arch1.getName().equals(name) || arch2.getName().equals(name);
	}

	/**
	 * Checks to see if "name" Archeologist still has his license
	 * 
	 * @param name
	 * @pre name != null
	 * @return true if the Archeologist still has a license, false if he doesn't
	 */
	public boolean checkArchLicense(String name) {
		if (arch1.getName().equals(name))
			return arch1.getLicense();
		else
			return arch2.getLicense();
	}

	/**
	 * Checks to see if an Archeologists leap is out of bounds
	 * 
	 * @param name
	 * @pre leap != null && name != null
	 * @return true if Archeologist's leap lands inside the contest terrain, false if it doesn't
	 */
	public boolean isOutOfBounds(int leap, String name) {
		if (arch1.getName().equals(name))
			return (arch1.getPosition() + leap) < 0 || (arch1.getPosition() + leap) >= size;
		else
			return (arch2.getPosition() + leap) < 0 || (arch2.getPosition() + leap) >= size;
	}

	/**
	 * Removes an Archeologist's license
	 * 
	 * @param name
	 * @pre name != null
	 */
	public void removeLicense(String name) {
		if (arch1.getName().equals(name))
			arch1.removeLicense();
		else
			arch2.removeLicense();
	}
}
