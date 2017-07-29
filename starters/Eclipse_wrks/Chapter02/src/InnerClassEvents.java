// InnerClassEvents.java
// ���������� ������ ��� ��������� �������
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassEvents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InnerClassEvents() {
		super("InnerClassEvents");
		// ��� �������� ���� - �����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ���������������� ������������
		getContentPane().setLayout(new FlowLayout());
		// ������� ��������� ����
		getContentPane().add(text = new JTextField(10));
		// � ������
		getContentPane().add(button = new JButton("�������"));
		// ����� ������� �� ��������� ������
		button.addActionListener(new ButtonL());
		// ������� ���� �� �����
		pack();
		setVisible(true);
	}
	private JTextField text;
	private JButton button;
	// ����� - ��������� ������� �� ������
	class ButtonL implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			System.out.println(text.getText());
		}
	}
	public static void main(String[] args) {
		new InnerClassEvents();	
	}
}
