public class CSIPortugal 
{
	//Constants
	private static final String HAS_ALIBI = "Com �libi.";
	private static final String NO_ALIBI = "N�o tem �libi.";
	
	public static void testAlibi(int crimeStart, int crimeEnd, int alibiStart, int alibiEnd)
	{
		boolean test = crimeStart >= alibiStart && crimeEnd <= alibiEnd;

		if (test)
			System.out.println(HAS_ALIBI);
		else
			System.out.println(NO_ALIBI);
			
	}
}
