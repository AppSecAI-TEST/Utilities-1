package com.crossover.trial;

import java.io.*;
import java.util.*;

public class Tester {
	
    private static Scanner in;


	/**
     * Complete the function below.
     */
    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) 
	{
    	int[] ret = new int[lowerLimits.length];
    	
    	// for each candidate 
    	// scores 10^5
    	// naive  
    	// disjoint set should be in complete no time.
    	
    	
    	for(int i=0;i<scores.length;i++)
    		for(int j=0;j<lowerLimits.length;j++)
    		{
    			if(scores[i]>=lowerLimits[j] && scores[i] <= upperLimits[j])
    				ret[j]++;
    		}
    	return ret;
    	
    }


    /**
     * DO NOT MODIFY THIS METHOD!
     */
     public static void main(String[] args) throws IOException
	 {
        in = new Scanner(System.in);
        int[] res;
        
        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine().trim());
            _scores[_scores_i] = _scores_item;
        }
        
        
        int _lowerLimits_size = 0;
        _lowerLimits_size = Integer.parseInt(in.nextLine().trim());
        int[] _lowerLimits = new int[_lowerLimits_size];
        int _lowerLimits_item;
        for(int _lowerLimits_i = 0; _lowerLimits_i < _lowerLimits_size; _lowerLimits_i++) {
            _lowerLimits_item = Integer.parseInt(in.nextLine().trim());
            _lowerLimits[_lowerLimits_i] = _lowerLimits_item;
        }
        
        
        int _upperLimits_size = 0;
        _upperLimits_size = Integer.parseInt(in.nextLine().trim());
        int[] _upperLimits = new int[_upperLimits_size];
        int _upperLimits_item;
        for(int _upperLimits_i = 0; _upperLimits_i < _upperLimits_size; _upperLimits_i++) {
            _upperLimits_item = Integer.parseInt(in.nextLine().trim());
            _upperLimits[_upperLimits_i] = _upperLimits_item;
        }
        
        res = jobOffers(_scores, _lowerLimits, _upperLimits);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}