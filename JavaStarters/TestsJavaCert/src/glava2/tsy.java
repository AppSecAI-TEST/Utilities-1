package glava2;

public class tsy {

}

class Bird {
	static { System.out.print("b0 ");}
{ System.out.print("b1 "); }
public Bird() { System.out.print("b2 "); }
}
class Raptor extends Bird {
static { System.out.print("r1 "); }
public Raptor() { System.out.print("r2 "); }
{ System.out.print("r3 "); }
static { System.out.print("r4 "); }
}
class Hawk extends Raptor {
public static void main(String[] args) {
System.out.print("pre ");
new Hawk();
System.out.println("hawk ");
}
}


class Locomotive {
Locomotive() { main("hi"); }
public static void main(String[] args) {
System.out.print("2 ");
}
public static void main(String args) {
System.out.print("3 " + args);
}

{
	System.out.print("object contruct");
}

static { 
	System.out.print("static ");
}
}

class Dog {
public void bark() { System.out.print("woof "); }
}
class Hound extends Dog {
public void sniff() { System.out.print("sniff "); }
public void bark() { System.out.print("howl "); }
}
 class DogShow {
public static void main(String[] args) { new DogShow().go(); }
void go() {
new Hound().bark();
((Dog) new Hound()).bark();
//((Dog) new Hound()).sniff();
}
}
 
  class Redwood extends Tree {
	 public static void main(String[] args) {
	 new Redwood().go();
	 }
	 void go() {
	 go2(new Tree(), new Redwood());
	 go2((Redwood) new Tree(), new Redwood());
	 }
	 void go2(Tree t1, Redwood r1) {
	 Redwood r2 = (Redwood)t1;
	 Tree t2 = r1;
	 }
	}
	class Tree { }
	
	class Tenor extends Singer {
		 public static String sing() { return "fa"; }
		 public static void main(String[] args) {
		 Tenor t = new Tenor();
		 Singer s = new Tenor();
		 System.out.println(t.sing() + " " + s.sing());
		 }
		}
		class Singer { public static String sing() { return "la"; } }

 class Alpha {
			 static String s = " ";
			 
			 protected Alpha() { s += "alpha "; }
			 }

class SubAlpha extends Alpha {
	private SubAlpha() {  s += "sub "; }
}

class SubSubAlpha extends Alpha {
			 private SubSubAlpha() { s += "subsub "; }
			 public static void main(String[] args) {
			 new SubSubAlpha();
			 System.out.println(s);
		}
}


class Mammal {
String name = "furry ";
String makeNoise() { return "generic noise"; }
}
class Zebra extends Mammal {
String name = "stripes ";
String makeNoise() { return "bray"; }
}
class ZooKeeper {
public static void main(String[] args) { new ZooKeeper().go(); }
void go() {
Mammal m = new Zebra();
System.out.println(m.name + m.makeNoise());  // furry bay, polimorphic for methods, not vars.
}
}