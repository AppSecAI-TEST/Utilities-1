package TestsJavaCert;

import static java.lang.Integer.MAX_VALUE;

enum CoffeeSize {
	BIG("fbf",11), HUGE("htht",11), OVERWHELMING("vdvd",112) { // start a code block that defines
	// the "body" for this constant
		public String getLidCode() { // override the method
		// defined in CoffeeSize
			return "A";
		}
	}; // the semicolon is REQUIRED when more code follows
	CoffeeSize(String ounces, int bolo) {
		this.ounces = ounces;
		this.bolo = bolo;
	}

	 String ounces;
	 int bolo;
	 
	public int getOunces() {
		return bolo;
	}

	public String getLidCode() { // this method is overridden
	// by the OVERWHELMING constant
		return "B"; // the default value we want to
		// return for CoffeeSize constants
	}
}

public class enutest {
	public static void main(String aa[]){
		CoffeeSize [] b= {CoffeeSize.BIG,CoffeeSize.HUGE,CoffeeSize.OVERWHELMING};
		for(CoffeeSize cs : b) {
			System.out.println(" cur "+ cs + " : " + cs.getOunces() + " : " + cs.getLidCode() );
		}
		TestDays.main(aa);
		StatTest.main(aa);
	}
}

class TestDays {
 public enum Days { MON, TUE, WED };
public static void main(String[] args) {
 for(Days d : Days.values() ) ;
 Days [] d2 = Days.values();
 System.out.println(d2[2]);
 }
}

 // insert code here
 class StatTest {
 public static void main(String[] args) {
 System.out.println(Integer.MAX_VALUE);
 //Phone2 phone=new Phone2();
 //phone.doIt();
 }
 }
 
  class Electronic implements Device
 { public void doIt() { } }
 abstract class Phone1 extends Electronic { }
 abstract class Phone2 extends Electronic
 { public void doIt(int x) { } }
 class Phone3 extends Electronic implements Device
 { public void doStuff() { } }
 
 interface Device { public void doIt(); }
 
  class Frodo extends Hobbit {
 public static void main(String[] args) {
 int myGold = 7;
 //System.out.println(countGold(myGold, 6));
 }
}
class Hobbit {
 int countGold(int x, int y) { return x + y; }
}