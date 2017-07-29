// FactoryEvents.java
// Использование фабрики классов повышает
// гибкость программы
import javax.swing.*;
import java.awt.event.*;

public class FactoryEvents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8601084987018213315L;
	// ссылка на нашу фабрику
	private ListenerFactory factory = new ListenerFactory();
	
	public FactoryEvents() {
		super("FactoryEvents");		
		// событие при закрытии окна получаем от фабрики
		addWindowListener(factory.getWindowL());
		// добавим кнопку
		JButton button = new JButton("Нажмите меня");
		getContentPane().add(button);
		// слушатель кнопки также создается фабрикой
		button.addActionListener(factory.getButtonL());
		// выводим окно на экран
		pack();
		setVisible(true);
	}	
	public static void main(String[] args) {
		new FactoryEvents();	
	}
}
// фабрика классов
class ListenerFactory {
	// этот метод создает слушателя для кнопки
	public ActionListener getButtonL() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ButtonListener");
			}
		};
	}
	// слушатель оконных событий
	public WindowListener getWindowL() {
		return new WindowL();
	}
	class WindowL extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
