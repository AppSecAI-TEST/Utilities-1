import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// ���� ����� ����� �������� ��������� � ��������
class KeyL implements KeyListener {
	// ������ �������
	public void keyTyped(KeyEvent k) {
		System.out.println(k);
	}
	// ������� �������
	public void keyPressed(KeyEvent k) {
		System.out.println(k);
	}
	// ���������� ������� �������
	public void keyReleased(KeyEvent k) {
		System.out.println(k);
	}
}
