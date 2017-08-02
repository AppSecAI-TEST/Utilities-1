package annotation_samples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MyMainClass {


	public static void main(String[] args) throws Exception {
		MyAnnotatedClass mc = new MyAnnotatedClass (777);
		
		Class<Type>[] types = null; 
		Method m = mc.getClass().getMethod("printInfo", types);
		if (m.isAnnotationPresent(MyAnnotation.class))
		{
			Annotation a = m.getAnnotation(MyAnnotation.class);
			int numb = (Integer)a.getClass().getMethod ("valueInSequence", types).invoke(a, null);
			System.out.println ("ѕор€дковый номер метода printInfo в коде класса = " + numb);
			mc.printInfo();
		}
	}

}
