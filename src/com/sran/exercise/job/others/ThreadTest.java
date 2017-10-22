package com.sran.exercise.job.others;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		MyThread t1 = new MyThread();
		Thread thread1 = new Thread(t1);
		
		thread1.start();
		Thread.sleep(2000);
		t1.run1();
	}
	
	

}

class MyThread implements Runnable {
	
	int b = 100;

	@Override
	public void run() {
		try {
			this.run1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void printB() {
		System.out.println(this.b);
	}
	
	public void run1() throws InterruptedException {
		System.out.println("run1-----1");
		
		
		synchronized (this) {
			System.out.println("run1-----02");

			Thread.sleep(5000);
			System.out.println("run1-----2");
		}
	}
	
}
