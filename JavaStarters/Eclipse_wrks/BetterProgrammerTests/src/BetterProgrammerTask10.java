import java.util.*;

public class BetterProgrammerTask10 {

    public static List<Integer> getReversalsToSort(int[] a) {
        /*
         You need to sort an array of integers by repeatedly reversing
         the order of the first several elements of it.

         For example, to sort [12,13,11,14], you need to  reverse the order of the first two (2)
         elements and get [13,12,11,14] and then reverse the order of the first three (3)
         elements and get [11,12,13,14]

         The method should return the shortest(!) possible list of integers corresponding to the required reversals.
         For the previous example, given an array [12,13,11,14]
         the method should return a list with Integers 2 and 3.
        */
    	
    	int[] b = a.clone();
    	
    	java.util.Arrays.sort(b);
    	
    	List<Integer> return_value=new ArrayList<Integer>();
    	return_value.clear();
    	
    	
    	for(int j = a.length-1; j>=0 ;j--)
    	{
        	int cur_max = a[0];
        	int cur_max_i=0;
        	
    	int cur_max_subarray_i=j;
    	
    	for(int i=1;i<=cur_max_subarray_i;i++)
    		if(a[i]>cur_max)
    			{
    			cur_max=a[i];
    			cur_max_i=i;
    			}
    	
    	if(cur_max_subarray_i>cur_max_i)
    		{
    		return_value.add(cur_max_i+1);
    		
    		for(int k=0;k<=cur_max_i/2; k++)
    			{
    			int tmp = a[k];
    			a[k]=a[cur_max_i-k];
    			a[cur_max_i-k]=tmp;
    			}
    		 
    		return_value.add(cur_max_subarray_i+1);
    	
    		for(int k=0;k<=cur_max_subarray_i/2; k++)
			{
			int tmp = a[k];
			a[k]=a[cur_max_subarray_i-k];
			a[cur_max_subarray_i-k]=tmp;
			}
    		
    		}
    
    	}
    	
    	return return_value;
    	
    }

}