package java_beans;

import java.util.*;

public class MyEvent extends EventObject {
	
	private String msg;
	
	public MyEvent(Object source, String message) {
		super(source);
		msg = message;
	}
	
	public String getText () {
		return msg;
	}           
}