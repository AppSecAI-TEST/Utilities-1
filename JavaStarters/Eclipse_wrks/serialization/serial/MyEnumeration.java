package serial;

public enum MyEnumeration {
	ONE("����"), TWO("���"), THREE ("���");
	
	private String v;
	private MyEnumeration (String s) { v = s; }
	public String setDescription () { return v; } 
}
