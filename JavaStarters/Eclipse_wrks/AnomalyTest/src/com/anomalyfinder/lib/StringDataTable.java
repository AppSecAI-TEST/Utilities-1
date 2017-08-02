package com.anomalyfinder.lib;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

// todo define here mapped through hibernate
// to db table of strings
public class StringDataTable {
	private Hashtable<Integer, ArrayList<String>> data = new Hashtable<Integer, ArrayList<String>>();
	// colNum -> colValue -> Idx
	private Hashtable<Integer, Hashtable<String, Integer>> indexedCols;

	/*
	 * TODO private Hashtable<Integer , HashTable<String, Integer> >
	 * indexedCols; // colnum , isIndexed // true = fuly indexed, false = part
	 * indexed, null - not indexed;
	 * 
	 * public void indexByColNum(int num){ // TODO implemented }
	 */

	public void updateInsertRaw(int id, ArrayList<String> rowData) {
		data.put(id, rowData);
	}

	public ArrayList<String> getById(int id) {
		return data.get(id);
	}

	// do full scan
	public Integer getByRaw(int dataColIdx, String dataColValue) {
		Integer found = null;
		// find by indexed set first
		Hashtable<String, Integer> dataColByIdx = indexedCols.get(dataColIdx);

		if (dataColByIdx != null) {

			found = dataColByIdx.get(dataColValue);

			if (found != null)
				return found;
		}

		Enumeration<Integer> e = data.keys();
		while (e.hasMoreElements()) {
			found = e.nextElement();
			// TODO - add nullchecks and test
			if (data.get(e).get(dataColIdx).equals(dataColValue))
				return found;
		}
		return null; // not found
	}
}
