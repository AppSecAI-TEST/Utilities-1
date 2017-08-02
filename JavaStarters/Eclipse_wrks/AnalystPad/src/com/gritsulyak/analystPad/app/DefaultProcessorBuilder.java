package com.gritsulyak.analystPad.app;

// builds processes that process inputs
public class DefaultProcessorBuilder implements ProcessorBuilder{

	@Override
	public Processor getProcessor(String[] commandParts) {
		// TODO reflection overwrite?
		if(! (commandParts!=null && commandParts[0]!=null) )
			return null;
		if(commandParts[0].equalsIgnoreCase("diff"))
			{
				Processor diffing=new DefaultDiffingProcessor(); 
				return diffing;
			}
		else 
			return null;
	}
}
