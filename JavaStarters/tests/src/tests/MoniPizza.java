package tests;

public class MoniPizza {
	// monitor make_pizza {
	static Integer c[] = new Integer[] {0,0,0,0};

	// make_item(int i){

	public static void main(String[] args) {
		// Процесс i-й работник i = 0,1,2,3; i=3 — соответствует отцу
		// While (1) {
		// make_pizza.make_item(i);
		for (int i = 3; i >= 0; i--) {
			final int j = i;
			Runnable r = new Runnable() {
				@Override	
				public void run() {
					MoniPizza mp=new MoniPizza();
					while (true){	
						mp.make_item_f(j);
						try {
							Thread.sleep(1);
							System.out.println("processed :" + j);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
		
			new Thread(r).start();
		}
	}

	 
	synchronized 
//	static 
	void make_item(int i) {

		// if(i != 0 )c[i-1].wait;
		if (i != 0)
			try {
				c[i - 1].wait();
			} catch (Throwable e) {
				System.err.println(";err wait prev:" + i );
			}

		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// <выполнить свою работу>
		c[i]++;

		System.out.println("element i=" + i + " numbar:" + c[i]);

		// if(i != 3)c[i].signal;
		if (i != 3)
			try {
				c[i].notify();
			} catch (Throwable t){
				System.err.print(";err notify:" + i);
			}
		// else <выставить на продажу>
		else
			System.out.println("pizza ready " + i + " numbar " + c[i]);
	}

    synchronized
   // static 
    void make_item_f(int i) {

		// if(i != 0 )c[i-1].wait;
		if (i != 0)
			try {
				synchronized(c[i-1]){
				c[i - 1].wait();
				System.out.println("wait done:" + i);
				}
			} catch (Throwable e) {
				System.err.println(";err wait prev:" + e );
			}
			
			
		try {
			Thread.sleep((long) (Math.random() *10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// <выполнить свою работу>
		c[i]++;

		System.out.println("element i=" + i + " numbar:" + c[i]);

		// if(i != 3)c[i].signal;
		if (i != 3)
			try {
				synchronized(c[i]) {
				c[i].notifyAll();
			//	System.out.println("notified i=" + i);
				}
			} catch (Throwable t){
				System.err.print(";err notify:" + i);
			}
		// else <выставить на продажу>
		else
			System.out.println("pizza ready " + i + " numbar " + c[i]);
	}
}