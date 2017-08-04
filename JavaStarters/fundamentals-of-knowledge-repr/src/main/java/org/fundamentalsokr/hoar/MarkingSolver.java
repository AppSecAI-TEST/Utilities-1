package org.fundamentalsokr.hoar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.fundamentalsokr.hoar.ClauseBag.ElementalClause;

// author: roman.gritsulyak@gmail.com 
// please don't redistribute without permit.
//
// solves system of triplets 
// by marking algorithm
// no optimization made for the moment, 
// to make it more readable. 
// it can be optimized soon
// when I will have time for it
// 
//  
// 
//
public class MarkingSolver {
	ClauseBag clauseBag; // input 

	// below are additional structures
	// key STR1#STR2 
	private Map<String,DerivingClause> derivers = new HashMap<String,DerivingClause>();
	private Set<String> marked = new HashSet<String>();

	private String dump=new String();

	// how marking done:
	// 


	// warning!! not safe, don't modify clause bag 
	// after call
	public MarkingSolver(ClauseBag clauseBag) {
		this.clauseBag = clauseBag;
	}

	public static void main(String[] args) {
		// demo solver
		System.out.println ("main implements test for solution");

		ClauseBag bag = new ClauseBag();
		bag.addClause(ElementalClause.INITIAL, new String[]{"a"});
		bag.addClause(ElementalClause.INITIAL, new String[]{"b"});
		bag.addClause(ElementalClause.INITIAL, new String[]{"gamma"});
		bag.addClause(ElementalClause.DERIVING, new String[]{"a","h_a", "s" });
		bag.addClause(ElementalClause.DERIVING, new String[]{"b","gamma", "h_a"});
		bag.addClause(ElementalClause.FINAL, new String[]{"s"});	

		String dump = bag.DumpBag();

		System.out.println("Solving system:\n" + dump + "\n");

		MarkingSolver solver= new MarkingSolver(bag);

		solver.solve();
		
		solver.dumpSolution();

	}

	public void solve() {
		fillStructures();
		makeSolutionWithDump();
	}
	

	private void fillStructures(){
		derivers = new HashMap<String, DerivingClause>();
		for(DerivingClause deriving : clauseBag.derivings){
			derivers.put(deriving.getKnownFirst() + "#" +
					deriving.getKnownSecond(),
					deriving);
		}

		// to fill next
	}

	public void dumpSolution() {
		System.out.println(dump);
	}

	private void makeSolutionWithDump() {
		setDump(getDump() + "\nMarking:\n");
		setDump(getDump() + "Marking Initials:\n");

		for(InitialClause i: clauseBag.initials){
			i.mark();
			marked.add(i.getInitiator());
			setDump(getDump() + "marked clause: " + i.DumpClause() +"\n");
		}
		
		setDump(getDump() + "Marking Derivers:\n");
		int imarked = -1;
		
		while(imarked<marked.size()){

			imarked = marked.size();
			// could be optimized there!
			for(String d: derivers.keySet()){
				String[] keys= d.split("#");

				if(keys.length!=2)
				{
					System.err.println("wrong derived key:" + d);
					System.exit(-1);
				}

				if(marked.contains(keys[0]) && marked.contains(keys[1])) {
					DerivingClause derived = derivers.get(d);
					if(derived.isMarked())
						continue; // target already marked
					marked.add(derived.getDerived());
					setDump(getDump() + "marked by new rule:" + derived.DumpClause() +"\n");
					derived.mark();
				}
				// only those that processed derivers process
			}
		}
		setDump(getDump() + "Result:\nAs to the statement: (");

		ArrayList<String> asdumped = new ArrayList<String>();

		for(DerivingClause d: clauseBag.derivings){
			asdumped.add("(" + d.DumpClause() + ")");
		}

		setDump(getDump() + String.join(" AND ", asdumped) + ") -> ((");

		asdumped = new ArrayList<String>();

		for(InitialClause i: clauseBag.initials){
			asdumped.add(i.getInitiator());
		}

		setDump(getDump() + String.join(" AND ", asdumped) + ") -> " 
				+ clauseBag.finalClause.getFinalizer() + ")\n");

		if(marked.contains(clauseBag.finalClause.getFinalizer())){
			setDump(getDump() + "unsatisfiable, the statement is a tautology, s can be derived");
		} else {
			setDump(getDump() + "satisfiable, the statement is a not tautology, s can't be derived");
		}


	}

	public String getDump() {
		return dump;
	}

	public void setDump(String dump) {
		this.dump = dump;
	}

}
