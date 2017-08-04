package simple_calculator;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.*;

public class MyApplication {
  boolean packFrame = false;
  public static MyCalcFrame frame;

  /**Construct the application*/
  public MyApplication() {
    frame = new MyCalcFrame();
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }
  /**Main method*/
  public static void main(String[] args) {
    try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    	UIManager.setLookAndFeel(new WindowsLookAndFeel());
//    	UIManager.setLookAndFeel(new MotifLookAndFeel());
//    	UIManager.setLookAndFeel(new MetalLookAndFeel());
//
// 		Отличная основа для создания своего LookAndFeel
//		http://www.ibm.com/developerworks/java/library/j-synth/		
//		SynthLookAndFeel synth = new SynthLookAndFeel();
//		synth.load(MySynthFrame.class.getResourceAsStream("demo.xml"), MySynthFrame.class);
//		UIManager.setLookAndFeel(synth);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new MyApplication();
  }
}