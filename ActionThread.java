package test;

public class ActionThread extends Thread{
	
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("스레드 명 : " + t.getName());
		VideoShop shop = VideoShop.getInstance();
		String videoName = shop.rent();
		try {
			System.out.println("스레드 명 : " + t.getName() + " 빌린후 10초간 보는중, 비디오명 : " + videoName);
			Thread.sleep(10000);
			System.out.println("스레드 명 : " + t.getName() + "," + videoName + "비디오 다 봤음,  반납함");
			shop.returnVideo(videoName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
