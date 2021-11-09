import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	
		int crimeStart = sc.nextInt();
		int crimeEnd = sc.nextInt();
		sc.nextLine();
		int alibiStart = sc.nextInt();
		int alibiEnd = sc.nextInt();
				
		CSIPortugal.testAlibi(crimeStart, crimeEnd, alibiStart, alibiEnd);

		sc.close();
	}
}

