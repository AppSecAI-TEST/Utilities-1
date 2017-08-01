package threads_test;

public class MyThread extends Thread {
  Thread mthr = null;
  boolean terminated = false;
  boolean suspended = false;

  public MyThread() {
    mthr = new Thread();
    terminated = false;
    suspended = false;
  }

  public void terminate ()
  {
    terminated = true;
  }

  public void run()
  {
    try
    {
      while (!terminated)
      {
        synchronized(this)
        {
          while (suspended)
            wait();
        }
        MyMainClass.getMyClass().setCurrentTime();
        this.sleep(1000);
      }
    }
    catch (java.lang.InterruptedException e)
    {
    }
  }
}