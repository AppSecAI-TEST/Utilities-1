package two_threads;

public class ThreadOne extends Thread {

  private Object monitor;
  public ThreadOne(Object arg)
  {
    monitor = arg;
  }

  public void run ()
  {
    try
    {
    for (int i = 0; i < 40; i++)
    {
      System.out.println(1);
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