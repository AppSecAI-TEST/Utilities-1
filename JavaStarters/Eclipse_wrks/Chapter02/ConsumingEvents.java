// ConsumingEvents.java
// Поглощение событий
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsumingEvents extends JFrame {
	public ConsumingEvents() {
		super("ConsumingEvents");
		// при закрытии окна - выход
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// прибавляем первого слушателя
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// поглощаем единичное нажатие мыши
				if ( e.getClickCount() == 1 )
					e.consume();
				System.out.println("1");
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// не обрабатываем поглощенное событие
				if ( !e.isConsumed() ) 
					System.out.println("2");
			}
		});
		// выводим окно на экран
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ConsumingEvents();
	}
}
