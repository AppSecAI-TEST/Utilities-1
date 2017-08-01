import java.util.*;


public class BetterProgrammerTask4 {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static int getLevelSum(Node root, int N) {
        /*
          Please implement this method to
          traverse the tree and return the sum of the values (Node.getValue()) of all nodes
          at the level N in the tree.
          Node root is assumed to be at the level 1. All its children are level 2, etc.
         */
    	
    	int sum = 0;
    	
    	if(N==1) 
    		return root.getValue();
    	else 
    	{
    	List<Node> li = root.getChildren();	 
    		N--;
    		
    		Iterator<Node> it = li.iterator();

    		while(it.hasNext())
    		  sum+=getLevelSum(it.next(), N);
    	
    		return sum;
    	}
    	
    	
    }
}
