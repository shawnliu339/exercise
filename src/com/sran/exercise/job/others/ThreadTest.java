package com.sran.exercise.job.others;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new MyThread("t1"));
		Thread thread2 = new Thread(new MyThread("t2"));
		
		thread1.start();
		for(int i=0; i<100; i++) {
			System.out.println("----------main===========" + i);
		}
		thread1.join();
		thread2.start();
	}
	
	

}

class MyThread implements Runnable {
	
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<100; i++) {
			System.out.println(this.name + "----------" + i);
		}
	}
	
}
