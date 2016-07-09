import exerciseOne.controller.Controller;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExOneTest {
    @Test
    public void checkWords() {
        assertEquals(Controller.findFirstNonRepeatingChar("streets"), 'r');
        assertEquals(Controller.findFirstNonRepeatingChar("aasdd"), 's');
        assertEquals(Controller.findFirstNonRepeatingChar(""), '\0');
    }
}
