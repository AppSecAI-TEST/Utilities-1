package demo;

import java.text.DateFormat;
import java.util.*;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class MyShell {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="18,5"
	private Button myButton = null;
	private Label myLabel = null;

	private int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Before this is run, be sure to set up the launch configuration (Arguments->VM Arguments)
		 * for the correct SWT library path in order to run with the SWT dlls. 
		 * The dlls are located in the SWT plugin jar.  
		 * For example, on Windows the Eclipse SWT 3.1 plugin jar is:
		 *       installation_directory\plugins\org.eclipse.swt.win32_3.1.0.jar
		 */
		Display display = Display.getDefault();
		MyShell thisClass = new MyShell();
		thisClass.createSShell();
		thisClass.sShell.open();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		FormData formData = new FormData();
		formData.top = new FormAttachment(80, 0);
		formData.left = new FormAttachment(40, 0);
		FormData formData_lab = new FormData();
		formData_lab.top = new FormAttachment(50, 0);
		formData_lab.width = 100;
		formData_lab.left = new FormAttachment(40, 0);
		FormLayout formLayout = new FormLayout();
		formLayout.spacing = 0;
		formLayout.marginWidth = 5;
		formLayout.marginHeight = 5;
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setLayout(formLayout);
		sShell.setSize(new Point(300, 200));
		myButton = new Button(sShell, SWT.PUSH);
		myButton.setText("OK");
		myButton.setLayoutData(formData);
		myButton.setToolTipText("This is a good button!");
		myLabel = new Label(sShell, SWT.SHADOW_OUT | SWT.BORDER | SWT.HORIZONTAL | SWT.WRAP);
		myLabel.setText("");
		myLabel.setLayoutData(formData_lab);
		myButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				count++;
				System.out.println("widgetSelected(), count = " + count);
//				myLabel.setText("Button was pressed " + count + " times");
				
				DateFormat df  = 
					DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.GERMANY);				
				String str = df.format(new Date());
				myLabel.setText(str);
				
			}
		});
	}

}
