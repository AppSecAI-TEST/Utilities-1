package java_beans;

public class MainClass {


	public static void main(String[] args) {
		
	    Sender sender_1 = new Sender();
//	    Sender sender_2 = new Sender();

	    Receiver rec_1 = new Receiver();
	    Receiver rec_2 = new Receiver();

	    sender_1.addMyListener(rec_1);
	    sender_1.addMyListener(rec_2);

//	    MyEvent event = new MyEvent("Óğà!");
	    MyEvent event = new MyEvent(sender_1.getClass().getName() + ".sender_1", "Óğà!");
	    sender_1.fireF(event);
	    sender_1.fireG(event);

	    sender_1.removeMyListener(rec_2);
	    sender_1.fireF(event);
	}

}
