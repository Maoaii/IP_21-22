import java.util.Scanner;

public class Main 
{
	private static final String PERIMETER = "P";
	private static final String AREA = "A";
	private static final String LP = "LP";
	private static final String LC = "LC";
	private static final String EXIT = "EXIT";
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		//Create circle
		Circle circle = createCircle(in);
		
		//Show menu
		showMenu();
		
		//Read option
		String optn = in.next().toUpperCase();
		
		//Execute operation and show answer
		executeOption(optn, circle, in);
	
		in.close();
	}
	
	//Reads input and creates circle
	private static Circle createCircle(Scanner in)
	{
		System.out.println("Give x and y for cicle's center and its' radius (\"x y r\") below");
		
		double x = getDouble(in);
		double y = getDouble(in);
		double r = getDouble(in);
		Circle circle = new Circle(x, y, r);
		
		return circle;
	}
	
	//Prints out a menu showing all the functions that are available
	private static void showMenu()
	{
		System.out.println("Choose a function to calculate: \n");
		
		System.out.println(PERIMETER + " - Perimeter");
		System.out.println(AREA + " - Area");
		System.out.println(LP + " - Point is in circle (\"LC x y\")");
		System.out.println(LC + " - Circle to circle relation (\"LC x y r\"");
		System.out.println(EXIT + " - Exit program");
	}
	
	
	private static void executeOption(String option, Circle circle, Scanner in)
	{
		switch (option)
		{
			//If user wants the perimeter, calculate it
			case "P":
				System.out.printf("Perimeter: %.02f\n", circle.getPerimeter());
				reset(in);
				break;
			//If user wants the area, calculate it
			case "A":
				System.out.printf("Area: %.02f\n", circle.getArea());
				reset(in);
				break;
			//If user wants to see if a given point is inside the circle
			case "LP":
				double pointX = getDouble(in);
				double pointY = getDouble(in);
				System.out.printf(circle.getLP(pointX, pointY));
				reset(in);
				break;
			//If user wants to see a given circles' relation to the first one	
			case "LC":
				double circleX = getDouble(in);
				double circleY = getDouble(in);
				double circleR = getDouble(in);
				System.out.printf(circle.getLC(circleX, circleY, circleR));
				reset(in);
				break;
			//If user is done with the program
			case "EXIT":
				break;
				
		}
	}
	
	//Simple method to read doubles. It's a tad cleaner
	private static double getDouble(Scanner in)
	{
		return in.nextDouble();
	}
	
	private static void reset(Scanner in)
	{
		Circle circle = createCircle(in);
		showMenu();
		String optn = in.next().toUpperCase();
		executeOption(optn, circle, in);
	}

	
	
}
