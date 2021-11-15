import java.util.Scanner;
/**
 * @author Lucas Girotto
 * Handles all the input and output of information to the client side
 */

public class Main {
	
	//Constants
		//Commands
	private static final String COMMAND_RICHNESS = "riqueza";
	private static final String COMMAND_TERRAIN = "terreno";
	private static final String COMMAND_MERIT = "merito";
	private static final String COMMAND_EXCAVATION = "escavacao";
	private static final String COMMAND_QUIT = "sair";
		
		//Output messages
	private static final String RICHNESS_BURIED = "Riqueza enterrada: ";
	private static final String BOTH_DISQUALIFIED = "Correu mal! Foram ambos desclassificados.";
	private static final String ALL_DUG_UP = "Todos os tesouros foram descobertos!";
	private static final String TREASURE_LEFT = "Ainda havia tesouros por descobrir...";
	private static final String INVALID_COMMAND = "Comando invalido";
	private static final String ARQ_DISQUALIFIED = "Arqueologo desclassificado";
	private static final String ARQ_DOESNT_EXIST = "Arqueologo inexistente";
	private static final String INVALID_LEAP = "Salto invalido";
	private static final String LOST_LICENSE = " perdeu a licenca de escavacao";


	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		//Create Manager whilst reading names for the arqueologists and number of plots
		Contest_Manager contest = new Contest_Manager(getArqName(in), getArqName(in), getNumberPlots(in));

		//Use number of plots to cycle through the input of treasure in each plot
		buryTreasures(in, contest);

		//Get commands from user input until "sair" is inputed
		String command;
		do {
			command = in.next();
			interpretCommand(in, contest, command);
		} while (!command.equals(COMMAND_QUIT));
		
		in.close();
	}
	
	/**
	 * Inteprets user's commands
	 * @param contest
	 * @param command
	 * @param in
	 * @pre contest != null && command != null && in != null
	 */
	private static void interpretCommand(Scanner in, Contest_Manager contest, String command) {
		
		switch(command) {
			case COMMAND_RICHNESS: handleRichnessCmd(contest); break;
			
			case COMMAND_TERRAIN: handleTerrainCmd(contest); break;
			
			case COMMAND_MERIT: handleMeritCmd(contest, in); break;
			
			case COMMAND_EXCAVATION: handleExcavationCmd(contest, in); break;
			
			case COMMAND_QUIT: handleQuitCmd(contest); break;
			
			default: System.out.println(INVALID_COMMAND); break;
		}
		//Makes sure that scanner reads more inputs from lines below
		in.nextLine();
	}
	
	/**
	 * Prints out the amount of richness of all the plots, so,
	 * the sum of all treasures
	 * @param contest
	 * @pre contest != null
	 */
	private static void handleRichnessCmd(Contest_Manager contest) {
		System.out.println(RICHNESS_BURIED + contest.computeRichness());
	}
	
	/**
	 * Prints out the terrain of the contest
	 * "*" means there's treasure on the plot and "-" means it doesn't
	 * @param contest
	 * @pre contest != null
	 */
	private static void handleTerrainCmd(Contest_Manager contest) {
		System.out.println(contest.printTerrain());
	}
	
	/**
	 * Prints out the name of an arqueologist and his current merit
	 * Prints different error messages: if name doesn't match any arqueologist;
	 * if arqueologist doesn't have a license
	 * @param contest
	 * @param in
	 * @pre contest != null && in != null
	 */
	private static void handleMeritCmd(Contest_Manager contest, Scanner in) {
		
		String name = in.next();
		
		if (!contest.checkArqExists(name))			
			System.out.println(ARQ_DOESNT_EXIST);	//If name doesn't match any arqueologist
		else if (!contest.checkArqLicense(name))
			System.out.println(ARQ_DISQUALIFIED);	//If that "name" arqueologist doesn't have a license
		else
			System.out.printf("Merito de %s: %d\n", name, contest.computeArqMerit(name));			
	}
	
	/**
	 * Registers a leap for the arqueologist to make and excavates the plot he lands on.
	 * Print different error messages if: leap is 0, invalid; if name doesn't match an arqueologist;
	 * if arqueologist is disqualified; if arqueologist lept outside of the contest terrain
	 * @param contest
	 * @param in
	 * @pre contest != null && in != null
	 */
	private static void handleExcavationCmd(Contest_Manager contest, Scanner in) {
		
		int leap = in.nextInt();
		String name = in.next();
		
		if (leap == 0)
			System.out.println(INVALID_LEAP);
		else if (!contest.checkArqExists(name))
			System.out.println(ARQ_DOESNT_EXIST);	  //If name doesn't match any arqueologist
		else if (!contest.checkArqLicense(name))
			System.out.println(ARQ_DISQUALIFIED);	  //If "name" arqueologist doesn't have a license
		else if (contest.isOutOfBounds(leap, name)) {
			contest.removeLicense(name);			  //Remove arqueologist's license
			System.out.println(name + LOST_LICENSE);  //If "name" arqueologist lept out of contest
		}
		else
			contest.computeExcavation(leap, name);
	}
	
	/**
	 * When user wants to quit the program,
	 * prints out different messages depending on the state of the contest:
	 * if arqueologists lost their license and if there is still treasure or not in the contest
	 * @param contest
	 * @pre contest != null
	 */
	private static void handleQuitCmd(Contest_Manager contest) {
		if (!contest.bothHaveLicense())
			System.out.println(BOTH_DISQUALIFIED);
		else if (contest.computeRichness() <= 0)
			System.out.println(ALL_DUG_UP);
		else
			System.out.println(TREASURE_LEFT);
	}
	
	/**
	 * Loops through the plots and buries treasures in them, according to user input
	 * @param in
	 * @param contest
	 * @pre in != null && contest != null && in.nextInt() > 0 && in.nextInt() < 50 000
	 */
	private static void buryTreasures(Scanner in, Contest_Manager contest) {
		for (int plot = 0; plot < contest.getNumberOfPlots(); plot++) {
			contest.populatePlots(in.nextInt(), plot);
		}
		
		in.nextLine();
	}
	
	/**
	 * Reads the name for an arqueologist from input
	 * @param in
	 * @pre in != null && tmp >= 1 && tmp <= 40
	 * @return name for arqueologist
	 */
	private static String getArqName(Scanner in) {
		String tmp = in.next();
		in.nextLine();
		return tmp;
	}
	
	/**
	 * Reads the amount of plots user wants to create
	 * @param in
	 * @pre in != null && tmp >= 1 && tmp <= 100
	 * @return number of plots to create
	 */
	private static int getNumberPlots(Scanner in) {
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}
}
