package com.sran.exercise.job.offer;

public class No02Singleton2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private No02Singleton2() {
	}

	private static No02Singleton2 instance = null;
	private static Object lock = new Object();

	/**
	 * 不支持多线程
	 * 
	 * @return
	 */
	public static No02Singleton2 getInstance() {

		if (instance == null) {
			instance = new No02Singleton2();
		}

		return instance;
	}

	/**
	 * 支持多线程，但是效率低，因为无论有没有实例，都先加锁。
	 * @return
	 */
	public static No02Singleton2 getInstance2() {

		synchronized (lock) {
			if (instance == null) {
				instance = new No02Singleton2();
			}
		}

		return instance;
	}
	
	/**
	 * 支持多线程，且加锁前先判断是否有实例
	 * @return
	 */
	public static No02Singleton2 getInstance3() {
		if (instance==null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new No02Singleton2();
				}
			}
		}
		
		return instance;
	}

}
