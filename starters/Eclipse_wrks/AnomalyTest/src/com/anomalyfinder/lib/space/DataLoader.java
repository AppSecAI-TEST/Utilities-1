package com.anomalyfinder.lib.space;

// loads data 
/**
 */
public interface DataLoader {
	// loadFrom - parameter identifying resource to load From
	/**
	 * Method loadBlock.
	 * @param loadFrom String
	 * @return DataBlock
	 */
	public Space loadSpace(String loadFrom);
	public ConnectedObject loadConnectedObject(String loadFrom);
	
}
