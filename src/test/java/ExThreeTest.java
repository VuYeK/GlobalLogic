import exerciseThree.controller.Controller;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExThreeTest {
    @Test
    public void checkStrings() {
        assertEquals(Controller.validateInteger("1"), false);
        assertTrue(Controller.validateInteger("a"));
    }
}
