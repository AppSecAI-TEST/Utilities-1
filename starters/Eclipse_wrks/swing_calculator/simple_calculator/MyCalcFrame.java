package simple_calculator;

//import java.awt.AWTEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.beans.PropertyChangeListener;
import java.lang.Object;
import java.lang.String;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class MyCalcFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel screenPanel = null;

	private JPanel otherPanel = null;

	private JPanel decorPanel = null;

	private JLabel screenLabel = null;

	private JPanel cbPanel = null;

	private JMenuBar cMenuBar = null;

	private JMenu lfMenu = null;

	private JMenuItem wsMenuItem = null;

	private JMenuItem motifsMenuItem = null;

	private JMenuItem metalsMenuItem = null;

	private JMenu exitMenu = null;

	private JPanel operPanel = null;

	private JPanel numPanel = null;

	private JButton clearButton = null;

	private JButton backspaceButton = null;

	private JButton addButton = null;

	private JButton subButton = null;

	private JButton mulButton = null;

	private JButton divButton = null;

	private JButton equaljButton = null;

	private JButton oneButton = null;

	private JButton twoButton = null;

	private JButton threeButton = null;

	private JButton fourButton = null;

	private JButton fiveButton = null;

	private JButton sixButton = null;

	private JButton sevenButton = null;

	private JButton eightButton = null;

	private JButton nineButton = null;

	private JButton zeroButton = null;

	private JButton signButton = null;

	private JButton sepButton = null;

	/**
	 * This is the default constructor
	 */
	public MyCalcFrame() {
		super();
		initialize();
//		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}
	
	public JLabel getCalcScreen () {
		return screenLabel;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getCMenuBar());
		this.setTitle("Калькулятор");
		this.setName("myFrame");
		this.setBounds(new Rectangle(0, 0, 300, 450));
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				if (e.getID() == WindowEvent.WINDOW_CLOSING)
					System.exit(0);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getScreenPanel(), BorderLayout.NORTH);
			jContentPane.add(getOtherPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes screenPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getScreenPanel() {
		if (screenPanel == null) {
			screenPanel = new JPanel();
			screenPanel.setLayout(new FlowLayout());
			screenPanel.setPreferredSize(new Dimension(40, 40));
			screenPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			screenPanel.add(getDecorPanel(), null);
		}
		return screenPanel;
	}

	/**
	 * This method initializes otherPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getOtherPanel() {
		if (otherPanel == null) {
			otherPanel = new JPanel();
			otherPanel.setLayout(new BorderLayout());
			otherPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			otherPanel.add(getCbPanel(), BorderLayout.NORTH);
			otherPanel.add(getOperPanel(), BorderLayout.EAST);
			otherPanel.add(getNumPanel(), BorderLayout.CENTER);
		}
		return otherPanel;
	}

	/**
	 * This method initializes decorPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getDecorPanel() {
		if (decorPanel == null) {
			screenLabel = new JLabel();
			screenLabel.setText("0");
			screenLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
			screenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			screenLabel.setBackground(Color.white);
			screenLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			screenLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			screenLabel.setName("scrLabel");
			decorPanel = new JPanel();
			decorPanel.setLayout(new BorderLayout());
			decorPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			decorPanel.setPreferredSize(new Dimension(270, 28));
			decorPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			decorPanel.add(screenLabel, BorderLayout.CENTER);
		}
		return decorPanel;
	}

	/**
	 * This method initializes cbPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCbPanel() {
		if (cbPanel == null) {
			cbPanel = new JPanel();
			cbPanel.setLayout(new FlowLayout());
			cbPanel.setPreferredSize(new Dimension(0, 60));
			cbPanel.setName("servPanel");
			cbPanel.add(getClearButton(), null);
			cbPanel.add(getBackspaceButton(), null);
		}
		return cbPanel;
	}

	/**
	 * This method initializes cMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getCMenuBar() {
		if (cMenuBar == null) {
			cMenuBar = new JMenuBar();
			cMenuBar.add(getLfMenu());
			cMenuBar.add(getExitMenu());
		}
		return cMenuBar;
	}

	/**
	 * This method initializes lfMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getLfMenu() {
		if (lfMenu == null) {
			lfMenu = new JMenu();
			lfMenu.setActionCommand("LookAndFeel");
			lfMenu.setText("Стиль отображения");
			lfMenu.add(getWsMenuItem());
			lfMenu.add(getMotifsMenuItem());
			lfMenu.add(getMetalsMenuItem());
		}
		return lfMenu;
	}

	/**
	 * This method initializes wsMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getWsMenuItem() {
		if (wsMenuItem == null) {
			wsMenuItem = new JMenuItem();
			wsMenuItem.setText("Windows");
			wsMenuItem.setName("wsMI");
			wsMenuItem.setActionCommand("WindowsStyle");
			wsMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						SwingUtilities.updateComponentTreeUI(MyApplication.frame);
					} 
					catch (Exception excep) { excep.printStackTrace(); }	
				}
			});
		}
		return wsMenuItem;
	}

	/**
	 * This method initializes motifsMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMotifsMenuItem() {
		if (motifsMenuItem == null) {
			motifsMenuItem = new JMenuItem();
			motifsMenuItem.setActionCommand("MotifStyle");
			motifsMenuItem.setName("motifsMI");
			motifsMenuItem.setText("Motif");
			motifsMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					try {
						UIManager.setLookAndFeel(new MotifLookAndFeel());
						SwingUtilities.updateComponentTreeUI(MyApplication.frame);
					} 
					catch (Exception excep) { excep.printStackTrace(); }	
				}
			});
		}
		return motifsMenuItem;
	}

	/**
	 * This method initializes metalsMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMetalsMenuItem() {
		if (metalsMenuItem == null) {
			metalsMenuItem = new JMenuItem();
			metalsMenuItem.setActionCommand("MetalStyle");
			metalsMenuItem.setText("Metal");
			metalsMenuItem.setName("metalsMI");
			metalsMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					try {
						UIManager.setLookAndFeel(new MetalLookAndFeel());
						SwingUtilities.updateComponentTreeUI(MyApplication.frame);
					} 
					catch (Exception excep) { excep.printStackTrace(); }	
				}
			});
		}
		return metalsMenuItem;
	}

	/**
	 * This method initializes exitMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getExitMenu() {
		if (exitMenu == null) {
			exitMenu = new JMenu();
			exitMenu.setActionCommand("Exit");
			exitMenu.setName("exMenu");
			exitMenu.setText("Выход");
			exitMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			exitMenu.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
//					System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					System.exit(0);
				}
				public void mousePressed(java.awt.event.MouseEvent e) {
				}
				public void mouseReleased(java.awt.event.MouseEvent e) {
				}
				public void mouseEntered(java.awt.event.MouseEvent e) {
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return exitMenu;
	}

	/**
	 * This method initializes operPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getOperPanel() {
		if (operPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setVgap(4);
			gridLayout.setHgap(4);
			gridLayout.setColumns(1);
			operPanel = new JPanel();
			operPanel.setLayout(gridLayout);
			operPanel.setPreferredSize(new Dimension(60, 0));
			operPanel.add(getAddButton(), null);
			operPanel.add(getSubButton(), null);
			operPanel.add(getDivButton(), null);
			operPanel.add(getMulButton(), null);
			operPanel.add(getEqualjButton(), null);
		}
		return operPanel;
	}

	/**
	 * This method initializes numPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getNumPanel() {
		if (numPanel == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setHgap(10);
			gridLayout1.setVgap(10);
			gridLayout1.setColumns(3);
			numPanel = new JPanel();
			numPanel.setName("numPanel");
			numPanel.setLayout(gridLayout1);
			numPanel.add(getOneButton(), null);
			numPanel.add(getTwoButton(), null);
			numPanel.add(getThreeButton(), null);
			numPanel.add(getFourButton(), null);
			numPanel.add(getFiveButton(), null);
			numPanel.add(getSixButton(), null);
			numPanel.add(getSevenButton(), null);
			numPanel.add(getEightButton(), null);
			numPanel.add(getNineButton(), null);
			numPanel.add(getZeroButton(), null);
			numPanel.add(getSignButton(), null);
			numPanel.add(getSepButton(), null);
		}
		return numPanel;
	}

	/**
	 * This method initializes clearButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton();
			clearButton.setPreferredSize(new Dimension(50, 50));
			clearButton.setText("C");
			clearButton.setActionCommand("C");
			clearButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); 
					MyEvaluation.sendPressedKey('C');
				}
			});
			clearButton.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER) {
//						System.out.println("keyTyped()"); 
						MyEvaluation.sendPressedKey('C');
					}
				}
			});
		}
		return clearButton;
	}

	/**
	 * This method initializes backspaceButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBackspaceButton() {
		if (backspaceButton == null) {
			backspaceButton = new JButton();
			backspaceButton.setActionCommand("ERASE");
			backspaceButton.setText("Backspace");
			backspaceButton.setPreferredSize(new Dimension(150, 50));
			backspaceButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					MyEvaluation.sendPressedKey('B');
				}
			});
			backspaceButton.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER) {
//						System.out.println("keyTyped()"); 
						MyEvaluation.sendPressedKey('B');
					}
				}
			});
		}
		return backspaceButton;
	}

	/**
	 * This method initializes addButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setActionCommand("+");
			addButton.setFont(new Font("Dialog", Font.BOLD, 18));
			addButton.setName("+");
			addButton.setText("+");
		}
		return addButton;
	}

	/**
	 * This method initializes subButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSubButton() {
		if (subButton == null) {
			subButton = new JButton();
			subButton.setFont(new Font("Dialog", Font.BOLD, 18));
			subButton.setName("-");
			subButton.setText("-");
		}
		return subButton;
	}

	/**
	 * This method initializes mulButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMulButton() {
		if (mulButton == null) {
			mulButton = new JButton();
			mulButton.setFont(new Font("Dialog", Font.BOLD, 18));
			mulButton.setName("/");
			mulButton.setText("/");
		}
		return mulButton;
	}

	/**
	 * This method initializes divButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDivButton() {
		if (divButton == null) {
			divButton = new JButton();
			divButton.setText("*");
			divButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			divButton.setName("*");
			divButton.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return divButton;
	}

	/**
	 * This method initializes equaljButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEqualjButton() {
		if (equaljButton == null) {
			equaljButton = new JButton();
			equaljButton.setText("=");
			equaljButton.setName("=");
			equaljButton.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return equaljButton;
	}

	/**
	 * This method initializes oneButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOneButton() {
		if (oneButton == null) {
			oneButton = new JButton();
			oneButton.setText("1");
			oneButton.setFont(new Font("Dialog", Font.BOLD, 18));
			oneButton.setName("1");
			oneButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			oneButton.setActionCommand("1");
			oneButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()");
					MyEvaluation.sendPressedKey('1');
				}
			});
			oneButton.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER) {
//						System.out.println("keyTyped()"); 
						MyEvaluation.sendPressedKey('1');
					}
				}
			});
		}
		return oneButton;
	}

	/**
	 * This method initializes twoButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getTwoButton() {
		if (twoButton == null) {
			twoButton = new JButton();
			twoButton.setFont(new Font("Dialog", Font.BOLD, 18));
			twoButton.setName("2");
			twoButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			twoButton.setText("2");
			twoButton.setActionCommand("2");
		}
		return twoButton;
	}

	/**
	 * This method initializes threeButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getThreeButton() {
		if (threeButton == null) {
			threeButton = new JButton();
			threeButton.setFont(new Font("Dialog", Font.BOLD, 18));
			threeButton.setName("3");
			threeButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			threeButton.setText("3");
		}
		return threeButton;
	}

	/**
	 * This method initializes fourButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFourButton() {
		if (fourButton == null) {
			fourButton = new JButton();
			fourButton.setFont(new Font("Dialog", Font.BOLD, 18));
			fourButton.setText("4");
			fourButton.setName("4");
		}
		return fourButton;
	}

	/**
	 * This method initializes fiveButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFiveButton() {
		if (fiveButton == null) {
			fiveButton = new JButton();
			fiveButton.setFont(new Font("Dialog", Font.BOLD, 18));
			fiveButton.setText("5");
			fiveButton.setName("5");
		}
		return fiveButton;
	}

	/**
	 * This method initializes sixButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSixButton() {
		if (sixButton == null) {
			sixButton = new JButton();
			sixButton.setFont(new Font("Dialog", Font.BOLD, 18));
			sixButton.setName("6");
			sixButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			sixButton.setText("6");
		}
		return sixButton;
	}

	/**
	 * This method initializes sevenButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSevenButton() {
		if (sevenButton == null) {
			sevenButton = new JButton();
			sevenButton.setFont(new Font("Dialog", Font.BOLD, 18));
			sevenButton.setText("7");
			sevenButton.setName("7");
		}
		return sevenButton;
	}

	/**
	 * This method initializes eightButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEightButton() {
		if (eightButton == null) {
			eightButton = new JButton();
			eightButton.setFont(new Font("Dialog", Font.BOLD, 18));
			eightButton.setName("8");
			eightButton.setText("8");
		}
		return eightButton;
	}

	/**
	 * This method initializes nineButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getNineButton() {
		if (nineButton == null) {
			nineButton = new JButton();
			nineButton.setFont(new Font("Dialog", Font.BOLD, 18));
			nineButton.setText("9");
			nineButton.setName("9");
		}
		return nineButton;
	}

	/**
	 * This method initializes zeroButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getZeroButton() {
		if (zeroButton == null) {
			zeroButton = new JButton();
			zeroButton.setFont(new Font("Dialog", Font.BOLD, 18));
			zeroButton.setName("0");
			zeroButton.setText("0");
		}
		return zeroButton;
	}

	/**
	 * This method initializes signButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSignButton() {
		if (signButton == null) {
			signButton = new JButton();
			signButton.setFont(new Font("Dialog", Font.BOLD, 18));
			signButton.setName("+/-");
			signButton.setText("+/-");
		}
		return signButton;
	}

	/**
	 * This method initializes sepButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSepButton() {
		if (sepButton == null) {
			sepButton = new JButton();
			sepButton.setFont(new Font("Dialog", Font.BOLD, 18));
			sepButton.setName(",");
			sepButton.setText(",");
		}
		return sepButton;
	}

}
