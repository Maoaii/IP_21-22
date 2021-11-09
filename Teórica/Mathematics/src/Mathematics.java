public class Mathematics 
{
	//Check if number is a prime
	public static boolean isPrime(int n)
	{
		//Pre: n >= 1
		int test = 2;
		double limit = Math.sqrt(n);
		if (n > 1)
		{
			while (test < limit && n % test != 0)
			{
				test++;
			}	
		}
		
		return test > limit && n > 1;
	}
	
	//Check if number is a perfect number. Pre: n > 0
	public static boolean isPerfectNumber(int n)
	{
		if (n <= 0)
			return false;
		
		int sumDivisers = 0;
		
		for (int i = 1; i < n-1; i++)
		{
			if (n % i == 0)
				sumDivisers = sumDivisers + i; 
			
		}
		
		return sumDivisers == n;
	}
	
	//Calculates a factorial with recursion. Pre: n >= 0
	public static int factorialRec(int n)
	{	
		if (n == 1)
			return 1;
		else
			return n * factorialRec(n - 1);
	}
	
	/*
	Calculates a factorial with iteration. Pre: n >= 0
	public static int factorialIte(int n)
	{
		int fact = 1;
		for (int i = n; i > 0; i--)
		{
			fact = fact * i;
		}
		return fact;
	}
	*/
	
	//Find gcd of two numbers
	//Pre: a >= 0 && b >= 0 && (a != 0 || b != 0)
	public static int gcdRec(int a, int b)
	{
		if (b == 0)
			return a;
		return gcdRec(b, a % b);
	}
	
	//Calculate the sum of squares of n with recursion. Pre: n >= 1
	public static int sumOfSquaresRec(int n)
	{
		if (n == 1)
			return 1;
		else if (n == 0)
			return 0;
		else
			return sumOfSquaresRec(n - 1) + n*n;
	}
	/*
	//Calculate the sum of squares of n with iteration. Pre: n >= 1
	public static int sumOfSquaresIte(int n)
	{
		int sum = 0;
		for (int i = 0; i <= n; i++)
			sum = sum + i*i;
		
		return sum;
	}
	*/
	
	//Sum of 1/2^i converges to 1
	public static void convergeToOne()
	{
		double sum = 0.0;
		
		for (int i = 1; i <= 33; i++)
		{
			int j = i;
			while (j > 1)
			{
				sum = sum + 1/Math.pow(2, i);
				j--;
			}
			System.out.printf("Sum of 1/2^(%d) is %.8f\n", i, sum);
		}
			
	}
	
	

}
