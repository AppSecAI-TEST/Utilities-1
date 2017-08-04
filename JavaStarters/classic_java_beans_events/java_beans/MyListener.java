package java_beans;

import java.util.*;

public interface MyListener extends EventListener {
  public void f(MyEvent e);
  public void g(MyEvent e);
}