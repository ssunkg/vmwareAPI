package test;

import java.util.ArrayList;

public class VideoShop {

	private static VideoShop shop = new VideoShop();
	private ArrayList videoList = new ArrayList();
	
	public VideoShop() {
		videoList.add("video1");
	}
	
	public synchronized String rent() {
		Thread t = Thread.currentThread();
		if(videoList.size() == 0){
			System.out.println(t.getName() + " 빌릴수있는 비디오가 없어요");
			try {
				System.out.println("wating.....");
				wait();
				System.out.println("wating end.....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i < videoList.size(); i++) {
			System.out.println(t.getName() + "기다린후 빌릴수있는 비디오 목록 : " + (String)videoList.get(i));
		}
		String rentVideoName =  (String)videoList.get(0);
		videoList.remove(videoList.size() - 1);
		return rentVideoName;
	}
	
	public static VideoShop getInstance() {
		return shop;
	}
	
	public synchronized void returnVideo(String videoName) {
		videoList.add(videoName);
		notify();
	}
}
