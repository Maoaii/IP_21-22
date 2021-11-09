import java.util.Scanner;

//O exit não funciona

public class Main 
{
	//Constants
	private static final String PRIME = "PR";
	private static final String PERFECT = "PE";
	private static final String FACTORIAL = "FA";
	private static final String GCD = "GCD";
	private static final String SUM_OF_SQUARES = "SOS";
	private static final String CONVERGE_TO_ONE = "CTO";
	private static final String EXIT = "EX";

	
	public static void main(String[] args) 
	{
		String option;
		
		Scanner in = new Scanner(System.in);
		
		do
		{
			printMenu();
			
			option = getString(in);

			executeOption(option, in);
			
		} while (!option.equals(EXIT));
				
		in.close();
	}
	
	private static void printMenu()
	{
		System.out.println("Choose a function: \n");
		
		System.out.println(PRIME + " - Check if it's a prime number");
		System.out.println(PERFECT + " - Check if it's a perfect number");
		System.out.println(FACTORIAL + " - Do factorial of the number");
		System.out.println(GCD + " - Find the GCD of two numbers");
		System.out.println(SUM_OF_SQUARES + " - Calculate the sum of squares from 1 to n");
		System.out.println(CONVERGE_TO_ONE + " - Visual proof that the sum of 1/2^n converges to 1");
		System.out.println(EXIT + " - Exit program");
	}
	
	private static void executeOption(String option, Scanner in)
	{
		int number1, number2;
		switch (option)
		{
			case PRIME:
				number1 = getInt(in, "Choose a number to test: ");
				
				if (Mathematics.isPrime(number1))
					System.out.printf("%d is a prime.\n\n", number1);
				else
					System.out.printf("%d is not a prime.\n\n", number1);
				break;
				
			case PERFECT:
				number1 = getInt(in, "Choose a number to test: ");
				
				if (Mathematics.isPerfectNumber(number1))
					System.out.printf("%d is a perfect number.\n\n", number1);
				else
					System.out.printf("%d is not a perfect number.\n\n", number1);
				break;
			
			case FACTORIAL:
				number1 = getInt(in, "Choose a number to test: ");
				
				System.out.printf("%d factorial is %d\n\n", number1, Mathematics.factorialRec(number1));
				break;
			
			case GCD:
				number1 = getInt(in, "Choose the first number: ");
				number2 = getInt(in, "And now the second: ");
				
				System.out.printf("%d is a gcd of %d and %d\n", Mathematics.gcdRec(number1, number2), number1, number2);
				break;
			
			case SUM_OF_SQUARES:
				number1 = getInt(in, "Choose  where to stop: ");
				
				if (Mathematics.sumOfSquaresRec(number1) == 0)
					System.out.printf("Number needs to be greater than 0\n");
				else
					System.out.printf("The sum of squares from 1 to %d is %d\n", number1, Mathematics.sumOfSquaresRec(number1));
				break;
				
			case CONVERGE_TO_ONE:
				Mathematics.convergeToOne();
				break;
			
			case EXIT:
				System.out.println("Exiting program...");
				break;
		}
	}
	
	private static String getString(Scanner in)
	{
		String option = in.next().toUpperCase();
		in.nextLine();
		return option;
	}
	
	private static int getInt(Scanner in, String msg)
	{
		System.out.println(msg);
		int value = in.nextInt();
		in.nextLine();
		return value;
	}

}
