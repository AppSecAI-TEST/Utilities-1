import java.util.*;

public class BetterProgrammerTask5 {

    public static double getProbability(int Y, int X) {
		int all_combs=1;
		
		if (Y<1) return 0;
		
		for(int i=0;i<X;i++)
			all_combs*=6;
		
		System.out.println(all_combs);
		
		return 1./(double)all_combs;
		
        /*
          If you roll Y standard six-sided dice, \
          what’s the probability that you get at least X 4s?
         */
		
    }
}
