package org.fundamentalsokr.main;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.fundamentalsokr.hoar.ClauseBag.ElementalClause;
import org.fundamentalsokr.hoar.ClauseBag;
import org.fundamentalsokr.hoar.MarkingSolver;
// author: roman.gritsulyak@gmail.com 
// please don't redistribute without permit
// TODO complete
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
		ClauseBag bag = new ClauseBag();
		//  see Max Kanovich slides phd lectures HSE 11 SAT 2016
		System.out.println("input implications in following forms:");
		System.out.println("a b c : three symbols: for the implication ((a AND b) -> c ) = T");
	//  unimplemented
	//	System.out.println("a b c . : four symbols: for the implication ((a AND b) -> c ) = T also with:");
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
				
			String[] tokens = str.split(" ");

	    	if(tokens.length>4){
	    			System.err.println("too much arguments, should be 1-3");
	    			break;
	    	}
		
	    	
	    	if(tokens.length==1){
	    		bag.addClause(ElementalClause.INITIAL, tokens);
	    	} else if(tokens.length==2){
	    		// marking end
	    		bag.addClause(ElementalClause.FINAL, new String[]{tokens[0]});
	    		end = true;
	    	} else if(tokens.length==3) {
	    		// marking clause
	    		bag.addClause(ElementalClause.DERIVING, tokens);
	    	} else {
		    	System.err.println("rule ignored, Incorrect clause count:" + tokens.length );
	    	}
	    	
		} while (!end);
		
		
		if(!end)
			System.exit(-1);
		
		String dump = bag.DumpBag();
		System.out.println("Got following rule set:");
		System.out.println(dump);
		
		MarkingSolver solver= new MarkingSolver(bag);

		solver.solve();
		solver.dumpSolution();
		
		System.out.println("Got end of rules. Started rules processing");
		
	}
	
	private void runPath(){
		// TODO
		System.out.println("path unimplemented for the moment");
	}
	
	public static void main(String[] args){
		
		Main program = new Main();
		
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
