package threads_test;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MyMainClass extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel workPanel = null;

	private JLabel timeLabel = null;

	private JButton startButton = null;

	private JButton suspendButton = null;

	private JButton resumeButton = null;

	private JButton stopButton = null;

	/**
	 * This method initializes workPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getWorkPanel() {
		if (workPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setHgap(10);
			gridLayout.setVgap(10);
			gridLayout.setColumns(1);
			timeLabel = new JLabel();
			timeLabel.setText("");
			timeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			timeLabel.setPreferredSize(new Dimension(150, 30));
			timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			timeLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			workPanel = new JPanel();
			workPanel.setLayout(gridLayout);
			workPanel.setPreferredSize(new Dimension(200, 0));
			workPanel.add(timeLabel, null);
			workPanel.add(getStartButton(), null);
			workPanel.add(getSuspendButton(), null);
			workPanel.add(getResumeButton(), null);
			workPanel.add(getStopButton(), null);
		}
		return workPanel;
	}

	/**
	 * This method initializes startButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getStartButton() {
		if (startButton == null) {
			startButton = new JButton();
			startButton.setName("Start");
			startButton.setText("Start");
			startButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					startThread ();
				}
			});
		}
		return startButton;
	}

	/**
	 * This method initializes suspendButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSuspendButton() {
		if (suspendButton == null) {
			suspendButton = new JButton();
			suspendButton.setText("Suspend");
			suspendButton.setName("Suspend");
			suspendButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					suspendThread();
				}
			});
		}
		return suspendButton;
	}

	/**
	 * This method initializes resumeButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getResumeButton() {
		if (resumeButton == null) {
			resumeButton = new JButton();
			resumeButton.setName("Resume");
			resumeButton.setText("Resume");
			resumeButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					resumeThread();
				}
			});
		}
		return resumeButton;
	}

	/**
	 * This method initializes stopButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getStopButton() {
		if (stopButton == null) {
			stopButton = new JButton();
			stopButton.setName("Stop");
			stopButton.setText("Stop");
			stopButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					stopThread();
				}
			});
		}
		return stopButton;
	}

	/**
	 * This method initializes dummyPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getDummyPanel() {
		if (dummyPanel == null) {
			dummyPanel = new JPanel();
			dummyPanel.setLayout(null);
			dummyPanel.add(getCountField(), null);
			dummyPanel.add(getCountButton(), null);
		}
		return dummyPanel;
	}

	/**
	 * This method initializes countField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCountField() {
		if (countField == null) {
			countField = new JTextField();
			countField.setBounds(new Rectangle(40, 70, 116, 30));
			countField.setHorizontalAlignment(JTextField.TRAILING);
			countField.setText("1000");
		}
		return countField;
	}

	/**
	 * This method initializes countButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCountButton() {
		if (countButton == null) {
			countButton = new JButton();
			countButton.setBounds(new Rectangle(53, 121, 90, 22));
			countButton.setName("Begin");
			countButton.setText("Begin");
			countButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					countdown ();
				}
			});
		}
		return countButton;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				thisClass = new MyMainClass();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MyMainClass() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("Потоки и Swing");
		this.setName("myFrame");
		this.setBounds(new Rectangle(0, 0, 400, 300));
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
			jContentPane.add(getWorkPanel(), BorderLayout.WEST);
			jContentPane.add(getDummyPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	  private static MyMainClass thisClass = null;
	  
	  public static MyMainClass getMyClass () 
	  {
		  return thisClass; 
	  }
	  
	  private MyThread myThread;  //  @jve:decl-index=0:

	private JPanel dummyPanel = null;

	private JTextField countField = null;

	private JButton countButton = null;
	  
	  
	  public synchronized void setCurrentTime ()
	  {
	    String myString = java.text.DateFormat.getTimeInstance().format(new Date());
	    timeLabel.setText (myString);
	  }

	  public void startThread()
	  {
//		  if (myThread != null) 
//		  {
		    myThread = new MyThread();
		    myThread.setPriority(Thread.NORM_PRIORITY);
		    myThread.start();
//		  }
	  }
	  
	  public void stopThread ()
	  {
//		  myThread.stop();
		  myThread.terminate();
	  }
	  
	  public void suspendThread ()
	  {
//		  myThread.suspend();
		  myThread.suspended = true;
	  }
	  
	  public void resumeThread()
	  {
//	    myThread.resume();
		    try
		    {
		        synchronized (myThread) {
		        	myThread.suspended = false;
		        	myThread.notify();
		        }
		    }
		    catch (Exception exc)
		    {
		    }
	  }
	  
	  public void countdown ()
	  {
		  final int n = Integer.parseInt(countField.getText());

		    Thread workHard = new Thread()
		    {
		      public void run()
		      {
		        updateComponent(n);
		      }
		    };
		    workHard.start();
	  }
	  
	  public void updateComponent (int n)
	  {
	    while (n > 0)
	    {
	      n--;
	      countField.setText(String.valueOf(n));
//	      Thread.yield();
/*
	      try
	      {
	        Thread.sleep(1);
	      }
	      catch (InterruptedException e){e.printStackTrace();}
*/
	    }
	  }
}  //  @jve:decl-index=0:visual-constraint="10,10"
