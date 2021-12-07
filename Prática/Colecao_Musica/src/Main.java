import java.util.Scanner;

/**
 * Main class. Handles all the input/output of the program
 * 
 * @author Lucas Girotto
 */
public class Main {
	// Constants
	private static final String RECORD_ADDED = "RA";
	private static final String REMOVE_ALBUM = "AA";
	private static final String CHECK_ALBUM = "CA";
	private static final String LIST_COLLECTION = "LC";
	private static final String LIST_ARTIST_ALBUMS = "LAA";
	private static final String LIST_COLLECTION_ORDERED = "LCO";
	private static final String LIST_COLLECTION_FILTERED_ORDERED = "LAO";
	private static final String EXIT = "SAIR";

	private static final String ALBUM_ADDED = "Album inserido";
	private static final String ALBUM_REMOVED = "Album removido";
	private static final String ALBUM_EXISTS = "Album existente";
	private static final String ALBUM_NOT_EXISTS = "Album inexistente";
	private static final String EXIT_MESSAGE = "A colecao tem %d albuns\n";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Collection c = new Collection();

		String command;
		do {
			command = in.nextLine();
			interpretCommands(in, c, command);
		} while (!command.equals(EXIT));

		in.close();
	}

	/**
	 * Interprets the user's commands
	 * 
	 * @param in:         input reader
	 * @param collection: album collection
	 * @param command:    command the user inputed
	 * @pre in != null && collection != null && command != null
	 */
	private static void interpretCommands(Scanner in, Collection collection, String command) {
		switch (command) {
		case RECORD_ADDED:
			handleRecordAdded(in, collection);
			break;
		case REMOVE_ALBUM:
			handleRemoveAlbum(in, collection);
			break;
		case CHECK_ALBUM:
			handleCheckArtist(in, collection);
			break;
		case LIST_COLLECTION:
			handleListCollection(collection);
			break;
		case LIST_ARTIST_ALBUMS:
			handleListArtistAlbums(in, collection);
			break;
		case LIST_COLLECTION_ORDERED:
			handleListCollectionOrdered(collection);
			break;
		case LIST_COLLECTION_FILTERED_ORDERED:
			handleListCollectionFilteredOrdered(in, collection);
			break;
		case EXIT:
			handleExit(collection);
			break;
		}
	}

	/**
	 * Removes an album from the collection
	 * 
	 * @param in:         input reader
	 * @param collection: album collection
	 * @pre in != null && collection != null
	 */
	private static void handleRecordAdded(Scanner in, Collection collection) {
		collection.addAlbum(in.nextLine().trim(), in.nextLine().trim(), in.nextInt());
		in.nextLine();
		System.out.println(ALBUM_ADDED);
	}

	/**
	 * Adds a new album to the playlist
	 * 
	 * @param in:         input reader
	 * @param collection: album collection
	 * @pre in != null && collection != null
	 */
	private static void handleRemoveAlbum(Scanner in, Collection collection) {
		collection.removeAlbum(in.nextLine().trim(), in.nextLine().trim());
		System.out.println(ALBUM_REMOVED);
	}

	/**
	 * Checks if there's an album with a certain title and certain artist in the collection
	 * 
	 * @param in:         input reader
	 * @param collection: album collection
	 * @pre in != null && collection != null
	 */
	private static void handleCheckArtist(Scanner in, Collection collection) {
		if (collection.checkArtist(in.nextLine().trim(), in.nextLine().trim()))
			System.out.println(ALBUM_EXISTS);
		else
			System.out.println(ALBUM_NOT_EXISTS);
	}

	/**
	 * Lists the album collection
	 * 
	 * @param collection: album collection
	 * @pre collection != null
	 */
	private static void handleListCollection(Collection collection) {
		CollectionIterator iterator = collection.getIterator();
		while (iterator.hasNext()) {
			Album album = iterator.next();
			System.out.println(album.getArtistName() + " ; " + album.getAlbumTitle() + " ; "
					+ album.getAlbumYear());
		}
	}

	/**
	 * Lists the album collection filtered by artist
	 * 
	 * @param collection: album collection
	 * @param in:         input reader
	 * @pre in != null && collection != null
	 */
	private static void handleListArtistAlbums(Scanner in, Collection collection) {
		FilteredCollectionIterator iterator = collection.getFilteredIterator(in.nextLine());
		while (iterator.hasNext()) {
			Album album = iterator.next();
			System.out.println(album.getArtistName() + " ; " + album.getAlbumTitle() + " ; "
					+ album.getAlbumYear());
		}
	}

	/**
	 * Lists the album collection ordered by release date and lexicography order
	 * 
	 * @param collection: album collection
	 * @pre collection != null
	 */
	private static void handleListCollectionOrdered(Collection collection) {
		CollectionIterator iterator = collection.getOrderedIterator();
		while (iterator.hasNext()) {
			Album album = iterator.next();
			System.out.println(album.getArtistName() + " ; " + album.getAlbumTitle() + " ; "
					+ album.getAlbumYear());
		}
	}

	/**
	 * Lists the album collection ordered by release date and lexicography order, filtered by artist
	 * 
	 * @param collection: album collection
	 * @pre collection != null
	 */
	private static void handleListCollectionFilteredOrdered(Scanner in, Collection collection) {
		FilteredCollectionIterator iterator = collection.getFilteredOrderedIterator(in.nextLine());
		while (iterator.hasNext()) {
			Album album = iterator.next();
			System.out.println(album.getArtistName() + " ; " + album.getAlbumTitle() + " ; "
					+ album.getAlbumYear());
		}
	}

	/**
	 * Exits the program and tells how big the collection is
	 * 
	 * @param collection: album collection
	 * @pre collection != null
	 */
	private static void handleExit(Collection collection) {
		System.out.printf(EXIT_MESSAGE, collection.getNumAlbums());
	}
}
