import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FontsFactoryTest {

    @Test
    public void testFontCreationAndProperties() {
        FontsFactory factory = new FontsFactory();
        Fonts font = factory.getFonts("Aril-Red-12");

        assertNotNull(font);
        assertEquals("Arial", font.getName());
        assertEquals("Red", font.getColor());
        assertEquals(12, font.getSize());
    }
}
