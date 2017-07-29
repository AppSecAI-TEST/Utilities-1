package serial;

public enum MyEnumeration {
	ONE("Один"), TWO("Два"), THREE ("Три");
	
	private String v;
	private MyEnumeration (String s) { v = s; }
	public String setDescription () { return v; } 
}
