public class CharacterNode {
    char character;
    Fonts style;

    public CharacterNode(char character, Fonts style) {
        this.character = character;
        this.style = style;
    }

    public char getCharacter() {
        return character;
    }

    public Fonts getStyle() {
        return style;
    }
}
