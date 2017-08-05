package glava3;

import java.util.Date;

public class glava3 {
	
	static public void main(String [] str) {
	double d = 110599.995011D; // Optional, not required
	double g = 987.897; // No 'D' suffix, but OK because t
	// literal is a double by default
	
	System.out.println("d: " + d +  ";g:" + g); 
	
	boolean t = true; // Legal
	//boolean f = 0; // Compiler error!
	
	char letterN = '\u004E'; // The letter 'N'
	
	char a = 0x892; // hexadecimal literal
	char b = 982; // int literal
	char c = (char)70000; // The cast is required; 70000 is
	// out of char range
	char cd = (char) -98; // Ridiculous, but legal
//	int x = 332432.3243;
	int x = (int)3957.229; // legal cast
	System.out.println("int x = " + x);
	
	System.out.println("\n\r  " + (int) a +" " + (int) b +" " + (int)c +" " + (int)cd);
	
	}
}

class StringTest {
public static void main(String [] args) {
String x = "Java"; // Assign a value to x
String y = x; // Now y and x refer to the same
// String object
System.out.println("y string = " + y);
//x = x + " Bean"; // Now modify the object using
// the x reference

x = x.replace('a', 'e');

System.out.println("y string = " + y);
System.out.println("x string = " + x);
}
}

class Bar {
int barNum = 28;
@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		Foo.saveBar(this);
		
	}
}

class Foo {
Bar [] myBar = new Bar[1000000];
void changeIt(Bar myBar) {
myBar.barNum = 99;
System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
myBar = new Bar();
myBar.barNum = 420;
System.out.println("myBar.barNum in changeIt is now " + myBar.barNum);
}

public static void saveBar(Bar br) {
	System.out.println("vsave bar");
	Foo f= new Foo();
	// f.myBar[0] = br;
}

public static void main (String [] args) {
Foo f = new Foo();
for ( Bar br: f.myBar) 
	f.myBar[0] = new Bar();

System.out.println("f.myBar.barNum is " + f.myBar[0].barNum);
f.changeIt(f.myBar[0]);
System.out.println("f.myBar.barNum after changeIt is "
+ f.myBar[0].barNum);
}
}


class CheckGC {
 public static void main(String [] args) {
 Runtime rt = Runtime.getRuntime();
 System.out.println("Total JVM memory: "
+ rt.totalMemory());
 System.out.println("Before Memory = "
+ rt.freeMemory());
 Date d = null;
 for(int i = 0;i<100000;i++) {
 d = new Date();
 d = null;
 }
 System.out.println("After Memory = "
+ rt.freeMemory());
 rt.gc(); // an alternate to System.gc()
 System.out.println("After GC Memory = "
+ rt.freeMemory());
 }
}


/*
 
 */
class MyCheck {
	static int count = 0;
	
	class Eligible {
		int da = 8;/*
		@Override
		
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
			double a=0;
			// System.out.println("analyze class eligible");
			for(int i=0;i<100000;i++){
			   a += i*i; i+=a;
			}
			//da = null;
		}*/
	}
	
	class Noneligible {
		int [] non = {10,15,30};
	/*	
		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
			System.out.println("analyze class NON eligible");
			non = null;
		} */
	}
	
	 static public void main (String [] str) {
		MyCheck chk = new MyCheck();
		
		for(int i=0;i<1000000;i++) {
			Noneligible no = chk.new Noneligible();
			
			Eligible el = chk.new Eligible();
			
			el.da =  no.non[1];
			// el=null;
			// no=null;
			// System.gc();
		}
	}
	
}