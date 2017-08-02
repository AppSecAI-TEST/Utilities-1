
public class BetterProgrammerTask2 {

    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */
    	Object[] b = a.clone();
    	
    	for(int i=0; i<b.length;i++)
    		b[i]= a[b.length-i-1];
    	
    	return b;
    }
}
