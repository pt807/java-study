package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song = new Song("좋은날", "아이유", "Real", "이민수", 3, 2010);
		Song song2 = new Song("ditto", "new jeans");
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setTrack(3);
//		song.setYear(2010);
		
		song.show();
		song2.show();
	}

}
