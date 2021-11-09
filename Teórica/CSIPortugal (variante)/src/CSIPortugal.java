public class CSIPortugal 
{
	//Constants
	private static final String HAS_ALIBI = "Com álibi.";
	private static final String NO_ALIBI = "Não tem álibi.";
	
	public static void testAlibi(int crimeStart, int crimeEnd, int alibiStart, int alibiEnd)
	{
		boolean test = crimeStart >= alibiStart && crimeEnd <= alibiEnd;

		if (test)
			System.out.println(HAS_ALIBI);
		else
		{
			System.out.println(NO_ALIBI);
			System.out.println(getHoursWithoutAlibi(crimeStart, crimeEnd, alibiStart, alibiEnd));
		}
			
	}

	public static int getHoursWithoutAlibi(int cS, int cE, int aS, int aE)
	{
		if (cS >= aS && cE >= aE &&  aE > cS)
			return cE - aE;
		else if (cS <= aS && cE <= aE && aS < cE)
			return aS - cS;
		else if (cS <= aS && cE >= aE)
			return aS - cS + cE - aE;
		else
			return cE - cS;
	}
}