// FirstEvents.java
// ������� - ������� ������ �� ����������
import javax.swing.*;
import java.awt.event.*;

public class FirstEvents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirstEvents() {
		super("FirstEvents");
		// ��� �������� ���� - �����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������������ ������ ���������
		addKeyListener(new KeyL());
		// ������� ���� �� �����
		setSize(200, 200);		
		setVisible(true);
	}
	public static void main(String[] args) {
		new FirstEvents();
	}
}