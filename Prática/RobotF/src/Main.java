import java.util.Scanner;

public class Main {
	
	//Constants
	
		//Inputs available
	private static final String MV = "MV";			//Move robot command label
	private static final String MD = "MD";			//Change heading command label
	private static final String PI = "PI";			//Mark PoI command label
	private static final String LP = "LP";			//Get current position command label
	private static final String LDT = "LDT";		//Get total distance command label
	private static final String LDPI = "LDPI";		//Get distance from previous PoI command label
	private static final String DTMAX = "DTMAX";	//Max distance command label
	private static final String EXIT = "S";			//Exit command loop
	
		//Headings
	private static final String NORTH = "N";
	private static final String SOUTH = "S";
	private static final String EAST = "E";
	private static final String WEST = "O";
		
		//Error messages
	private static final String INVALID_ROBOT = "Robot invalido.";
	private static final String INVALID_DISTANCE = "Distancia invalida.";
	private static final String INVALID_HEADING = "Direcao invalida.";
	private static final String INVALID_COMMAND = "Comando invalido.";

	
		//Identifiers
	private static final int ROBOT1 = 1;			//Robot 1 identifier
	private static final int ROBOT2 = 2;			//Robot 2 identifier
	private static final int TIE = 3;				//Tie identifier


	
	public static void main(String[] args) {
		
		//Create scanner
		Scanner in = new Scanner(System.in);
		
		//Create a robot system to manage robots
		RobotSystem rs1 = new RobotSystem(getX(in), getY(in), getX(in), getY(in));
		
		//Read inputs and process them until user writes 'S' to stop the program
		String command;
		do {
			command = in.next();
			interpretCommand(in, rs1, command);
		} while (!command.equals(EXIT));
		
		//Close scanner
		in.close();
	}
	
	/**
	 * Reads user input and processes the command
	 * 
	 * @param in
	 * @param rs
	 * @param command
	 * @pre in != null && rs != null && command != null
	 */
	private static void interpretCommand(Scanner in, RobotSystem rs, String command) {
		
		switch (command) {
		
			//Move robot case
			case MV: processMV(in, rs);
				break;
				
			//Change robot's direction case
			case MD: processMD(in, rs);
				break;
				
			//Mark PoI case	
			case PI: processPI(in, rs);
				break;
				
			//Get robot's current position case
			case LP: processLP(in, rs);
				break;
				
			//Get robot's total distance case
			case LDT: processLDT(in, rs);
				break;
				
			//Get robot's distance from previous PoI case
			case LDPI: processLDPI(in, rs);
				break;
				
			//Who traveled more case
			case DTMAX: processDTMAX(rs);
				break;
				
			//User wants to quit program case
			case EXIT:
				break;
				
			//If command isn't the same as any of the above, it's an invalid command
			default: System.out.println(INVALID_COMMAND);
				break;
		}
		
		//Need this to keep reading input from line below
		in.nextLine();
	}
	
	/**
		* Moves robot
		* 
		* @param in
		* @param rs
		* @pre in != null && rs != null
	*/
	private static void processMV(Scanner in, RobotSystem rs) {
		
		int robotNumber = in.nextInt();
		int moveBy = in.nextInt();
		
		if (robotNumber != ROBOT1 && robotNumber != ROBOT2) {
			System.out.println(INVALID_ROBOT);
		}
		else if (moveBy <= 0) {
			System.out.println(INVALID_DISTANCE);
		}
		else
			rs.systemMove(robotNumber, moveBy);
	}
	
	/**
		* Changes robot's direction
		* 
		* @param in
		* @param rs
		* @pre in != null && rs != null
	*/
	private static void processMD(Scanner in, RobotSystem rs) {
		
		int robotNumber = in.nextInt();
		
		String headTo = in.next().toUpperCase();
		
		if (robotNumber != ROBOT1 && robotNumber != ROBOT2) {
			System.out.println(INVALID_ROBOT);
		}
		else if (!headTo.equals(NORTH) && !headTo.equals(SOUTH) && !headTo.equals(EAST) && !headTo.equals(WEST)) {
			System.out.println(INVALID_HEADING);
			
			
		}
		else
			rs.systemSetHeading(robotNumber, headTo);
	}
	
	
	/**
	 * Marks a Point of Interest
	 * 
	 * @param in
	 * @param rs
	 * @pre in != null && rs != null
	 */
	private static void processPI(Scanner in, RobotSystem rs) {
		
		int robotNumber = in.nextInt();
		
		if (robotNumber != ROBOT1 && robotNumber != ROBOT2) {
			System.out.println(INVALID_ROBOT);
		}
		else
			rs.systemMark(robotNumber);
	}
	
	/**
	 * Gets robot's current position
	 * @param in
	 * @param rs
	 * @pre in != null && rs != null
	 */
	private static void processLP(Scanner in, RobotSystem rs) {
		
		int robotNumber = in.nextInt();
		
		if (robotNumber != ROBOT1 && robotNumber != ROBOT2) {
			System.out.println(INVALID_ROBOT);
		}
		else
			System.out.println(rs.systemGetXPos(robotNumber) + " " + rs.systemGetYPos(robotNumber));
	}
	
	/**
	 * Gets robot's total distance traveled
	 * 
	 * @param in
	 * @param rs
	 * @pre in != null && rs != null
	 */
	private static void processLDT(Scanner in, RobotSystem rs) {
		
		int robotNumber = in.nextInt();
		
		if (robotNumber != ROBOT1 && robotNumber != ROBOT2) {
			System.out.println(INVALID_ROBOT);
		}
		else
			System.out.println(rs.systemGetTotalDistance(robotNumber));
	}
	
	/**
	 * Gets robot's distance from previous PoI
	 * 
	 * @param in
	 * @param rs
	 * @pre in != null && rs != null
	 */
	private static void processLDPI(Scanner in, RobotSystem rs) {
		
		int robotNumber = in.nextInt();
	
		if (robotNumber != ROBOT1 && robotNumber != ROBOT2) {
			System.out.println(INVALID_ROBOT);
		}
		else
			System.out.println(rs.systemGetPIDistance(robotNumber));
	}
	
	/**
	 * Prints out what robot traveled the farthest
	 * 
	 * @param rs
	 * @pre rs != null
	 */
	private static void processDTMAX(RobotSystem rs) {
		
		int whoTraveledFarthest = rs.systemWhoTraveledMore();
		
		if (whoTraveledFarthest == ROBOT1) {
			System.out.println("ROBOT 1");
		}
		else if (whoTraveledFarthest == ROBOT2) {
			System.out.println("ROBOT 2");
		}
		else if (whoTraveledFarthest == TIE)
			System.out.println("EMPATE");
	}
	
	/**
	 * Returns an integer used as a robot's X position
	 * 
	 * @param in
	 * @return int
	 * @pre in != null
	 */
	private static int getX(Scanner in) {
		
		return in.nextInt();
	}
	
	/**
	 * Returns and integer used as a robot's Y position
	 * 
	 * @param in
	 * @return int
	 * @pre in != null
	 */
	private static int getY(Scanner in) {
		
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}
}
