package Data;

public class TempMusicRecord {
	private String genre;
	private String length;
	private String name;
	private String musicmode;

	public TempMusicRecord(String name, String length, String genre, String musicmode) {
		this.genre = genre;
		this.length = length;
		this.name = name;
		this.musicmode = musicmode;
	}

	public String getGenre() {
		return genre;
	}

	public String getLength() {
		return length;
	}

	public String getName() {
		return name;
	}

	public String getMusicmode() {
		return musicmode;
	}

}
