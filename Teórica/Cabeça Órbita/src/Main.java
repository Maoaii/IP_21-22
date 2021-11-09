import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		//Pre: 1 <= n <= 100 000
		int n = sc.nextInt();
		
		System.out.println(n);
		System.out.println(cabecaOrbita.getOrbit(n));
		
		sc.close();
	}
}
