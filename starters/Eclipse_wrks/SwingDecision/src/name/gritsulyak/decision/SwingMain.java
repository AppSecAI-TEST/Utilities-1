package name.gritsulyak.decision;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import java.awt.Dimension;

public class SwingMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPopupMenu jPopup = null;  //  @jve:decl-index=0:visual-constraint="596,24"
	
	/**
	 * This is the default constructor
	 */
	public SwingMain() {
		super();
		initialize();
	}
	
	public static void main(String[] args)
	{
		SwingMain smMain = new SwingMain();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(574, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Decision Maker Tool");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel0
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jPopup = new JPopupMenu();
			JMenuItem menuItem1 = new JMenuItem("Main");
			JMenuItem menuItem2 = new JMenuItem("End");
			JMenu menu = new JMenu();
			menu.add(menuItem1);
			menu.add(menuItem2);
			jPopup.add(menuItem1);
			jPopup.add(menuItem2);
			jContentPane.add(menu);
			jContentPane.add(jPopup);
			}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="6,20"
