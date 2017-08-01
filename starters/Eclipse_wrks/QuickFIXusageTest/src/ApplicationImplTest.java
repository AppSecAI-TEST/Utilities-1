import org.junit.*;
import quickfix.Message;
import quickfix.SessionID;
import static org.junit.Assert.*;

/**
 * The class <code>ApplicationImplTest</code> contains tests for the class <code>{@link ApplicationImpl}</code>.
 *
 * @generatedBy CodePro at 08.10.12 22:37
 * @author Roman
 * @version $Revision: 1.0 $
 */
public class ApplicationImplTest {
	/**
	 * Run the void fromAdmin(Message,SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testFromAdmin_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		Message message = new Message();
		SessionID sessionId = new SessionID();

		fixture.fromAdmin(message, sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
	}

	/**
	 * Run the void fromApp(Message,SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testFromApp_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		Message message = new Message();
		SessionID sessionId = new SessionID();

		fixture.fromApp(message, sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
	}

	/**
	 * Run the void onCreate(SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testOnCreate_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		SessionID sessionId = new SessionID();

		fixture.onCreate(sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
	}

	/**
	 * Run the void onLogon(SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testOnLogon_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		SessionID sessionId = new SessionID();

		fixture.onLogon(sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
	}

	/**
	 * Run the void onLogout(SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testOnLogout_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		SessionID sessionId = new SessionID();

		fixture.onLogout(sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
	}

	/**
	 * Run the void toAdmin(Message,SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testToAdmin_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		Message message = new Message();
		SessionID sessionId = new SessionID();

		fixture.toAdmin(message, sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
	}

	/**
	 * Run the void toApp(Message,SessionID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.10.12 22:37
	 */
	@Test
	public void testToApp_1()
		throws Exception {
		ApplicationImpl fixture = new ApplicationImpl();
		Message message = new Message();
		SessionID sessionId = new SessionID();

		fixture.toApp(message, sessionId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Unsupported QuickFIX feature: use constructor with arguments
		//       at quickfix.SessionID.<init>(SessionID.java:104)
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
		new org.junit.runner.JUnitCore().run(ApplicationImplTest.class);
	}
}