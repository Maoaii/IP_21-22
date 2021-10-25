import java.util.Scanner;

public class Main 
{
	//Constants
	private static final String MV = "MV";			//Move robot command label
	private static final String MD = "MD";			//Change heading command label
	private static final String PI = "PI";			//Mark PoI command label
	private static final String LP = "LP";			//Get current position command label
	private static final String LDT = "LDT";		//Get total distance command label
	private static final String LDPI = "LDPI";		//Get distance from previous PoI command label
	private static final String DTMAX = "DTMAX";	//Max distance command label
	private static final String DR = "DR";
	private static final String LMV = "LMV";	
	private static final int ROBOT1 = 1;			//Robot 1 identifier

	public static void main(String[] args) {
		//Create scanner
		Scanner in = new Scanner(System.in);
		
		//Create two robots
		Robot robot1 = createRobot(in);
		Robot robot2 = createRobot(in);
		
		//Read 5 commands from user input
		interpretCommand(in, robot1, robot2);
		interpretCommand(in, robot1, robot2);
		interpretCommand(in, robot1, robot2);
		interpretCommand(in, robot1, robot2);
		interpretCommand(in, robot1, robot2);
		
		//Close scanner
		in.close();
	}
	
	//Creates robots
	private static Robot createRobot(Scanner in)
	{
		int init_x = in.nextInt();
		int init_y = in.nextInt();
		in.nextLine();
		
		return new Robot(init_x, init_y);
	}
	
	//Reads user input and processes the command
	private static void interpretCommand(Scanner in, Robot robot1, Robot robot2)
	{
		//Read command
		String command = in.next().toUpperCase();
		
		switch (command)
		{
			//Move robot case
			case MV:
				processMV(in, robot1, robot2);
				break;
			//Change robot's direction case
			case MD:
				processMD(in, robot1, robot2);
				break;
			//Mark PoI case	
			case PI:
				processPI(in, robot1, robot2);
				break;
			//Get robot's current position case
			case LP:
				processLP(in, robot1, robot2);
				break;
			//Get robot's total distance case
			case LDT:
				processLDT(in, robot1, robot2);
				break;
			//Get robot's distance from previous PoI case
			case LDPI:
				processLDPI(in, robot1, robot2);
				break;
			//Who traveled more case
			case DTMAX:
				processDTMAX(robot1, robot2);
				break;
			//
			case DR:
				processDR(robot1, robot2);
				break;
			//
			case LMV:
				processLMB(robot1, robot2);
				break;
						
		}
		
		//Need this to keep reading input from line below
		in.nextLine();
	}
	
	

	//Moves robot
	private static void processMV(Scanner in, Robot robot1, Robot robot2)
	{
		int robotNumber = in.nextInt();
		int moveBy = in.nextInt();
		
		if (robotNumber == ROBOT1)
		{
			robot1.move(moveBy);
			robot1.recordMaxMove(moveBy);
			//recordMaxMove(moveBy, robotNumber);
		}
		else
		{
			robot2.move(moveBy);
			robot2.recordMaxMove(moveBy);
			//recordMaxMove(moveBy, robotNumber);
		}
		
		
	}
	
	//Changes robot's direction
	private static void processMD(Scanner in, Robot robot1, Robot robot2)
	{
		int robotNumber = in.nextInt();
		String headTo = in.next().toUpperCase();
		
		if (robotNumber == ROBOT1)
			robot1.setHeading(headTo);
		else
			robot2.setHeading(headTo);
	}
	
	//Marks PoI
	private static void processPI(Scanner in, Robot robot1, Robot robot2)
	{
		int robotNumber = in.nextInt();
		
		if (robotNumber == ROBOT1)
			robot1.mark();
		else
			robot2.mark();
	}
	
	//Gets robot's current position
	private static void processLP(Scanner in, Robot robot1, Robot robot2)
	{
		int robotNumber = in.nextInt();
		
		if (robotNumber == ROBOT1)
			System.out.println(robot1.getXPos() + " " + robot1.getYPos());
		else
			System.out.println(robot2.getXPos() + " " + robot2.getYPos());
	}
	
	//Gets robot's total distance
	private static void processLDT(Scanner in, Robot robot1, Robot robot2)
	{
		int robotNumber = in.nextInt();
		
		if (robotNumber == ROBOT1)
			System.out.println(robot1.getTotalDistance());
		else
			System.out.println(robot2.getTotalDistance());
	}
	
	//Gets robot's distance from previous PoI
	private static void processLDPI(Scanner in, Robot robot1, Robot robot2)
	{
		int robotNumber = in.nextInt();
		
		if (robotNumber == ROBOT1)
			System.out.println(robot1.getPIDistance());
		else
			System.out.println(robot2.getPIDistance());
	}
	
	//Prints out what robot traveled the farthest
	private static void processDTMAX(Robot robot1, Robot robot2)
	{
		if (robot1.getTotalDistance() > robot2.getTotalDistance())
			System.out.println("ROBOT 1");
		else if (robot1.getTotalDistance() < robot2.getTotalDistance())
			System.out.println("ROBOT 2");
		else
			System.out.println("EMPATE");
	}
	
	//Prints out the distance between the robots
	private static void processDR(Robot robot1, Robot robot2) 
	{
		//Calculates the Manhattan absolute distance between the robots
		int distanceRobots = (Math.abs(robot1.getXPos() - robot2.getXPos()) + Math.abs(robot1.getYPos() - robot2.getYPos()));
		System.out.println(distanceRobots);
	}
	
	//Prints out which robot had the biggest single movement
	private static void processLMB(Robot robot1, Robot robot2)
	{
		if (robot1.getMaxMove() > robot2.getMaxMove())
			System.out.println("ROBOT 1");
		else if (robot1.getMaxMove() < robot2.getMaxMove())
			System.out.println("ROBOT 2");
		else
			System.out.println("EMPATE");

	}
}
