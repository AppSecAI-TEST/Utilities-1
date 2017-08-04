import java.util.*;

// for BetterProgrammer.com
public class BetterProgrammerTask1 {

    public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a set of elements that can be found only in set a or set b,
          but not in both Sets.
          The method should not change the content of the parameters.
         */
    	Set<Object> a1= new HashSet<Object>(a);
    	Set<Object> b1= new HashSet<Object>(b);
    	
    	a1.removeAll(b);
    	b1.removeAll(a);
    	
    	a1.addAll(b1);
    	
    	return a1;
    }
}
