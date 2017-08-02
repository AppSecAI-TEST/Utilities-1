import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Messages {
	private static final String NOT_IMPLEMENTED = "Messages not implemented";

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
		Logger.getAnonymousLogger().log(Level.SEVERE, NOT_IMPLEMENTED);
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, NOT_IMPLEMENTED);
			return '!' + key + '!';
		}
	}
}
