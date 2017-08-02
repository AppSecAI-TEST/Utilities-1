package awt_demo;

import java.awt.Frame;
import java.awt.Window;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Button;

public class MyAWTFrame extends Window {

	private static final long serialVersionUID = 1L;
	private JButton MyButton = null;
	private Button exitButton = null;

	/**
	 * This method initializes MyButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMyButton() {
		if (MyButton == null) {
			MyButton = new JButton();
			MyButton.setPreferredSize(new Dimension(34, 20));
			MyButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MyButton;
	}

	/**
	 * This method initializes exitButton	
	 * 	
	 * @return java.awt.Button	
	 */
	private Button getExitButton() {
		if (exitButton == null) {
			exitButton = new Button();
			exitButton.setLabel("Exit");
			exitButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return exitButton;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyAWTFrame frame = new MyAWTFrame(null);
		frame.setVisible(true);
	}

	/**
	 * @param owner
	 */
	public MyAWTFrame(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.add(getMyButton(), BorderLayout.NORTH);
		this.add(getExitButton(), BorderLayout.SOUTH);
	}
	public boolean handleEvent(java.awt.Event evt)
	  {
	    if(evt.id == java.awt.Event.WINDOW_DESTROY)
	    {
	      setVisible(false);
	      System.exit(0);
	      return true;
	    }
	    else
	      return super.handleEvent(evt);
	  }
	
}
