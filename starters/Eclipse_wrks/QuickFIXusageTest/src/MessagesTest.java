import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MessagesTest</code> contains tests for the class <code>{@link Messages}</code>.
 *
 * @generatedBy CodePro at 08.10.12 22:37
 * @author Roman
 * @version $Revision: 1.0 $
 */
public class MessagesTest {
	/**
	 * Run the String getString(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testGetString_1()
		throws Exception {
		String key = "";

		String result = Messages.getString(key);

		// add additional test code here
		assertEquals("!!", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MessagesTest.class);
	}
}