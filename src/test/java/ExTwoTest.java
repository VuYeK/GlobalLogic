import exerciseTwo.base.ConnectDB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExTwoTest {
    @Test
    public void shouldConnectBeSingleton() {
        ConnectDB connectDB = ConnectDB.getInstance();
        ConnectDB connectDB1 = ConnectDB.getInstance();
        assertEquals(connectDB.polaczenie, connectDB1.polaczenie);
    }
}
