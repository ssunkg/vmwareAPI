package test;

public class RentMain {

	
	public static void main(String[] ar) {
		ActionThread at = new ActionThread();
		ActionThread at2 = new ActionThread();
		at.start();
		at2.start();
	}
}
