import java.util.*;



public class BetterProgrammerTask8 {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
    	
    	int largest=root.getValue();
    	
    	List<Node> li = root.getChildren();	 

    	if(li.isEmpty())
    		return largest;
    		
		Iterator<Node> it = li.iterator();
		
		int cur_max=getLargestRootToLeafSum(li.get(0));
		int next_max;
		
		while(it.hasNext())
		{
			next_max = getLargestRootToLeafSum(it.next());
			if(next_max>cur_max)
				cur_max=next_max;
		}
		
    	return largest + cur_max;
    	
    }
}
