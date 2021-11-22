import java.util.Scanner;

/**
 * @author Lucas Girotto 
 * Handles all the input and output of information to the client side
 */

public class Main {

	// Constants
		// Commands
	private static final String COMMAND_RICHNESS = "riqueza";
	private static final String COMMAND_TERRAIN = "terreno";
	private static final String COMMAND_MERIT = "merito";
	private static final String COMMAND_EXCAVATION = "escavacao";
	private static final String COMMAND_QUIT = "sair";

		// Output messages
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

		// Create Contest Manager whilst reading names for the archeologists and number of plots
		Contest_Manager contest = new Contest_Manager(in.nextLine(), in.nextLine(),
				getNumberPlots(in));

		// Use number of plots to cycle through the input of treasure in each plot
		buryTreasures(in, contest);

		// Get commands from user input until "sair" is inputed
		String command;
		do {
			command = in.next();
			interpretCommand(in, contest, command);
		} while (!command.equals(COMMAND_QUIT));

		in.close();
	}

	/**
	 * Intepret user's commands
	 * 
	 * @param contest system that manages the global project
	 * @param command user command to be executed
	 * @param in      built-in Scanner for input reading
	 * @pre contest != null && command != null && in != null
	 */
	private static void interpretCommand(Scanner in, Contest_Manager contest, String command) {

		switch (command) {
		case COMMAND_RICHNESS:
			handleRichnessCmd(contest, in);
			break;

		case COMMAND_TERRAIN:
			handleTerrainCmd(contest, in);
			break;

		case COMMAND_MERIT:
			handleMeritCmd(contest, in);
			break;

		case COMMAND_EXCAVATION:
			handleExcavationCmd(contest, in);
			break;

		case COMMAND_QUIT:
			handleQuitCmd(contest);
			break;

		default:
			System.out.println(INVALID_COMMAND);
			in.nextLine();
			break;
		}
	}

	/**
	 * Prints out the amount of richness of all the plots, so, 
	 * the sum of all treasures and goes to the next console line
	 * 
	 * @param contest system that manages the global project
	 * @param in      built-in Scanner for input reading
	 * @pre contest != null && in != null
	 */
	private static void handleRichnessCmd(Contest_Manager contest, Scanner in) {
		System.out.println(RICHNESS_BURIED + contest.computeRichness());
		in.nextLine();
	}

	/**
	 * Prints out the terrain of the contest "*" means there's treasure on the plot 
	 * and "-" means it doesn't. Also goes to console's next line.
	 * 
	 * @param contest system that manages the global project
	 * @param in      built-in Scanner for input reading
	 * @pre contest != null && in != null
	 */
	private static void handleTerrainCmd(Contest_Manager contest, Scanner in) {
		System.out.println(contest.printTerrain());
		in.nextLine();
	}

	/**
	 * Prints out the name of an archeologist and his current merit. Prints different error
	 * messages: if name doesn't match any archeologist; if archeologist doesn't have a license
	 * 
	 * @param contest system that manages the global project
	 * @param in      built-in Scanner for input reading
	 * @pre contest != null && in != null
	 */
	private static void handleMeritCmd(Contest_Manager contest, Scanner in) {

		String name = in.nextLine().trim();

		if (!contest.checkArchExists(name))
			System.out.println(ARQ_DOESNT_EXIST); // If name doesn't match any archeologist
		else if (!contest.checkArchLicense(name))
			System.out.println(ARQ_DISQUALIFIED); // If archeologist doesn't have a license
		else
			System.out.printf("Merito de %s: %d\n", name, contest.computeArchMerit(name));
	}

	/**
	 * Registers a leap for the archeologist to make and excavates the plot he lands on. Print
	 * different error messages if: leap is 0, invalid; if name doesn't match an archeologist; if
	 * archeologist is disqualified; if archeologist lept outside of the contest terrain
	 * 
	 * @param contest system that manages the global project
	 * @param in      built-in Scanner for input reading
	 * @pre contest != null && in != null
	 */
	private static void handleExcavationCmd(Contest_Manager contest, Scanner in) {

		int leap = in.nextInt();
		String name = in.nextLine().trim();

		if (leap == 0)
			System.out.println(INVALID_LEAP);
		else if (!contest.checkArchExists(name))
			System.out.println(ARQ_DOESNT_EXIST);	 // If name doesn't match any archeologist
		else if (!contest.checkArchLicense(name))
			System.out.println(ARQ_DISQUALIFIED);	 // If archeologist doesn't have a license
		else if (contest.isOutOfBounds(leap, name)) {
			contest.removeLicense(name); 			 // Remove Archeologist's license
			System.out.println(name + LOST_LICENSE); // If archeologist lept outside contest
		} else
			contest.computeExcavation(leap, name);
	}

	/**
	 * When user wants to quit program, prints out different messages depending on the state of
	 * the contest: if archeologists lost their license and if there is still treasure or not
	 * 
	 * @param contest system that manages the global project
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
	 * 
	 * @param in      built-in Scanner for input reading
	 * @param contest system that manages the global project
	 * @pre in != null && contest != null
	 */
	private static void buryTreasures(Scanner in, Contest_Manager contest) {
		for (int plot = 0; plot < contest.getNumberOfPlots(); plot++) {
			contest.populatePlots(in.nextInt(), plot);
		}

		in.nextLine();
	}

	/**
	 * Reads the amount of plots user wants to create
	 * 
	 * @param in built-in Scanner for input reading
	 * @pre in != null
	 * @return number of plots to create
	 */
	private static int getNumberPlots(Scanner in) {
		int numPlots = in.nextInt();
		in.nextLine();
		return numPlots;
	}
}