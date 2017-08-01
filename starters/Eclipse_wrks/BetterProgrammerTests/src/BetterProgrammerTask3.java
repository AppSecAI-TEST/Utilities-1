
public class BetterProgrammerTask3 {

    public static int countPowerfulNumbers(int from, int to) {
        /*
          A powerful number is a positive integer m that for every prime number p dividing m, p*p also divides m.

          (a prime number (or a prime) is a natural number that has exactly two (distinct) natural number divisors,
          which are 1 and the prime number itself, the first prime numbers are: 2, 3, 5, 7, 11, 13, ...)

          The first powerful numbers are: 1, 4, 8, 9, 16, 25, 27, 32, 36, ...

          Please implement this method to
          return the count of powerful numbers in the range [from..to] inclusively.
         */
    	int cur_count=0;
    	
    	for (int cur_checked=from;cur_checked<=to; cur_checked++)
    		{
    			for(int cur_divider = 1;cur_divider<cur_checked;cur_divider++)
    				if (cur_checked%(cur_divider*cur_divider*cur_divider) == 0)
    				{
    					if(Math.round
    							(Math.sqrt(cur_checked/
    									(cur_divider*cur_divider*cur_divider))) == 
    										Math.sqrt(cur_checked/
    		    									(cur_divider*cur_divider*cur_divider)))
    					{cur_count++;
    					System.out.println(cur_checked);
    					break;}
    				}
    		}
    
    	return cur_count;
    }
}
