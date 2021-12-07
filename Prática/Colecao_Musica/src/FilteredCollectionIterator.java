/**
 * Filtered iterator for the collection of albums. Filters based on artist name
 * 
 * @author Lucas Girotto
 */
public class FilteredCollectionIterator {
	// Instance variables
	private Album[] collection;
	private int size;
	private int nextIndex;
	private String artistName;

	/**
	 * Filtered Iterator Constructor. Filters by artist name
	 * 
	 * @param collection: collection of arrays to be iterated over
	 * @param size:       size of the collection
	 * @param artistName: artist's name to be filtered by
	 * @pre collection != null && size != null && artistName != null
	 */
	public FilteredCollectionIterator(Album[] collection, int size, String artistName) {
		this.collection = collection;
		this.size = size;
		nextIndex = 0;
		this.artistName = artistName;
		advanceToNext();// Goes to the first album that matches the name
	}

	/**
	 * Advances to the next album that matches the filter
	 */
	private void advanceToNext() {
		while (nextIndex < size && !isFromArtist(collection[nextIndex])) {
			nextIndex++;
		}
	}

	/**
	 * @param album: album to check for filter
	 * @pre album != null
	 * @return true if there is an album's artist that matches the name given
	 */
	private boolean isFromArtist(Album album) {
		return album.getArtistName().equals(artistName);
	}

	/**
	 * @return true if there are more albums to iterate
	 */
	public boolean hasNext() {
		return nextIndex < size;
	}

	/**
	 * @return the next album to be iterated over
	 * @pre this.hasNext();
	 */
	public Album next() {
		Album album = collection[nextIndex++];
		advanceToNext();
		return album;
	}
}
