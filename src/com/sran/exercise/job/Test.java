package com.sran.exercise.job;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new A();
		B.printName();
	}

}

class A {
	{
		System.out.println("I am A!");
	}
}

class B {
	{
		System.out.println("I am B!");
	}
	
	static public void printName() {
		System.out.println("print name B");
	}
}
