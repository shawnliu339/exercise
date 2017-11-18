package com.sran.exercise.job.offer;

public class No02Singleton2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		No02Singleton2 instance1 = getInstance4();
		System.out.println("1: " + instance1);

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("-----thread-----");
				No02Singleton2 instance3 = No02Singleton2.getInstance4();
				System.out.println("thread: " + instance3);
			}
		});
		thread.run();

		No02Singleton2 instance2 = getInstance4();
		System.out.println("2: " + instance2);
		System.out.println("2: " + (instance1 == instance2));
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
	 * 
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
	 * 
	 * @return
	 */
	public static No02Singleton2 getInstance3() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new No02Singleton2();
				}
			}
		}

		return instance;
	}

	/**
	 * 通过静态内部类，按需配给
	 * 
	 * @return
	 */
	public static No02Singleton2 getInstance4() {
		return Nested.instance;
	}

	static class Nested {
		static {
			System.out.println("nested is loaded");
		}
		public static No02Singleton2 instance = new No02Singleton2();
	}

}
