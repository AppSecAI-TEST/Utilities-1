package com.gritsulyak.analystPad.app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.FutureTask;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.Highlight;
import javax.swing.text.JTextComponent;

import difflib.Chunk;
import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

/* 
 * panel1
 * panel2
 * ....[+]
 * panels diff/anomaly
 * */

public class MainFrame extends JFrame {

	JTextArea textArea_1;
	JTextArea textArea_2;
	JTextArea textArea;
	private String diffString = "";

	// TODO externalize
	private static final String IMPLEMENTATION_OF_ANALYST_PAD = "implementation of analyst pad";

	/**
	 * generated id
	 * 
	 */

	public class ChangeListener implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
			warn();
		}

		public void removeUpdate(DocumentEvent e) {
			warn();
		}

		public void insertUpdate(DocumentEvent e) {
			warn();
		}
	}

	public void warn() {
		String str1 = textArea_1.getText();
		String str2 = textArea_2.getText();
	
		String[] arr1 = str1.split("\n");
		String[] arr2 = str2.split("\n");
	
		List<String> v1 = Arrays.asList(arr1);
		List<String> v2 = Arrays.asList(arr2);
		Patch patch = DiffUtils.diff(v1, v2);
		List<Delta> deltas = patch.getDeltas();
		String text = deltas.toString();
	
		textArea.setText(text);
		
		 String text1=null;
			try {
				text1 = textArea_1.getDocument().getText(0, textArea_1.getDocument().getLength());
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
		// do deep analysis
		// First remove all old highlights
		removeHighlights(textArea_1);
		
		 for(Delta de : deltas){ 
			 Chunk ch1 = de.getOriginal(); 
			 int strpos = ch1.getPosition(); 
			 int strlen  = ch1.size();
	
	
			 String findStr = "\n";
			 int startPos=0;
			 for(int i=0; i<strpos; i++){
			  startPos = text1.indexOf(findStr,startPos+1);
			 }
			 int endPos=startPos;
			 for(int i=0; i<strlen; i++){
				  endPos = text1.indexOf(findStr,endPos+1);
			 }
			 
			 highlight(textArea_1, startPos, endPos, redHighlightPainter);
			 
			 Chunk ch2 = de.getRevised();
			 List<?> lines1 = ch1.getLines();
			 List<?> lines2 = ch2.getLines();
		 }
		 
		
	
	}

	public void highlight(JTextComponent textComp, int pos, int endpos, Highlighter.HighlightPainter hi ) {


		try {
			Highlighter hilite = textComp.getHighlighter();
			Document doc = textComp.getDocument();
			String text = doc.getText(0, doc.getLength());

			// Search for pattern
			hilite.addHighlight(pos, endpos,
						hi);
	

		} catch (BadLocationException e) {
		}
	}

	// Removes only our private highlights
	public void removeHighlights(JTextComponent textComp) {
		Highlighter hilite = textComp.getHighlighter();
		Highlighter.Highlight[] hilites = hilite.getHighlights();

		for (int i = 0; i < hilites.length; i++) {
			if (hilites[i].getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {
				hilite.removeHighlight(hilites[i]);
			}
		}
	}

	// An instance of the private subclass of the default highlight painter
	Highlighter.HighlightPainter redHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
			Color.red);
	Highlighter.HighlightPainter greenHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
			Color.green);

	ChangeListener listener = new ChangeListener();

	static MainFrame mainFrame;

	private static final long serialVersionUID = -2899588230757235279L;

	public MainFrame() {
		super();
		
	}

	public void jInit(){
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		JLabel lblData = new JLabel("data1");
		panel.add(lblData);

		textArea_1 = new JTextArea();
		textArea_1.setRows(5);
		textArea_1.setColumns(80);
		panel.add(textArea_1);

		textArea_1.getDocument().addDocumentListener(listener);

		JLabel lblData_1 = new JLabel("data2");
		panel.add(lblData_1);
		textArea_2 = new JTextArea();
		textArea_2.setRows(5);
		textArea_2.setColumns(80);
		panel.add(textArea_2);

		textArea_2.getDocument().addDocumentListener(listener);

		JLabel lblData_2 = new JLabel("diff data1 data2");
		panel.add(lblData_2);

		textArea = new JTextArea();
		textArea.setColumns(80);
		textArea.setRows(5);
		panel.add(textArea);
		setSize(800, 600);
		setLocationRelativeTo(null); 
		// Size the frame.
		pack();

		// Show it.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		String string = IMPLEMENTATION_OF_ANALYST_PAD;
		// System.out.println(string);

		MainFrame.mainFrame = new MainFrame();

		JFrame frame = mainFrame;

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame.mainFrame.jInit();
            }
        });
	}

}
