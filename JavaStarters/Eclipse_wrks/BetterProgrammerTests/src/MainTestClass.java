import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;


import javax.tools.JavaCompiler;

public class MainTestClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting tests.");
		//try {
		//	int imy = System.in.read();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		System.out.println("Test1 started.");
		
		try {
		Set<Object> a = new HashSet<Object>();
		String el1 = "element1";
		String el2 = "element2";
		String el3 = "element3";
		String el4 = "element4";
		String el5 = "element5";
		String el6 = "element6";
		String el7 = "element7";
		
		a.add(el1);
		a.add(el3);
		a.add(el4);
		a.add(el5);
		
		System.out.println("a set:");
		System.out.println(a);

		Set<Object> b = new HashSet<Object>();
		b.add(el1);
		b.add(el6);
		b.add(el7);

		System.out.println("b set:");
		System.out.println(b);
		
		Set<Object> c = BetterProgrammerTask1.getUniqueElements(a, b);

		Iterator<Object> it = c.iterator();

		while(it.hasNext())
		System.out.println(it.next());
		
		System.out.println("a set:");
		System.out.println(a);

		System.out.println("b set:");
		System.out.println(b);
		
		}
		catch(java.lang.NullPointerException e)
		{
			System.out.println("Null Pointer Exception");
		}

		System.out.println("Test2 started.");
		
		Object[] ia = {1,2,4,7, 4};
		Object [] ib = BetterProgrammerTask2.reverseArray(ia);
		
		System.out.println(ib);
		
		System.out.println("Test3 started.");
		
		int count = BetterProgrammerTask3.countPowerfulNumbers(18, 1000);
		
		System.out.println(count);
		
		System.out.println("Test4 started.");
		//
		
		double dou = BetterProgrammerTask5.getProbability(1, 0);
		
		System.out.println(dou);
		int[] aa = {8,-10,2,-3, 5,-5,2, -4,-5,};
		
		int clo = BetterProgrammerTask6.getClosestToZero(aa);
		System.out.println("closest");
		System.out.println(clo);
		
		int countap = BetterProgrammerTask7.countAlmostPrimeNumbers(1,12);
		System.out.println("almost priom");
		System.out.println(countap);
	
		int[] ab = {1,4,8,3,2,6,9,5};
		
		List<Integer> myLi;
		
		myLi = BetterProgrammerTask10.getReversalsToSort(ab);

		System.out.println ("reversals:");
		
		Iterator<Integer> itli = myLi.iterator();

		while(itli.hasNext())
		System.out.println(itli.next());
		
		int [] myarr1 = {1,54,543,-10,-100,-34,5,87,9};
		int [] myarr2 = BetterProgrammerTask9.retainPositiveNumbers(myarr1);
		
		System.out.println("dwefew");
		System.out.println(myarr2[0]);
		
	}
}
