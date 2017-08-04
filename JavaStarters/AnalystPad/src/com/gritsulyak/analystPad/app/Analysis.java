package com.gritsulyak.analystPad.app;
/*
 * Abstarction of analysis
 * */
public interface Analysis {
	static String ID="Abstract"; 
	
	public boolean doAnalysis ();
	public boolean doAnalysis (Object analysisInput, Object analysisOutput,
			String type);
	public void setInput(Object input);
	public Object getInput();
	
	public Object getOutput();
	public Object setOutput();
}
