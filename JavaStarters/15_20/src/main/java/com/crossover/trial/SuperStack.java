package com.crossover.trial;

// @author roman.gritsulyak 2017 (from crossover competition)
import java.io.IOException;
import java.util.Scanner;

public class SuperStack {
	static java.util.logging.Logger log = java.util.logging.Logger.getLogger(SuperStack.class.toString());
	/**
	 * Complete the function below
	 */
	static void superStack(String[] operations) {

		int cp = -1;
		int[] arrayStack = new int[operations.length];
// invariant cp - current element
		for (int i = 0; i < operations.length; i++) {
			String[] tokens = operations[i].split(" ");
			if (tokens.length == 0) {
				log.severe("invalid operation (empty)");
			} else if (tokens.length == 1) {
				if (tokens[0].equals("pop")) {
					if (cp < 0)
						;
					else {
						cp--;
					}
				} else {
					log.warning("only pop don't have operands");
				}

			} else if(tokens.length==2) {
				if (tokens[0].equals("push")) { 
					cp++;
					arrayStack[cp] = Integer.parseInt(tokens[1]);
				} else {
					log.warning("only push dhas 1 operand");
				}
			} else if(tokens.length>2) {
				if(tokens[0].equals("inc")) {
					int ielems = Integer.parseInt(tokens[1]);
					int ival = Integer.parseInt(tokens[2]);
					for(int j=0;j<ielems;j++){
						arrayStack[j]+=ival;
					}
				} else {
					log.warning("only inc could have 2 operands");
				}
			}

			if(cp>=0)
				System.out.println(arrayStack[cp]);
			else
				System.out.println("EMPTY");
		}
	}

	/**
	 * DO NOT MODIFY THIS METHOD!
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int _operations_size = Integer.parseInt(in.nextLine().trim());
		String[] _operations = new String[_operations_size];
		String _operations_item;
		for (int _operations_i = 0; _operations_i < _operations_size; _operations_i++) {
			try {
				_operations_item = in.nextLine();
			} catch (Exception e) {
				_operations_item = null;
			}
			_operations[_operations_i] = _operations_item;
		}

		superStack(_operations);
	}
}
