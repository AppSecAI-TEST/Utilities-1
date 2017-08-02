package java_beans;

import java.util.*;

public class Sender{

  public Sender() {
  }
  transient private Vector myListeners;
  public synchronized void addMyListener(MyListener l) {
    Vector v = myListeners == null ? new Vector(2) : (Vector) myListeners.clone();
    if (!v.contains(l)) {
      v.addElement(l);
      myListeners = v;
    }
  }
  public synchronized void removeMyListener(MyListener l) {
    if (myListeners != null && myListeners.contains(l)) {
      Vector v = (Vector) myListeners.clone();
      v.removeElement(l);
      myListeners = v;
    }
  }
  protected void fireF(MyEvent e) {
    if (myListeners != null) {
      Vector listeners = myListeners;
      int count = listeners.size();
      for (int i = 0; i < count; i++) {
        ((MyListener) listeners.elementAt(i)).f(e);
      }
    }
  }
  protected void fireG(MyEvent e) {
    if (myListeners != null) {
      Vector listeners = myListeners;
      int count = listeners.size();
      for (int i = 0; i < count; i++) {
        ((MyListener) listeners.elementAt(i)).g(e);
      }
    }
  }
}