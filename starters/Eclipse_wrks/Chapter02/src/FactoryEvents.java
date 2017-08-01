// FactoryEvents.java
// ������������� ������� ������� ��������
// �������� ���������
import javax.swing.*;
import java.awt.event.*;

public class FactoryEvents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8601084987018213315L;
	// ������ �� ���� �������
	private ListenerFactory factory = new ListenerFactory();
	
	public FactoryEvents() {
		super("FactoryEvents");		
		// ������� ��� �������� ���� �������� �� �������
		addWindowListener(factory.getWindowL());
		// ������� ������
		JButton button = new JButton("������� ����");
		getContentPane().add(button);
		// ��������� ������ ����� ��������� ��������
		button.addActionListener(factory.getButtonL());
		// ������� ���� �� �����
		pack();
		setVisible(true);
	}	
	public static void main(String[] args) {
		new FactoryEvents();	
	}
}
// ������� �������
class ListenerFactory {
	// ���� ����� ������� ��������� ��� ������
	public ActionListener getButtonL() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ButtonListener");
			}
		};
	}
	// ��������� ������� �������
	public WindowListener getWindowL() {
		return new WindowL();
	}
	class WindowL extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
