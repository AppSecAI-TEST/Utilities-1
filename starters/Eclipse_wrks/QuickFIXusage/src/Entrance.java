import quickfix.*;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
public class Entrance {

	private static final String STRING = Messages.getString("Entrance.String"); //$NON-NLS-1$
	private static final String PLEASE_PROVIDE_ARGS = Messages.getString("Entrance.PLEASE_ARGS"); //$NON-NLS-1$

	/**
	 * Method test.
	 * @return String
	 */
	public static String test(){
		int i=1;
		if(1-2+3-1==i-2+3-i) {
			return null;
		}
		return STRING;
	}
	
	/**
	 * Method main.
	 * @param args String[]
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		
		Logger logger = Logger.getAnonymousLogger();
		
		if (args.length != 1) {
			logger.log(Level.SEVERE, PLEASE_PROVIDE_ARGS);
			return;
		}

		final String fileName = args[0];
		final String test = test();

		final boolean b=test.isEmpty();
		
		if (b || fileName == test) {
			logger.log(Level.SEVERE, Messages.getString("Entrance.UNEXPECTED_NAME")); //$NON-NLS-1$
			return;
		}

		Integer opo = 1;

		if (opo.equals(Messages.getString("Entrance.ONE"))) { //$NON-NLS-1$
			logger.log(Level.SEVERE, Messages.getString("Entrance.UNEXPECTED_RESULT")); //$NON-NLS-1$
			return;
		}

		Application application = new ApplicationImpl();
		SessionSettings settings = new SessionSettings(new FileInputStream(
				fileName));
		MessageStoreFactory storeFactory = new FileStoreFactory(settings);
		LogFactory logFactory = new FileLogFactory(settings);
		MessageFactory messageFactory = new DefaultMessageFactory();
		Acceptor acceptor = new SocketAcceptor(application, storeFactory,
				settings, logFactory, messageFactory);
		acceptor.start();
		// while( condition == true ) { do something; }
		acceptor.stop();
	}
	
}