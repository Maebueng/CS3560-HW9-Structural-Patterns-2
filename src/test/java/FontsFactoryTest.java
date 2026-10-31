import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class FontsFactoryTest {

    @Test
    public void testFontCreationAndProperties() {
        FontsFactory factory = new FontsFactory();
        Fonts font = factory.getFonts("Arial-Red-12");

        assertNotNull(font);
        assertEquals("Arial", font.getName());
        assertEquals("Red", font.getColor());
        assertEquals(12, font.getSize());
    }

    @Test
    public void testFlyweightObjectSharing() {
        FontsFactory factory = new FontsFactory();

        // Request same style twice
        Fonts font1 = factory.getFonts("Calibri-Blue-14");
        Fonts font2 = factory.getFonts("Calibri-Blue-14");

        // check both variables point to EXACT same object in map
        assertSame(font1, font2, "Flywieght factory should reuse the same instance for identical properties");
    }

    @Test
    public void testDifferentStylesAreDistinct() {
        FontsFactory factory = new FontsFactory();

        Fonts font1 = factory.getFonts("Arial-Red-12");
        Fonts font2 = factory.getFonts("Calibri-Blue-14");

        assertNotSame(font1, font2);
    }

    @Test
    public void testTextStylingLogic() {
        FontsFactory factory = new FontsFactory();

        Fonts font1 = factory.getFonts("Arial-Red-12");
        Fonts font2 = factory.getFonts("Calibri-Blue-14");
        Fonts font3 = factory.getFonts("Verdana-Black-16");

        String text = "Testing123456"; // 0-9:
                     //0123456789ABC
        List<CharacterNode> document = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Fonts customFontStyle;

            if (i <= 3) {
                customFontStyle = font1;
            } else if (i <= 6) {
                customFontStyle = font2;
            } else if (i <= 9) {
                customFontStyle = font3;
            } else {
                customFontStyle = font1;
            }
            document.add(new CharacterNode(c, customFontStyle));
        }

        for (CharacterNode node : document) {
            System.out.println("Char: " + node.getCharacter() +
                    " | Font: " + node.getStyle().getName() +
                    " | Color: " + node.getStyle().getColor() +
                    " | Size: " + node.getStyle().getSize());
        }
    }
}
