import java.util.Scanner;

/**
 * @author lucas Handles input and output for this program
 */
public class Main {

	// Constants
	// Menu commands
	private static final String ADD_CONTACT = "AC";
	private static final String REMOVE_CONTACT = "RC";
	private static final String GET_PHONE = "GP";
	private static final String GET_EMAIL = "GE";
	private static final String SP = "SP";
	private static final String SE = "SE";
	private static final String LIST_CONTACTS = "LC";
	private static final String QUIT = "Q";

	// Messages
	private static final String ALREADY_EXISTS = "Contact already exists.\n";
	private static final String CONTACT_ADDED = "Contact added.\n";
	private static final String CANNOT_REMOVE = "Cannot remove contact.\n";
	private static final String CONTACT_REMOVED = "Contact removed.\n";
	private static final String CONTACT_DOESNT_EXIST = "Contact does not exist.\n";
	private static final String CONTACT_UPDATED = "Contact updated.\n";
	private static final String CONTACTBOOK_EMPTY = "Contact book empty.\n";
	private static final String WRONG_CMD = "Wrong command.\n";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Contact_Book cb = new Contact_Book();

		String command;
		do {
			menu();
			command = in.next().toUpperCase();
			interpretCommand(command, cb, in);
		} while (!command.equals(QUIT));

		in.close();
	}

	// Methods

	/**
	 * Interprets the command the user inputed
	 * 
	 * @param command
	 * @param cb
	 * @pre command != null && cb != null
	 */
	private static void interpretCommand(String command, Contact_Book cb, Scanner in) {

		switch (command) {
		case ADD_CONTACT:
			handleAddContact(cb, in);
			break;

		case REMOVE_CONTACT:
			handleRemoveContact(cb, in);
			break;

		case GET_PHONE:
			handleGetPhoneNumber(cb, in);
			break;

		case GET_EMAIL:
			handleGetEmail(cb, in);
			break;

		case SP:
			handleSP(cb, in);
			break;

		case SE:
			handleSE(cb, in);
			break;

		case LIST_CONTACTS:
			handleListContacts(cb);
			break;

		case QUIT:
			break;

		default:
			in.nextLine();
			System.out.println(WRONG_CMD);

		}
	}

	/**
	 * Lists out the menu of commands
	 */
	private static void menu() {
		System.out.println(ADD_CONTACT + " - Adicionar contacto (email, phone, name).");
		System.out.println(REMOVE_CONTACT + " - Remover contacto (name).");
		System.out.println(GET_PHONE + " - Ver número de telemóvel (name).");
		System.out.println(SP + " - Colocar número de telemóvel (phone, name).");
		System.out.println(SE + " - Colocar o email. (email, name).");
		System.out.println(LIST_CONTACTS + " - Listar os contactos.");
		System.out.println(QUIT + " - Sair do programa.");
	}

	/**
	 * Handles the add contact cases
	 * 
	 * @param cb
	 * @pre cb != null && in != null
	 */
	private static void handleAddContact(Contact_Book cb, Scanner in) {
		String email = in.next();
		String phone_number = in.next();
		String name = in.nextLine().trim();

		if (cb.hasContact(name))
			System.out.println(ALREADY_EXISTS);
		else {
			cb.addContact(name, phone_number, email);
			System.out.println(CONTACT_ADDED);
		}

	}

	/**
	 * Handles the remove contact cases
	 * 
	 * @param cb
	 * @pre cb != null && in != null
	 */
	private static void handleRemoveContact(Contact_Book cb, Scanner in) {
		String name = in.nextLine().trim();

		if (!cb.hasContact(name))
			System.out.println(CANNOT_REMOVE);
		else {
			cb.deleteContact(name);
			System.out.println(CONTACT_REMOVED);
		}
	}

	/**
	 * Handles the get phone number cases
	 * 
	 * @param cb
	 * @pre cb != null && in != null
	 */
	private static void handleGetPhoneNumber(Contact_Book cb, Scanner in) {
		String name = in.nextLine().trim();

		if (!cb.hasContact(name))
			System.out.println(CONTACT_DOESNT_EXIST);
		else
			System.out.println(cb.getPhone(name));

	}

	/**
	 * Handles the get email cases
	 * 
	 * @param cb
	 * @pre cb != null && in != null
	 */
	private static void handleGetEmail(Contact_Book cb, Scanner in) {
		String name = in.nextLine().trim();

		if (!cb.hasContact(name))
			System.out.println(CONTACT_DOESNT_EXIST);
		else
			System.out.println(cb.getEmail(name));
	}

	/**
	 * Handles the SP cases
	 * 
	 * @param cb
	 * @pre cb != null && in != null
	 */
	private static void handleSP(Contact_Book cb, Scanner in) {
		String phone = in.next();
		String name = in.nextLine().trim();

		if (!cb.hasContact(name))
			System.out.println(CONTACT_DOESNT_EXIST);
		else {
			cb.setPhoneNumber(name, phone);
			System.out.println(CONTACT_UPDATED);
		}

	}

	/**
	 * Handles the SE cases
	 * 
	 * @param cb
	 * @pre cb != null && in != null
	 */
	private static void handleSE(Contact_Book cb, Scanner in) {
		String email = in.next();
		String name = in.nextLine().trim();

		if (!cb.hasContact(name))
			System.out.println(CONTACT_DOESNT_EXIST);
		else {
			cb.setEmail(name, email);
			System.out.println(CONTACT_UPDATED);
		}

	}

	/**
	 * Handles the list contacts cases
	 * 
	 * @param cb
	 * @param in
	 * @pre cb != null && in != null
	 */
	private static void handleListContacts(Contact_Book cb) {
		Contact_Iterator it = cb.iterator(); // Obtains the iterator

		if (!it.hasNext())
			System.out.println(CONTACTBOOK_EMPTY);

		while (it.hasNext()) {
			Contact c = it.next();
			System.out.println(c.getName() + ";" + c.getEmail() + ";" + c.getPhoneNumber());
		}
	}

}
