package com.anomalyfinder.lib.space;

public class Connection {
	static int last_id = 0;
	int id;
	int fromId;
	int toId;
	
	public Connection(int from, int to){
		id = ++last_id;
		fromId = from;
		toId = to;
	}
	
	public void setFromId(int i){ fromId = i;} 
	public void setToId(int i){toId = i;}
	
	public int getId() {return id;}
	public int getFromId() {return fromId;}
	public int getToId() {return toId;}
}
