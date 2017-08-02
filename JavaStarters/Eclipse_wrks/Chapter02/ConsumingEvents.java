// ConsumingEvents.java
// ���������� �������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsumingEvents extends JFrame {
	public ConsumingEvents() {
		super("ConsumingEvents");
		// ��� �������� ���� - �����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ���������� ������� ���������
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// ��������� ��������� ������� ����
				if ( e.getClickCount() == 1 )
					e.consume();
				System.out.println("1");
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// �� ������������ ����������� �������
				if ( !e.isConsumed() ) 
					System.out.println("2");
			}
		});
		// ������� ���� �� �����
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ConsumingEvents();
	}
}
