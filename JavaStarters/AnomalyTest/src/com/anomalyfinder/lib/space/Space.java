package com.anomalyfinder.lib.space;

/* 
 * Space to analyze
*/
/**
 */
public interface Space {
	// specialize later
	/**
	 * Method addDataBlock.
	 * @param dataBlock DataBlock
	 * @param beforeBlocks int[]
	 * @param afterBlocks int[]
	 */
	public void addConnectedObject(ConnectedObject dataBlock,
							 int [] beforeBlocks,
							 int [] afterBlocks);
	// 
	
}
