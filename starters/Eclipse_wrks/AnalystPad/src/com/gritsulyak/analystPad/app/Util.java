package com.gritsulyak.analystPad.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
// TODO think about other ops
	// add in project console, ability to rename tabs,
	// console commands to remove tabs
	// gui ways to configure
	// diff <tab> <tab> <outtab> classic diff
	// assign op <input> <input> <output> - assign automatic op for input and output
	// op=diff for example
	// bgcolor tab - set bg color 
	// fgcolor tab - set fg color of tab
	// defaultpreprocessor <tab> - preprocesses tab by default preprocessor
	// make architecture for this
	// colorize op  <colorizer> <outputopname>
	// define complex command:
	// define <comname> op <opfilter> <tabname1><tabfilter> <tabname2> .. <tabname3>
	// onchange <tab> 
	
	public boolean processCommand(String input){
		Pattern whitespace = Pattern.compile("\\s+");
		Matcher matcher = whitespace.matcher(input);
		String temp = matcher.replaceAll(" ");
		String[] commandParts = temp.split(" ");
		if(commandParts.length==0)
			return false;
		// parser
		ProcessorBuilder processorBuilder = getBuilder(commandParts[0]);
		
		buildProcessor(commandParts, processorBuilder);
		return true; // TODO
	}
	
	public ProcessorBuilder getBuilder(String builderType){
		// TODO
		return new DefaultProcessorBuilder();
	}
	
	// TODO build Processor class from operableItems () by builder passed 
	public Processor buildProcessor(String[] commandParts, ProcessorBuilder builder){
		return builder.getProcessor(commandParts);
	}
}
