import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(standardOut);
    }

    @Test
    public void testMain() {
        Main.main(new String[]{});
        assertEquals("Hello World!", outputStreamCaptor.toString().trim());
    }
}