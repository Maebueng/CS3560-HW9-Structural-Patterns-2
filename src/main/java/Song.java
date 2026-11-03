public class Song implements DisplaySong {
    private Integer ID;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(Integer ID, String title, String artist, String album, int duration) {
        this.ID = ID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }


    public void display() {
        System.out.println("Now playing: " + title + " | (1 sec /" + duration + " sec) by " + artist);
        // Now playing: SONG | ALBUM (1 sec /DURATION sec) by ARTIST
    }


}
