public class WaterSystem {
	
	//Instance variables
	private Crop crop1;
	private Crop crop2;
	private int daysForBoth;
	private int daysFor1;
	private int daysFor2;
	
	
	public WaterSystem(String name1, int min1, int max1, String name2, int min2, int max2) {
		crop1 = new Crop(name1, min1, max1);
		crop2 = new Crop(name2, min2, max2);
		daysForBoth = 0;
		daysFor1 = 0;
		daysFor2 = 0;
	}
	
	public boolean areCropsEquivalent() {
		if (daysFor1 == daysFor2)
			return true;
		return false;
	}
	
	public void registerDay(String day) {
		
		int drops = 0;
		
		for (int i = 0; i < day.length(); i++) {
			if (day.charAt(i) == '1')
				drops++;
		}
		if (crop1.isSuitable(drops) && crop2.isSuitable(drops))
			daysForBoth++;
		else if (crop1.isSuitable(drops))
			daysFor1++;
		else if (crop2.isSuitable(drops))
			daysFor2++;

	}
	
	
	public String getBestCropName() {
		if (daysFor1 > daysFor2)
			return crop1.getName();
		else if (daysFor1 < daysFor2) {
			return crop2.getName();
		}
		else
			return "They're equivalent.";
	}
	
	public int getNumDaysForBoth() {
		return daysForBoth;
	}
}
