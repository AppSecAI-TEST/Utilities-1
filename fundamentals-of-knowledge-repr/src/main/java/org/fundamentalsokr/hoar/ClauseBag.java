package org.fundamentalsokr.hoar;
import java.util.ArrayList;

// author: roman.gritsulyak@gmail.com 
// please don't redistribute without permit
public class ClauseBag implements Cloneable{

public enum ElementalClause {
	INITIAL, // (a -> T) = T
	DERIVING,// ((a->b)->c) = T 
	FINAL ;   // (s->_|_) = T
	}

	ArrayList<DerivingClause> derivings = new ArrayList<DerivingClause>();
	ArrayList<InitialClause> initials = new ArrayList<InitialClause>();
	FinalClause finalClause;

	public void addClause(ElementalClause type, String[] tokens) {
		// TODO
		if(type==ElementalClause.INITIAL){
			InitialClause clause = new InitialClause(tokens[0]);
			initials.add(clause);
		}else if(type==ElementalClause.DERIVING){
			DerivingClause deriving;
			if(tokens.length < 4 || tokens[3]==null || tokens[3].isEmpty())
				deriving = new DerivingClause(tokens[0], 
						tokens[1], tokens[2],false);
			else
				deriving = new DerivingClause(tokens[0], 
						tokens[1], tokens[2], true);
				
			derivings.add(deriving);
		}else if (type==ElementalClause.FINAL){
			finalClause= new FinalClause(tokens[0]); 
		}
	}

	public String DumpBag() {
		String out = new String();

		out += "{\nDeriving clauses:\n";
		for(DerivingClause d: derivings){
			out += d.DumpClause() + "\n";
		}
		out+= "\nInitial Clauses:\n";
		for(InitialClause i: initials){
			out+= i.DumpClause() + "\n";
		}
		out+="\nFinal Clause\n";
		out+=finalClause.DumpClause() + "}\n";
		 
		return out;
	}

};


abstract class Clause{
	boolean marked = false;
	
	public boolean isMarked() {
		return marked;
	}

	public void mark() {
		marked = true;
	};
		
	public abstract String DumpClause();
};


class InitialClause extends Clause {
	public String getInitiator() {
		return initiator;
	}
	private String initiator;
	public InitialClause(String initiator) {
		this.initiator = initiator;
	}
	@Override
	public String DumpClause() {
		return initiator + "=T";
	}	
};

class DerivingClause extends Clause {
	private String knownFirst;
	public String getKnownFirst() {
		return knownFirst;
	}

	public String getKnownSecond() {
		return knownSecond;
	}

	public String getDerived() {
		return derived;
	}

	public boolean isCyclingFlag() {
		return cyclingFlag;
	}

	private String knownSecond;
	private String derived;
	private boolean cyclingFlag;
	
	public DerivingClause(String first, String second, String derived, boolean cycling){
		this.knownFirst=first;
		this.knownSecond=second;
		this.derived=derived;
		this.cyclingFlag=cycling;
	}

	@Override
	public String DumpClause() {
		return "((" + knownFirst+ " AND " + knownSecond + ")->" + derived +")=T";
	}
	
};

class FinalClause extends Clause {
	public String getFinalizer() {
		return finalizer;
	}

	private String finalizer;
	
	public FinalClause(String string){
		finalizer = string;
	}

	@Override
	public String DumpClause() {
		return "(" + finalizer + "-> _|_ ) = T";
	}
	
};