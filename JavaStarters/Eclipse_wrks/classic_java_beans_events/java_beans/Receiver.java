package java_beans;

public class Receiver implements MyListener{

  public Receiver() {
  }
  public void f(MyEvent e) {
	  System.out.println("Получено событие f, отправитель: " + (String)e.getSource() + "; текст: " + e.getText());
  }
  public void g(MyEvent e) {
	  System.out.println("Получено событие g, отправитель: " + (String)e.getSource() + "; текст: " + e.getText());
  }
}