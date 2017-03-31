package com.sran.exercise.job.offer;

public class No02Singleton {

	//构造方法私有
	private No02Singleton() {
		
	}
	
	//静态成员变量在第一次初始化时被分配空间
	private static No02Singleton instance = new No02Singleton();
	
	public static No02Singleton getInstance() {
		return instance;
	}
	
	public static void main (String arg[]) {
		
		No02Singleton s1 = No02Singleton.getInstance();
		No02Singleton s2 = No02Singleton.getInstance();
		
		System.out.println("s1: " + s1.hashCode());
		System.out.println("s2: " + s2.hashCode());
	}
}
