public class Song implements DisplaySong {
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public void display() {
        System.out.println("Now playing: " + title + " | (0:01/" + duration + ") by " + artist);
        // Now playing: SONG | ALBUM (0:01/DURATION) by ARTIST
    }


}
