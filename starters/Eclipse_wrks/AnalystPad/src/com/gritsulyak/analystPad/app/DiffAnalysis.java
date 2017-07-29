package com.gritsulyak.analystPad.app;

public class DiffAnalysis implements Analysis{

	Object input;
	Object output;
	
	@Override
	public boolean doAnalysis(Object analysisInput, Object analysisOutput,
			String type) {
		input = analysisInput;
		output = analysisOutput;
		return false; // TOOD not implemented
	}

	@Override
	public void setInput(Object input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doAnalysis() {
		// TODO Auto-generated method stub
		return false;
	}

}
