package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;


public class MainClass {

	public void f ()
	{
		ReadWriteLock lock = new ReentrantReadWriteLock();
		Lock rl = lock.readLock();
//		Lock wl = lock.writeLock();
		try
		{
			rl.lock();
//			boolean res = rl.tryLock();
//			res = rl.tryLock(5, TimeUnit.SECONDS);
			//...
		}
		catch (Exception e) 
		{ 
			//
		}
		finally
		{
			rl.unlock();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(new Runnable()
		{
			public void run()
			{
				int count = 0;
				try
				{
					while (true)
					{
						System.out.println ("Count = " + count++);
						new MainClass().f();
//						Thread.sleep(1000);
						TimeUnit.MILLISECONDS.sleep(1000);
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}				
			}
		}
		);		
		es.shutdown();
		
		String str = null;
		while (!(str = r.readLine()).equals("q"))
		{
		}
		es.shutdownNow();		
		es.awaitTermination(10000, TimeUnit.MILLISECONDS);
	}

}
