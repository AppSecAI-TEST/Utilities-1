package java_beans;

public class Receiver implements MyListener{

  public Receiver() {
  }
  public void f(MyEvent e) {
	  System.out.println("�������� ������� f, �����������: " + (String)e.getSource() + "; �����: " + e.getText());
  }
  public void g(MyEvent e) {
	  System.out.println("�������� ������� g, �����������: " + (String)e.getSource() + "; �����: " + e.getText());
  }
}