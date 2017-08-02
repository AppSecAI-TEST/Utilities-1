package two_threads;

public class ThreadTwo implements Runnable
{
  private Object monitor;
  private Thread thread;

  public Thread getThread ()
  {
    return thread;
  }

  public ThreadTwo(Object arg)
  {
    monitor = arg;
    thread = new Thread (this);
  }
  public void run()
  {
    try
    {
    for (int i = 0; i < 40; i++)
    {
      System.out.println(2);
      synchronized (monitor)
      {
        monitor.notify();
        if (i < 39)
          monitor.wait();
      }
    }
    }
    catch (InterruptedException e) { e.printStackTrace(); }
  }
}