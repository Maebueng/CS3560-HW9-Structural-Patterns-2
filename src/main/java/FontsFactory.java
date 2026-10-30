import java.util.HashMap;

public class FontsFactory {
    private HashMap<String, Fonts> fonts = new HashMap<>();
    public Fonts getFonts(String type) {
        if(fonts.containsKey(type)) {
            return fonts.get(type);
        } else {
            Fonts font = null;
            if(type.equalsIgnoreCase("Arial-Red-12")) {

            }
            fonts.put(type, fonts);
            return font;
        }
    }
}
