package com.anomalyfinder.lib.space;

/**
 */
public interface Finder {
// specialize later
	// returns anomalic block from 
	/**
	 * Method findAnomalyIn.
	 * @param initialBlock DataBlock
	 * @return Space Subspace of initial space with anomaly
	 */
	public Space findAnomalyIn(Space initialBlock);
}
