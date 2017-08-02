
public class BetterProgrammerTask6 {

    public static int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */
    	int closest=a[0];
    	for(int i=1; i<a.length;i++)
    		if(Math.abs(a[i]) < Math.abs(closest) || (a[i] > 0 && -closest==a[i]))
    			closest = a[i];
    			
    	return closest;
    }
}
