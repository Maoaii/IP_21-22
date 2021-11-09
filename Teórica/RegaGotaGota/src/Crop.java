public class Crop {
	
	//Instance variables
	private String name;
	private int minCulture;
	private int maxCulture;
	
	//Constructor
	public Crop(String name, int minCulture, int maxCulture) {
		
		this.name = name;
		this.minCulture = minCulture;
		this.maxCulture = maxCulture;
	}
	
	public boolean isSuitable(int drops) {
		if (drops <= maxCulture && drops >= minCulture)
			return true;
		
		return false;
	}
	
	public String getName() {
		return name;
	}
}
