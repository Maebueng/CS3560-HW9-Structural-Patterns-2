import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SongProxyTest {

    @Test
    public void testProxyCachingMissAndHit() {
        SongService service = new SongProxy();

        // 1. First call: Cache miss (should take ~1 second)
        long startTime1 = System.currentTimeMillis();
        Song song1 = service.searchByID(1);
        long duration1 = System.currentTimeMillis() - startTime1;

        assertNotNull(song1);
        assertEquals(1, song1.getID());
        assertTrue(duration1 >= 1000, "First call should simulate network delay");

        // 2. Second call on the SAME service: Cache hit (should be instant)
        long startTime2 = System.currentTimeMillis();
        Song song2 = service.searchByID(1);
        long duration2 = System.currentTimeMillis() - startTime2;

        assertNotNull(song2);
        assertEquals(1, song2.getID());
        assertTrue(duration2 < 500, "Second call should be cached and instant");
        assertSame(song1, song2, "Both calls should return the exact same object instance");
    }
}
