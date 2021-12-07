/**
 * Collection class (system). Handles all the logic behind a collection of albums
 * 
 * @author Lucas Girotto
 */
public class Collection {
	// Constants
	private static final int DEFAULT_SIZE = 10;
	private static final int GROWTH_FACTOR = 2;

	// Instance variables
	private Album[] collection;
	private int size;

	/**
	 * Album collection constructor
	 */
	public Collection() {
		collection = new Album[DEFAULT_SIZE];
		size = 0;
	}

	/**
	 * Adds a new album to the album collection
	 * 
	 * @param artistName: name of album's artist
	 * @param title:      title of the album
	 * @param year:       year the album was published
	 * @pre artistName != null && title != null && year != null
	 */
	public void addAlbum(String artistName, String title, int year) {
		if (isFull())
			grow();
		collection[size++] = new Album(artistName, title, year);
	}

	/**
	 * Removes an album from collection
	 * 
	 * @param artistName: name of artist to remove album from
	 * @param title:      title of the album to be removed
	 * @pre artistName != null && title != null
	 */
	public void removeAlbum(String artistName, String title) {
		for (int i = searchIndex(artistName, title); i < size - 1; i++)
			collection[i] = collection[i + 1];
		size--;
	}

	/**
	 * Searches for the index of an album by a certain artist
	 * 
	 * @param artistName: artist name to look for
	 * @param title:      album title to look for
	 * @pre artistName != null && title != null
	 * @return the index of said album
	 */
	private int searchIndex(String artistName, String title) {

		int i = 0;

		while (i < size || (!collection[i].getArtistName().equals(artistName)
				&& collection[i].getAlbumTitle().equals(title))) {
			if (collection[i].getArtistName().equals(artistName)
					&& collection[i].getAlbumTitle().equals(title))
				return i;
			i++;
		}
		if (i < size)
			return i;
		else
			return 0;
	}

	/**
	 * @param artistName: to be checked with
	 * @param albumTitle: album title to be checked with
	 * @pre artistName != null && albumTitle != null
	 * @return true if there is an album with the title given with the artist's name given
	 */
	public boolean checkArtist(String artistName, String albumTitle) {
		for (int album = 0; album < size; album++) {
			if (collection[album].getArtistName().equals(artistName)
					&& collection[album].getAlbumTitle().equals(albumTitle))
				return true;
		}
		return false;
	}

	/**
	 * @return the amount of albums on the collection
	 */
	public int getNumAlbums() {
		return size;
	}

	/**
	 * @return the normal iterator
	 */
	public CollectionIterator getIterator() {
		return new CollectionIterator(collection, size);
	}

	/**
	 * @param artistName: artist name to filter for
	 * @pre artistName != null
	 * @return the filtered iterator
	 */
	public FilteredCollectionIterator getFilteredIterator(String artistName) {
		return new FilteredCollectionIterator(collection, size, artistName);
	}

	/**
	 * @return the ordered iterator
	 */
	public CollectionIterator getOrderedIterator() {
		Album[] tmp = new Album[size];
		for (int i = 0; i < size; i++)
			tmp[i] = collection[i];
		sort(tmp, size);
		return new CollectionIterator(tmp, size);
	}

	/**
	 * @return the ordered iterator
	 */
	public FilteredCollectionIterator getFilteredOrderedIterator(String artistName) {
		Album[] tmp = new Album[size];
		for (int i = 0; i < size; i++)
			tmp[i] = collection[i];
		sort(tmp, size);
		return new FilteredCollectionIterator(tmp, size, artistName);
	}

	/**
	 * Sorts the albums with bubble sort
	 * 
	 * @param collection: collection of albums to be sorted
	 * @param size:       size of the album
	 * @pre collection != null && size != null
	 */
	private void sort(Album[] collection, int size) {
		for (int i = 1; i < size; i++)
			for (int j = size - 1; j >= i; j--)
				if (collection[j - 1].compareTo(collection[j]) > 0) {
					Album tmp = collection[j - 1];
					collection[j - 1] = collection[j];
					collection[j] = tmp;
				}
	}

	/**
	 * @return true if album array is full
	 */
	private boolean isFull() {
		return size == collection.length;
	}

	/**
	 * Grow the albums array
	 */
	private void grow() {
		Album[] tmp = new Album[collection.length * GROWTH_FACTOR];

		for (int i = 0; i < size; i++) {
			tmp[i] = collection[i];
		}
		collection = tmp;
	}
}
