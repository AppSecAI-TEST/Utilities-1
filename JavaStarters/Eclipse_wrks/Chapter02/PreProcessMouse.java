// PreProcessMouse.java
// �������� ������� �� ���� �� �� ����������� � ����������
import javax.swing.*;
import java.awt.event.*;

public class PreProcessMouse extends JFrame {
	PreProcessMouse() {
		super("PreProcessMouse");
		// ��� �������� ���� - �����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������� ��������� ������� �� ����
		addMouseListener(new MouseL());
		// ������� ���� �� �����
		setSize(200, 200);
		setVisible(true);
	}
	// �������� ������� �� ����
	public void processMouseEvent(MouseEvent e) {
		if ( e.getClickCount() == 1 ) {
			// ���� ������ �� ���������� � ����������
			return;
		}
		// ����� �������� ����� �������� ������
		else super.processMouseEvent(e);
	}	
	// � ���� ��������� ����� ������� �� �������� ����
	class MouseL extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.out.println(
				"ClickCount: " + e.getClickCount());
		}
	}
	public static void main(String[] args) {
		new PreProcessMouse();
	}
}
