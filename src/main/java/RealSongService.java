import java.util.List;
import java.util.ArrayList;

public class RealSongService implements SongService {
    List<Song> songList = new ArrayList<>();
    Song song1 = new Song(1,"Tranz", "Gorillaz", "The Now Now", 162);
    Song song2 = new Song(2,"Kirakuni", "Crystal Kay", "Call me Miss...", 256);
    Song song3 = new Song(3,"Seventh Heaven", "INOHA", "ALOHA INOHA", 234);
    Song song4 = new Song(4,"Machine Love", "Jamie Paige", "Constant Companions", 217);
    Song song5 = new Song(5, "Sabotage", "Beastie Boys", "Ill Communication", 178);
    Song song6 = new Song(6, "Supermassive Black Hole", "Muse", "Black Holes and Revelations", 209);
    Song song7 = new Song(7, "Tripod Baby", "m-flo", "Beat Space Nine", 303);
    Song song8 = new Song(8, "B.O.B. (Bombs Over Baghdad)", "Outkast", "Stankonia", 258);
    Song song9 = new Song(9, "Bite Me", "Enhyphen", "Dark Blood", 157);
    Song song10 = new Song(10, "Body Rock", "Heartsdales", "THE LEGEND", 277);

    public RealSongService() {
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);
        songList.add(song5);
        songList.add(song6);
        songList.add(song7);
        songList.add(song8);
        songList.add(song9);
        songList.add(song10);
    }

    public Song searchByID(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (Song song : songList) {
            if(song.getID() == songID) {
                return song;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String title) {
        List<Song> results = new ArrayList<>();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (Song song : songList) {
            if(song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }
        return results;
    }

    public List<Song> searchByAlbum(String album) {
        List<Song> results = new ArrayList<>();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (Song song : songList) {
            if(song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }
        return results;
    }

}
