package threadlocal_samples;

public class MyThreadlocalDemoClass {

	private static int nextValue = 10;
	private static ThreadLocal<Integer> threadLocal =
    	new ThreadLocal<Integer>()
    	{
        	protected synchronized Integer initialValue() 
        	{
        		return new Integer(nextValue++);
        	}
    	};


    public static void main(String args[])
    {
		Runnable runner = new Runnable() 
		{
			public void run() 
			{
//				threadLocal.set((Integer)threadLocal.get() + 1);
				System.out.println("Thread " + Thread.currentThread().getName() + ", value is " + threadLocal.get());
		    }
		};
		       
		for (int i=0; i<3; i++)
			(new Thread (runner)).start();
		       
		System.out.println("Main Thread, value is " + threadLocal.get());
	}
}
