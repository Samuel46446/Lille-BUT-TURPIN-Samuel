import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

import e6.Ville;

/**
 * VilleTest
 */
public class VilleTest {
    Ville lille = new Ville("Lille");
    Ville lens = new Ville("Lens");
    Ville paris = new Ville("Paris");
    Ville lyon = new Ville("Lyon");

    @Test
    public void test1() {
        assertEquals("Lille", lille.toString());
        assertEquals("Lens", lens.toString());
        assertEquals("Paris", paris.toString());
        assertEquals("Lyon", lyon.toString());
    }

    @Test
    public void test2() {
        assertTrue(lille.equals(lille));
        assertTrue(lille.equals(new Ville("Lille")));
        assertFalse(lille.equals(lens));
        assertFalse(lille.equals(paris));
        assertFalse(lille.equals(lyon));

        assertTrue(lens.equals(lens));
        assertTrue(lens.equals(new Ville("Lens")));
        assertFalse(lens.equals(lille));
        assertFalse(lens.equals(paris));
        assertFalse(lens.equals(lyon));

        assertTrue(paris.equals(paris));
        assertTrue(paris.equals(new Ville("Paris")));
        assertFalse(paris.equals(lille));
        assertFalse(paris.equals(lens));
        assertFalse(paris.equals(lyon));

        assertTrue(lyon.equals(lyon));
        assertTrue(lyon.equals(new Ville("Lyon")));
        assertFalse(lyon.equals(lille));
        assertFalse(lyon.equals(lens));
        assertFalse(lyon.equals(paris));
    }
}