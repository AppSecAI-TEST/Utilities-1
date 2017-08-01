package com.anomalyfinder.lib.space;

// matrix 
/**
 */
public class StringObject implements ConnectedObject{
	/**
	 * Field last_id.
	 */
	static int last_id=0;
// block of data
	/**
	 * Field id.
	 */
	int id;
	/**
	 * Field description.
	 */
	String description;
	/**
	 * Field comment.
	 */
	String comment;
	// what form of object? matrix? Array of matrix? Graph of matrixes?
	/**
	 * Field data.
	 */
	String data;
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
