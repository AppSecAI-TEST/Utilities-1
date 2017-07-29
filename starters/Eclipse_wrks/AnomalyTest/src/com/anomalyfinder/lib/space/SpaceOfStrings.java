package com.anomalyfinder.lib.space;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/* 
 * Space to analyze
*/
/**
 */
public class SpaceOfStrings implements Space{
	private Hashtable<Integer,ConnectedObject> coSpace;
	private Hashtable<Integer,ArrayList<Connection>> fromConnections;
	private Hashtable<Integer,ArrayList<Connection>> toConnections;	
	private Hashtable<Integer,ArrayList<Connection>> objectConnections;		
	// specialize later
	/**
	 * Method addDataBlock.
	 * @param dataBlock DataBlock
	 * @param beforeBlocks int[]
	 * @param afterBlocks int[]
	 */
	public void addConnectedObject(ConnectedObject dataBlock,
							 int [] beforeBlocks,
							 int [] afterBlocks) {
		coSpace.put(dataBlock.getId(), dataBlock);

		
		// TODO
		// 1) finish filling space
		// 2) reader of text files
		// 3) hibernate mapping to postgress
		// 4) data analyzys find anomaly in data algorithm
		// 5) Connections to messaging system
		
	}
	// 
	
}
