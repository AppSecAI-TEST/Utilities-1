package org.fundamentalsokr.main;

import java.util.Scanner;
import java.util.StringTokenizer;
// author: roman.gritsulyak@gmail.com 
// please don't redistribute without permit
public class Main {

	private Scanner s;

	private void printHelp(){
		System.out.println("Help");
		System.out.println("Arguments:\n"
				+ "--help - print this help\n"
				+ "--demo <PARAMETER> - execute  demo\n"
				+ "<PARAMETER>=hoar - execute hoar demo\n"
				+ "<PARAMETER>=path - execute path demo\n");
	}
	
	private void runHoar(){
		//  see Max Kanovich slides phd lectures HSE 11 SAT 2016
		System.out.println("input implications in following forms:");
		System.out.println("a b c : three symbols: for the implication ((a AND b) -> c ) = T");
		System.out.println("a b c . : four symbols: for the implication ((a AND b) -> c ) = T also with:");
		System.out.println("         ((a AND c) -> b ) = T and ((a AND c) -> b ) = T");
		System.out.println("b : one symbol: for the (b=T) clause");
		System.out.println("s . : one symbol and dot - for the final goal, to start algorithm"
				+ ": (s =_|_) = T clause");
		System.out.println("don't use # - it is prohibited symbol");
		
		s = new Scanner(System.in);
		
		boolean end = false;

		do 
		{
			String str = s.nextLine();
			// # prohibited, used in keys
			if(str.contains("#"))
			{
				System.err.println("# - prohibited symbol; exit");
				System.exit(-1);
			}
				
			StringTokenizer st = new StringTokenizer(str);
			
			String[] tokens= new String[4];
			int clauseCounter = 0;
			
	    	while (st.hasMoreTokens()) {
	    		tokens[clauseCounter] = st.nextToken();
	    		clauseCounter ++;
	    		if(clauseCounter>4)
	    		{
	    			if(st.hasMoreTokens()) {
	    				System.out.println("too much arguments, should be 1-3");
	    			} 
	    				break;
	    		}
	    	}
		
	    	
	    	if(clauseCounter==1){
	    		// marking initial clause 
	    		// TODO
	    	} else if(clauseCounter==2){
	    		// marking end
	    		// TODO
	    	} else if(clauseCounter==3) {
	    		// marking clause
	    		// TODO
	    	} else {
		    	System.out.println("rule ignored, Incorrect clause count:" + clauseCounter );
	    	}
	    	
	    	System.out.println("added clause:"  );
		
		} while (!end);
		
		System.out.println("Got end of rules. Started rules processing");
		
	}
	
	private void runPath(){
		// to do
	}
	
	public static void main(String[] args){
		
		Main program = new Main();
		
		System.out.println("args are:"); 
		
		for(String str:args) {
			System.out.println(str);
		}
		
		boolean recognized = true;
		
		for(int i=0;i<args.length;i++) {
			if (args[i].equalsIgnoreCase("--help")){
				program.printHelp();
				continue;
			} else if(args[i].equalsIgnoreCase("--demo")) {
				i++;
				if(i<args.length){
					if(args[i].equalsIgnoreCase("hoar")){
						program.runHoar();
						continue;
					} else if(args[i].equalsIgnoreCase("path")){
						program.runPath();
						continue;
					} else {
						System.out.println("unrecognized argument ignored:" + args[i]);
					}	
				} else {
					System.out.println("--demo without parameter specified, ignored");
				}
				
		} 
			
			recognized = false;
		}
		
		if(!recognized)
			program.printHelp();
	}
	
}
