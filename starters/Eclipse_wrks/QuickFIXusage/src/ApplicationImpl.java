import java.util.logging.Logger;

import quickfix.*;

/**
 * @author Roman
 * @version $Revision: 1.0 $
 */
public class ApplicationImpl implements Application {

	
	/**
	   * Method onCreate.
	   * @param sessionId SessionID
	  
	   * @see quickfix.Application#onCreate(SessionID) */
	  @Override
	public void onCreate(SessionID sessionId){
		  System.out.print(sessionId);
	  }
	  /**
	   * Method onLogon.
	   * @param sessionId SessionID
	  
	   * @see quickfix.Application#onLogon(SessionID) */
	  @Override
	public void onLogon(SessionID sessionId){
		  System.out.print(sessionId);
	  }
	  /**
	   * Method onLogout.
	   * @param sessionId SessionID
	  
	   * @see quickfix.Application#onLogout(SessionID) */
	  @Override
	public void onLogout(SessionID sessionId){
		  System.out.print(sessionId);
	  }
	  /**
	   * Method toAdmin.
	   * @param message Message
	   * @param sessionId SessionID
	  
	   * @see quickfix.Application#toAdmin(Message, SessionID) */
	  @Override
	public void toAdmin(Message message, SessionID sessionId){
		  System.out.print(sessionId);
	  }
	  /**
	   * Method toApp.
	   * @param message Message
	   * @param sessionId SessionID
	  
	  
	   * @throws DoNotSend * @see quickfix.Application#toApp(Message, SessionID) */
	  @Override
	public void toApp(Message message, SessionID sessionId)
	    throws DoNotSend{
			  System.out.print(sessionId);
		  }
	  /**
	   * Method fromAdmin.
	   * @param message Message
	   * @param sessionId SessionID
	  
	  
	  
	  
	  
	   * @throws FieldNotFound * @throws IncorrectDataFormat * @throws IncorrectTagValue * @throws RejectLogon * @see quickfix.Application#fromAdmin(Message, SessionID) */
	  @Override
	public void fromAdmin(Message message, SessionID sessionId)
	    throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon{
			  System.out.print(sessionId);
		  }
	  /**
	   * Method fromApp.
	   * @param message Message
	   * @param sessionId SessionID
	  
	  
	  
	  
	  
	   * @throws FieldNotFound * @throws IncorrectDataFormat * @throws IncorrectTagValue * @throws UnsupportedMessageType * @see quickfix.Application#fromApp(Message, SessionID) */
	  @Override
	public void fromApp(Message message, SessionID sessionId)
	    throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType{
			  System.out.print(sessionId);
		  }
}
