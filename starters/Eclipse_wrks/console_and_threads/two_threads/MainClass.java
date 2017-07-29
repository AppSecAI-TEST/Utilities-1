package two_threads;

public class MainClass
{

  public MainClass()
  {
  }
  public static void main(String[] args)
  {
    Object o = new Object();
    ThreadOne thr1 = new ThreadOne (o);
    ThreadTwo thr2 = new ThreadTwo (o);

    thr1.start();
    thr2.getThread().start();

    try
    {
      thr1.join();
      thr2.getThread().join();
    }
    catch (InterruptedException e) { e.printStackTrace();}
  }
}