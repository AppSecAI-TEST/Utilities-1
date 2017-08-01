
public class BetterProgrammerTask7 {

    public static int countAlmostPrimeNumbers(int from, int to) {
        /*
          A prime number is a natural number that has exactly two distinct natural number divisors,
          which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13.

          Almost prime numbers are the non-prime numbers
          which are divisible by only a single prime number.

          Please implement this method to
          return the number of almost prime numbers within the given range (inclusively).
         */
    	int count = 0;
    	for(int pt=from;pt<=to;pt++)
    	for(int i=2;i<pt;i++)
    	{
    		if(pt%i == 0) //candidate
    		{   
    		//	System.out.print("pt is candidate ");
    		//	System.out.println(pt);
    			boolean fail = false;
    			for(int j=2;j<pt/i;j++)
    				if((pt/i)%j == 0)
    				{// fail
    				//	System.out.print("failed ");
    				//	System.out.println(pt);
    					fail = true;
    					break;
    				}
    			if(fail==false) 
    				count++;
    			break;
    		}
    	}
    	
    	return count;
    }
}
