// InvokeLater.java
// ћетод invokeLater() и работа с потоком рассылки событий
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvokeLater extends JFrame {
	public InvokeLater() {
		super("InvokeLater");
		// при закрытии окна - выход
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// добавим кнопку со слушателем
		button = new JButton("¬ыполнить сложную работу");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// запустим отдельный поток
				new ComplexJobThread().start();
				button.setText("ѕодождите...");
			}
		});
		// настроим панель содержимого и выведем окно на экран
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JTextField(20));
		getContentPane().add(button);
		setSize(300, 200);
		setVisible(true);
	}
	private JButton button;
	// поток, выполн€ющий "сложную работу"
	class ComplexJobThread extends Thread {
		public void run() {			
			try {
				// изобразим задержку
				sleep(3000);
				// работа закончена, нужно изменить интерфейс
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						button.setText("–абота завершена");
					}
				});
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new InvokeLater();
	}
}
