package com.sran.exercise.job;

public class ThreadExercise {

	public static void main(String[] args) {
		
		Runner1 runner1 = new Runner1();
		Thread thread = new Thread(runner1);
		thread.start();
		for (int i=0; i<100; i++) {
			System.out.println("main: " + i);
		}

	}
	


}

class Runner1 implements Runnable {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("runner:" + i);
		}
	}
}
