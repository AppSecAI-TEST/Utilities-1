// InnerClassEvents.java
// Внутренние классы для обработки событий
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
		// при закрытии окна - выход
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// последовательное расположение
		getContentPane().setLayout(new FlowLayout());
		// добавим текстовое поле
		getContentPane().add(text = new JTextField(10));
		// и кнопку
		getContentPane().add(button = new JButton("Нажмите"));
		// будем следить за нажатиями кнопки
		button.addActionListener(new ButtonL());
		// выводим окно на экран
		pack();
		setVisible(true);
	}
	private JTextField text;
	private JButton button;
	// класс - слушатель нажатия на кнопку
	class ButtonL implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			System.out.println(text.getText());
		}
	}
	public static void main(String[] args) {
		new InnerClassEvents();	
	}
}
