package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int track;
	private int year;

	public void show() {
		System.out.println(artist + " " + title + "(" + album + ", " + year + ", " + track + ", " + composer + " 작곡)");
	}

	public Song(String title, String artist, String album, String composer, int track, int year) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.track = track;
		this.year = year;

		System.out.println("....... someCode1");
		System.out.println("....... someCode2");
		System.out.println("....... someCode3");
		System.out.println("....... someCode4");
		System.out.println("....... someCode5");
	}

	public Song(String title, String artist) {
		this(title, artist, "", "", 0, 0); //기본 생성자 이용하여 중복 코드 방지(somecode)

		System.out.println("....... someCode6");
		this.title = title;
		this.artist = artist;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
