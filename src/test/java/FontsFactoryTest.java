import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        Fonts font1 = factory.getFonts("Calibri-Blue-13");
        Fonts font2 = factory.getFonts("Calibri-Blue-14");

        // check both variables point to EXACT same object in map
        assertSame(font1, font2, "Flywieght factory should reuse the same instance for identical properties");
    }
}
