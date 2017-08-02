package org.hse.demo.minbucket;

import java.util.Scanner;
import java.util.StringTokenizer;
// author: roman.gritsulyak@gmail.com
// purpose: experimental analysis of
// please don't use without permission
import java.util.Vector;

public class Main {

	// return pairs of nodes
	Vector<int[]> calculateECM(int[] degrees){
		Vector<int[]> graph=null;
		// calculate number of stubs
		// overall stubs
		int stub_count = 0;
		
		for(int degree:degrees)
			stub_count+=degree;
			
		for(int i=0;i<degrees[i]; i++);
			
		// generate stubs
		// degrees[k] = degree of vertex k
		
		
		
		return graph;
	}
	
	// the purpose is repetition 
	// of calculating experiment
	public static void main(String[] args) {
		boolean ecmonly = false;
		
		for(String arg:args)
			if(arg.equals("--ecmonly"))
				ecmonly = true;
		
		// 1) read graph
		// 2) calculate degrees
		// 3) Execute Minbucket
		// 4) Execute ECM(d)
		Vector<int[]> pairs = new Vector<int[]>();
		
		Scanner s = new Scanner(System.in);
		boolean end = false;
		
		// read number of nodes to initialize data structures
	      Scanner scanner = new Scanner(System.in);
	        System.out.println("Please enter number (max) of nodes");
	        int number1 = scanner.nextInt();
	        System.out.println("Please enter number of edges");
	        int number2 = scanner.nextInt();
	     int  edges=number2;
	     
	     int [][] mat = new int[number1][number1];
	     
	    String str;
			
		do 
		{
			str = s.nextLine();
			// node connected
			if(str.equals("."))
				break;
			// read pathes, form graph
    		
			int[] myIntArray = new int[2];
    		
			StringTokenizer st = new StringTokenizer(str);
			
			int tokensCount = st.countTokens();
			
			if(tokensCount!=2)
				System.err.println("wrong token number");
			
			String currentToken = s.next();
			myIntArray[0] = Integer.valueOf(currentToken);
			currentToken = s.next();
			myIntArray[1] = Integer.valueOf(currentToken);
			
			pairs.add(myIntArray);
			
		} while(--edges>0);
		
		
		

	}

}
