import java.util.HashMap;
import java.util.Map;

public class FontsFactory {
    private HashMap<String, Fonts> fontCache = new HashMap<>();

    public Fonts getFonts(String key) {
        // Check if font already exists in the cache
        if(fontCache.containsKey(key)) {
            return fontCache.get(key);
        } else {
            Fonts font = null;
            if(key.equalsIgnoreCase("Arial-Red-12")) {
                font = new CustomFont("Arial", "Red", 12);
            } else if (key.equalsIgnoreCase("Calibri-Blue-14")) {
                font = new CustomFont("Calibri", "Blue", 14);
            } else if (key.equalsIgnoreCase("Verdana-Black-16")) {
                font = new CustomFont("Verdana", "Black", 16);
            } else {
                font = new CustomFont("Arial", "Blue", 14);
            }
            fontCache.put(key, font);
            return font;
        }
    }
}
