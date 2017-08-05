

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.JDesktopPane;

public class MySwingFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton myButton = null;

	private JLabel myLabel = null;
	
	private int buttonPressedN = 0;
	private final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * This method initializes myButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMyButton() {
		if (myButton == null) {
			myButton = new JButton();
			myButton.setText("������");
			myButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String msg = e.getActionCommand();
					buttonPressedN++;
					myLabel.setText("������ ������ " + buttonPressedN + " ���");				
					System.out.println("actionPerformed() :" + msg); 
				}
			});
			myButton.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						buttonPressedN++;
						myLabel.setText("������ ������ " + buttonPressedN + " ���");
					}
					System.out.println("keyPressed()"); // TODO Auto-generated Event stub keyPressed()
				}
			});
		}
		return myButton;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MySwingFrame thisClass = new MySwingFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MySwingFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(281, 155);
		this.setName("myFrame");
		this.setContentPane(getJContentPane());
		this.setTitle("���� Swing");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			myLabel = new JLabel();
			myLabel.setText("�����");
			myLabel.setPreferredSize(new Dimension(250, 30));
			myLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			myLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jContentPane = new JPanel();
			jContentPane.setLayout(new FlowLayout());
			jContentPane.add(desktopPane);
			jContentPane.add(myLabel, null);
			jContentPane.add(getMyButton(), null);
		}
		return jContentPane;
	}

}
