package com.sran.exercise.job;

import java.util.Arrays;

public class Test {

	Test1 test1 = new Test1("test, but out of constructor");
	
	static {
		System.out.println("class is loaded");
	}

	public Test() {
		this.test1 = new Test1("test");
		
	}

	public static void main(String[] args) {
	}

}

class Test1 {
	public Test1(String str) {
		System.out.println("new a test1 in " + str);
	}
}