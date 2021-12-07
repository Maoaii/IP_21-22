/**
 * Album class. Hold all the information regarding a single album
 * 
 * @author Lucas Girotto
 */
public class Album {
	// Instance variables
	private String title;
	private String artist;
	private int year;

	/**
	 * Album Constructor
	 * 
	 * @param artist: album's artist
	 * @param title:  album's title
	 * @param year:   album's release date
	 * @pre artist != null && title != null && year != null
	 */
	public Album(String artist, String title, int year) {
		this.artist = artist;
		this.title = title;
		this.year = year;
	}

	/**
	 * @return the artist's name
	 */
	public String getArtistName() {
		return artist;
	}

	/**
	 * @return the album's title
	 */
	public String getAlbumTitle() {
		return title;
	}

	/**
	 * @return the year the album was published in
	 */
	public int getAlbumYear() {
		return year;
	}

	/**
	 * Compares albums based on release dates, artist names and album titles
	 * 
	 * @param other: other album to compare to
	 * @pre other != null
	 * @return positive integer if this.album was released more recently || album's title is
	 *         lexicographically bigger || album's artist name is lexicographycally bigger
	 */
	public int compareTo(Album other) {
		if (year != other.getAlbumYear())
			return year - other.getAlbumYear();
		else if (year == other.getAlbumYear() && artist.compareTo(other.getArtistName()) == 0)
			return title.compareTo(other.getAlbumTitle());
		else
			return artist.compareTo(other.getArtistName());
	}

}
