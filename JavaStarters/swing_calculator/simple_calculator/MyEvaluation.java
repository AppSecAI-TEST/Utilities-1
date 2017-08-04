package simple_calculator;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class MyEvaluation {
	private static JLabel screenL; 
	static {
		screenL = MyApplication.frame.getCalcScreen();
	}
	
	public boolean validateExpression (String s)
	{
		return true;
	}
	
	public static void sendPressedKey (char c) {
		String str = screenL.getText();
		if (c == 'C')
			str = "0";
		else
			if (c == 'B')
			{
				if (str.length()>1)
					str = str.substring(0, str.length()-1);
				else
					str = "0";
			}
			else 
			{
				if (str.equals("0"))
					str = ""; 
				str = str + c;
			}
		if (new MyEvaluation().validateExpression (str))
			screenL.setText(str);
	}
}
