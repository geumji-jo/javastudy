package practice08_Song;

public class Producer {
	
	public void produce(Singer singer, Song song) {
		singer.addSong(song);
	}
	
	public void produce(Singer singer, String title, Song song) {
		singer.changeSong(title, song);
	}

}
