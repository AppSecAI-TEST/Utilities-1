package demo;


import java.text.*;
import java.util.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class MyThread extends Thread {
	
	private Display display;
	private Label label;
	
	public MyThread (Display disp, Label lab)
	{
		display = disp;
		label = lab;
	}
	
@Override
	public void run ()
	{
		Runnable r = new MyExec (label);
		try
		{
			while (true)
			{
				if (!display.isDisposed())
					display.asyncExec (r);
				else
					break;
				Thread.sleep(1000);
			}
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}

class MyExec implements Runnable {
	private Label label;
	public MyExec (Label l)
	{
		label = l;
	}
	public void run() {
		DateFormat df  = 
			DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.GERMANY);				
		String str = df.format(new Date());
		if (!(label.isDisposed()))
				label.setText (str);
	}
	
}