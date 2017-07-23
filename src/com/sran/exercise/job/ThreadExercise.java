package com.sran.exercise.job;

import java.io.UnsupportedEncodingException;

public class ThreadExercise {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/*
		Runner1 runner1 = new Runner1();
		Thread thread = new Thread(runner1);
		thread.start();
		for (int i=0; i<100; i++) {
			System.out.println("main: " + i);
		}*/
		
		String str = "%E4%BB%95%E4%BA%8B%E3%81%AE%E4%BB%95%E6%96%B9".replace("%", "!");
		System.out.println(str);

	}
	


}

class Runner1 implements Runnable {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("runner:" + i);
		}
	}
}
