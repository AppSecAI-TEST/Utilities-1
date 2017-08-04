package org.graphvisual.main;

import java.util.Arrays;
import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;

class GraphUtil {
	String prevNode;
	
	static public void addNode(Graph g, String node){
		
	}
	
	static public void startPath(String snode){
	//	if(Graph.get)
	};
	
	static public void addPath(){
		
	};
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Purpose : implement minbucket visualization
		Integer a = null;
		if(a!=null && a.intValue() >0)
			System.out.println("a=" + a);
		
		int [] ai = {1,2,3,4,5};
		
		for(int i:ai)
		
	System.setProperty("gs.ui.renderer", 
				"org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	
		new Main();
	}
	
	public Main() {
		
		final Graph graph = new SingleGraph("MinBucket");
	
		graph.addNode("A" );
		graph.addNode("B" );
		graph.addNode("C" );
		graph.addNode("D");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		graph.addEdge("CD", "C", "D");
		graph.addEdge("DA", "D", "A");

		
		List<String> nodes = Arrays.asList("a1","a2","b1","c2", "c1");
//		nodes.stream().sorted().map();
		
	    Thread thr = new Thread()
        {
            public void run() {
            	 graph.display(); 
            }
        };
        
	    thr.start();
		
	    
	    graph.addEdge("BD", "B", "D");
	    
         // No auto-layout.		
		
        try {
			thr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
