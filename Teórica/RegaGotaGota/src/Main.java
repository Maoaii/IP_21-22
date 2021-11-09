import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Create two cultures
		WaterSystem ws = new WaterSystem(readName(sc), readInt(sc), readInt(sc), readName(sc), readInt(sc), readInt(sc));
		
		//Read number of watering samples. Pre: numSamples <= 300 && numSamples >= 1
		int numSamples = readInt(sc);
		
		//Read different samples
		for (int i = 0; i < numSamples; i++) {
			ws.registerDay(readName(sc));
		}
		
		//Output adequate days for both and which had the most "good" days
		System.out.printf("There are %d days for both.\n", ws.getNumDaysForBoth());
		if (ws.areCropsEquivalent())
			System.out.println(ws.getBestCropName());
		else
			System.out.printf("Choose %s.\n", ws.getBestCropName());
		
		
		sc.close();
	}
	
	private static String readName(Scanner sc) {
		String str = sc.next();
		sc.nextLine();
		return str;
	}
	
	private static int readInt(Scanner sc) {
		int nbr = sc.nextInt();
		sc.nextLine();
		return nbr;
	}
	
}
