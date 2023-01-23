package practice08_Song;

public class Song {

	private String title;
	private String genre;
	
	public Song(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", genre=" + genre + "]";
	}
	
}
