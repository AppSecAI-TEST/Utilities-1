package reflection_samples;

import java.lang.reflect.*;

public class MyReflectionDemoClass {

	public static void main(String[] args) throws Exception {
		Class cl = Class.forName("reflection_samples.MyDemoClass"); 
		
		MyDemoClass var = (MyDemoClass)cl.newInstance();
		System.out.println("После newInstance var имеет начальное значение = " + var.getI());
		Class<MyDemoClass> c1 = (Class<MyDemoClass>)var.getClass(); 
//		Class<MyDemoClass> c2 = MyDemoClass.class;
		Class c2 = MyDemoClass.class;
		
		if (c1 == c2)
			System.out.println ("c1 == c2");
		else
			System.out.println ("c1 != c2");
		if (c1.equals(c2))
			System.out.println ("c1 equals c2");
		else
			System.out.println ("c1 not equals c2");

		System.out.println ("Информация по классу для типа " + c1.getName());
		System.out.println ("Конструкторы:");
		Constructor[] constrs = c1.getConstructors();
		for (Constructor constr : constrs)
		{
			System.out.println (constr.getName());
			Class[] params = constr.getParameterTypes();
			if (params.length > 0)
			{
				System.out.println ("Параметров: " + params.length);
				for (Class p : params)
					System.out.println ("Тип параметра: " + p.getName());
			}
			System.out.println ("------------");
			
		}
		System.out.println ("Поля:");
		Field[] fields = c1.getFields();
		for (Field f : fields)
		{
			String fdescr = "";
			int mod = f.getModifiers();
			if (Modifier.isPrivate(mod))
					fdescr += "private ";
			if (Modifier.isPublic(mod))
					fdescr += "public ";
			if (Modifier.isProtected(mod))
				fdescr += "protected ";
			
			if (Modifier.isStatic(mod))
				fdescr += "static ";
			
			fdescr += f.getType().getName();
			System.out.println (fdescr);
		}

		System.out.println ("\n\nМетоды:");
		Method[] methods = c1.getMethods();
		for (Method m : methods)
		{
			String mdescr = "";
			int mod = m.getModifiers();
			if (Modifier.isPrivate(mod))
					mdescr += "private ";
			if (Modifier.isPublic(mod))
					mdescr += "public ";
			if (Modifier.isProtected(mod))
				mdescr += "protected ";
			
			if (Modifier.isStatic(mod))
				mdescr += "static ";
			
			mdescr += m.getReturnType().getName();
			mdescr += " ";
			mdescr += m.getName();
			mdescr += "(";
			
			Class[] params = m.getParameterTypes();
			int len = params.length;
			for (int i = 0; i < len; i++)
			{	
				Class c = params[i];
				mdescr += c.getName();
				if (i < len-1)
					mdescr += ", ";
			}
						
			mdescr += ")";
			
			Class[] excs = m.getExceptionTypes();
			len = excs.length; 
			if (len > 0)
			{
				mdescr += " throws ";
				for (int i = 0; i < len; i++)
				{
					Class c = excs[i];
					mdescr += c.getName();
					if (i < len-1)
						mdescr += ", ";
				}
			}
			mdescr += ";";
			System.out.println (mdescr);
		}
		
		System.out.println ("\n\n\n\n");
		Class intClass = int.class;
		System.out.println ("Имя для класса Class<int>: " + intClass.getName());
		try
		{
			int i = (Integer)intClass.newInstance(); 
		}
		catch (java.lang.InstantiationException e)
		{
			System.out.println ("Исключение InstantiationException: " + e.getMessage());
		}
	}
}
