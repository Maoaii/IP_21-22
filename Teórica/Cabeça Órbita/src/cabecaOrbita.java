public class cabecaOrbita 
{
	//Instance variables
	static int orbits = 0;
	
	public static int getOrbit(int n)
	{
		if (n == 1)
		{
			return orbits;
		}
		if (n % 2 == 0)
		{
			orbits++;
			return getOrbit(n/2);
		}
		else
		{
			orbits++;
			return getOrbit(3*n + 1);
		}
	}
}
