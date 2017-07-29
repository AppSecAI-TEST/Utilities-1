import java.util.*;


public class BetterProgrammerTask9 {

    public static int[] retainPositiveNumbers(int[] a) {
        /*
          Please implement this method to
          return a new array with only positive numbers from the given array.
          The elements in the resulting array shall be sorted in the ascending order.
         */
    	int[] b = a.clone();
    	int[] c = {};
    	java.util.Arrays.sort(b);
    	
    	int i;
    	
    	for(i=b.length-1;i>=0;i--)
    		if(b[i]>=0)
    			{}
    		else
    		 break;
    	
    	if(i>=0)
    		c = java.util.Arrays.copyOfRange(b, i+1, b.length);
    	else 
    		c = b.clone();
    	
    	return c;
    	
    }
}
