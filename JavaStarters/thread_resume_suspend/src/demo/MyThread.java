package demo;

import java.io.*;

public class MyThread extends Thread {

	private boolean suspended = false;
	private boolean terminated = false;
	
	public MyThread()
	{
		suspended = false;
		terminated = false;
	}
	
	public MyThread (boolean susp)
	{
		suspended = susp;
		terminated = false;		
	}
	
	public void terminate ()
	{
		terminated = true;
	}
	
	public void my_suspend ()
	{
		if (!suspended)
		{
			suspended = true;
		}
	}
	
	public void my_resume ()
	{
		if (suspended)
		{
			suspended = false;
			synchronized(this)
			{
				notify();
			}
		}
	}

	public boolean is_suspended()
	{
		return suspended;
	}
	
@Override
	public void run()
	{
		int count = 0;
		try
		{
			while (!terminated)
			{
				synchronized (this)
				{
					while (suspended)
						wait();
				}
				System.out.println ("Count = " + count++);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
		MyThread thr = new MyThread();
		thr.start();
		
		String str = null;
		while (!(str = r.readLine()).equals("q"))
		{
			if (thr.is_suspended())
				thr.my_resume();
			else
				thr.my_suspend();
		}
		thr.my_resume();
		thr.terminate();
		
//		Thread.State status = thr.getState();  
//		thr.interrupt();
		
		thr.join();
		
	}

}
