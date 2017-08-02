package varargs_samples;

public class MyVarargsDemoClass {

	public double getSumOfParams (int op1, float op2, Object... args)
	{
		double res = op1;
		res += op2;
		
		for (Object o : args)
		{
			double v = 0.0d;
			if (o instanceof String)
				v = Double.parseDouble((String)o);
			else
				if (o instanceof Integer)
				{
//					int i = (Integer)o;
//					v = i;
					v = (Integer)o;
				}
				else
					if (o instanceof Float)
					{
//						float f = (Float)o;
//						v = f;
						v = (Float)o;
					}
					else
						v = (Double)o;
			res += v;
		}
		return res;
	}
	public static void main(String[] args) {
		MyVarargsDemoClass dc = new MyVarargsDemoClass();
		System.out.println ("1 + 2.0f + \"3\" + 4 + 5.0f + 6.0d = " + 
				dc.getSumOfParams (1, 2.0f, "3", 4, 5.0f, 6.0d));
	}

}
