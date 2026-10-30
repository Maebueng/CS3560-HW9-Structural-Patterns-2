public class CustomFont implements Fonts {
    private String fontName;
    private String fontColor;
    private int fontSize;

    public CustomFont(String fontName, String fontColor, int fontSize) {
        this.fontName = fontName;
        this.fontColor = fontColor;
        this.fontSize = fontSize;
    }

    public String getName() {
        return fontName;
    }

    public String getColor() {
        return fontColor;
    }

    public int getSize() {
        return fontSize;
    }
}
