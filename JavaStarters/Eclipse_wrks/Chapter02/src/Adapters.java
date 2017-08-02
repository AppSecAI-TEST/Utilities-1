// Adapters.java
// ������������� ��������� ������ �����������
import javax.swing.*;
import java.awt.event.*;

public class Adapters extends JFrame {
	public Adapters() {
		super("Adapters");
		// ��� �������� ���� - �����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������������ ���������
		addMouseListener(new MouseL());
		// ������� ���� �� �����
		setSize(200, 200);		
		setVisible(true);
	}
	// ��������� �� ��������
	class MouseL extends MouseAdapter {
		// ������ �� �������� ���� � ����
		public void mouseClicked(MouseEvent e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new Adapters();	
	}
}
