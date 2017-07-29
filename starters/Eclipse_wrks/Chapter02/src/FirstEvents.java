// FirstEvents.java
// События - нажатия клавиш на клавиатуре
import javax.swing.*;
import java.awt.event.*;

public class FirstEvents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirstEvents() {
		super("FirstEvents");
		// при закрытии окна - выход
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// регистрируем нашего слушателя
		addKeyListener(new KeyL());
		// выводим окно на экран
		setSize(200, 200);		
		setVisible(true);
	}
	public static void main(String[] args) {
		new FirstEvents();
	}
}