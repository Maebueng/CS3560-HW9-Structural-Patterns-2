import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SongProxy implements SongService{
    private RealSongService realService = new RealSongService();

    private Map<Integer, Song> cacheByID = new HashMap<>();

    @Override
    public Song searchByID(Integer songID) {
        if (cacheByID.containsKey(songID)) {
            return cacheByID.get(songID);
        } else {
            Song song = realService.searchByID(songID);
            if (song != null) {
                cacheByID.put(songID, song);
            }
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return realService.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return realService.searchByAlbum(album);
    }
}
