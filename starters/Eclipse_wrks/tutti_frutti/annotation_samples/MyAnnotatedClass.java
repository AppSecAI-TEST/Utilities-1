package annotation_samples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MyAnnotatedClass {
	private int i;
	
	@MyAnnotation(valueInSequence = 1)
	public MyAnnotatedClass () { i = 0; }
	
	@MyAnnotation(valueInSequence = 2)
	public MyAnnotatedClass (int v) { i = v; }
	
	@MyAnnotation(valueInSequence = 3)
	public int getInt() { return i; }
	
	
	@MyAnnotation(valueInSequence = 4)
	public void setInt(int v) { i = v; }
	
	@MyAnnotation(valueInSequence = 5)
	public void printInfo () {
		System.out.println ("Значение = " + i);
	}
}
