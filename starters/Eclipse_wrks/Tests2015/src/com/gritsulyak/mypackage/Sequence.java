package com.gritsulyak.mypackage;

public class Sequence {
	Sequence() { System.out.print("c "); }
	{ System.out.print("y "); }
	public static void main(String[] args) {
	System.out.print("m ");
	new Sequence().go();
	}
	void go() { System.out.print("g "); }
	static { System.out.print("x "); }
	}
	
class TestServer {
		int count = 9; // Declare an instance variable named count
		public void logIn() {
		int count = 10; // Declare a local variable named count
		System.out.println("no local variable count is " + this.count);
		}
		public void count() {
		System.out.println("instance variable count is " + count);
		}
		public static void main(String[] args) {
		new TestServer().logIn();
		new TestServer().count();
		}
}