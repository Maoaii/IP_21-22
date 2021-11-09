import java.util.Scanner;

public class Main 
{
	//Constants
	private static final int SCENARIO_MIN = 1;
	private static final int SCENARIO_MAX = 100;


	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		//Input: 
		//First line, number of scenarios.
		int scenarios = getScenarios(sc, "Choose number of scenarios from 1 to 100: ");
		
		//Loop over the amount of scenarios
		if (scenarios > SCENARIO_MAX || scenarios < SCENARIO_MIN)
			System.out.println("Scenarios number from 1 to 100.\n");
		else
		{	
			for (int i = 1; i <= scenarios; i++)
			{
				
				int crimeStart = sc.nextInt();
				int crimeEnd = sc.nextInt();
				sc.nextLine();
				int alibiStart = sc.nextInt();
				int alibiEnd = sc.nextInt();
				
				CSIPortugal.testAlibi(crimeStart, crimeEnd, alibiStart, alibiEnd);
				
			}
		}
		
		sc.close();
	}
	
	private static int getScenarios(Scanner sc, String msg)
	{
		System.out.println(msg);
		int i = sc.nextInt();
		sc.nextLine();
		return i;
	}

}
