package reflection_samples;

public class MyDemoClass {
	private int i;
	public static String s = "ABC";
	
	public MyDemoClass () { i = -1; }
	public MyDemoClass (int i) { this.i = i; }
	protected MyDemoClass (String s) {}
	
	public void setI (int v) throws MyException { i = v; }
	public int getI () { return i; }
	
	public void finalize() {}
}
