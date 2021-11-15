/**
 * @author Lucas Girotto
 * System class that handles the global management of Plots and Arqueologists and receives input from main
 */
public class Contest_Manager {

	//Instance variables
		//Arqueologists
	private Arqueologist arq1;
	private Arqueologist arq2;
		
		//Plots
	private int size;
	private Plot[] plots;
	
	/**
	 * Contest constructor
	 * @param name1
	 * @param name2
	 * @param amountOfPlots
	 * @pre name1 != null && name2 != null && amountOfPlots != null
	 */
	public Contest_Manager(String name1, String name2, int amountOfPlots) {
		
		//Create two arqueologists
		arq1 = new Arqueologist(name1);
		arq2 = new Arqueologist(name2);
		
		//Create new terrain with "amountOfPlots"
		size = amountOfPlots;
		plots = new Plot[amountOfPlots];
	}
	
	/**
	 * Populates "plot" with "treasure"
	 * @param treasure
	 * @param plot
	 * @pre treasure != null && plot != null
	 */
	public void populatePlots(int treasure, int plot) {
		plots[plot] = new Plot(treasure);
	}
	
	/**
	 * Prints out the plots on the screen, showing which ones have treasure (*) or not (-)
	 * @return a string with "*" or "-", representing the terrain with its' treasures
	 */
	public String printTerrain() {
		
		String terrain = "";
		
		//Loop through all the plots and check if they have treasure. 
		//If they do, add "*" to string, otherwise, "-".
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
	 * Returns the merit of "name" arqueologist
	 * @param name
	 * @pre name != null
	 * @return merit associated with arqueologist "name"
	 */
	public int computeArqMerit(String name) {
		if (arq1.getName().equals(name))
			return arq1.getMerit();
		else
			return arq2.getMerit();
	}
	
	/**
	 * Computes an excavation, depending on the arqueologist
	 * @param leap
	 * @param name
	 * @pre leap != null && name != null
	 */
	public void computeExcavation(int leap, String name) {
		if (arq1.getName().equals(name)) {
			excavatePlot(leap, arq1);
		}
		else {
			excavatePlot(leap, arq2);
		}
	}
	
	/**
	 * Handles the updating of a plot and arqueologist's info when
	 * a plot is excavated, i.e., arq merit, plot treasure
	 * @param leap
	 * @param arq
	 * @pre leap != null && arq != null
	 */
	public void excavatePlot(int leap, Arqueologist arq) {
		
		//Update arqueologist position
		arq.updatePosition(leap);
		
		//Add treasure to arqueologist merit
		Plot plot = plots[arq.getPosition()];
		arq.addMerit(plot.getTreasure());
		
		//Remove merit from arqueologist if that plot has already been dug up
		if (plot.isDugUp())
			arq.removeMerit(plot.meritLoss());
		
		//Update plot's treasure and make it dug up
		plot.excavated();
	}
	
	/**
	 * @return the number of plots in the contest
	 */
	public int getNumberOfPlots() {
		return size;
	}
	
	/**
	 * @return false if both arqueologists have lost their license,
	 * true if atleast one still has it
	 */
	public boolean bothHaveLicense() {
		return arq1.getLicense() || arq2.getLicense();
	}
	
	/**
	 * Checks to see if "name" arqueologist is taking part in the contest
	 * @param name
	 * @pre name != null
	 * @return true if "name" corresponds to an arqueologist, false if it doesn't
	 */
	public boolean checkArqExists(String name) {
		return arq1.getName().equals(name) || arq2.getName().equals(name);
	}
	
	/**
	 * Checks to see if "name" arqueologist still has his license
	 * @param name
	 * @pre name != null
	 * @return true if the arqueologist still has a license, false if he doesn't
	 */
	public boolean checkArqLicense(String name) {
		if (arq1.getName().equals(name))
			return arq1.getLicense();
		else
			return arq2.getLicense();
	}
	
	/**
	 * Checks to see if an arqueologists leap is out of bounds
	 * @param name
	 * @pre leap != null && name != null
	 * @return true if arqueologist's leap lands inside the contest terrain, 
	 * false if it doesn't
	 */
	public boolean isOutOfBounds(int leap, String name) {
		if (arq1.getName().equals(name))
			return (arq1.getPosition() + leap) < 0 || (arq1.getPosition() + leap) >= size;
		else
			return (arq2.getPosition() + leap) < 0 || (arq2.getPosition() + leap) >= size;
	}
	
	/**
	 * Removes an arqueologist's license
	 * @param name
	 * @pre name != null
	 */
	public void removeLicense(String name) {
		if (arq1.getName().equals(name))
			arq1.removeLicense();
		else
			arq2.removeLicense();
	}
}
