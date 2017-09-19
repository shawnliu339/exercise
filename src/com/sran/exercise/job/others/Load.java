package com.sran.exercise.job.others;

public class Load extends Parent {

	static int a = childPrint();
	int b = childPrint2();

	public static int childPrint() {
		System.out.println("child static" + a);
		return 10;
	};
	
	public int childPrint2() {
		System.out.println("child dynamic b" + this.b);
		return 10;
	}

	Load() {
		System.out.println("child constructor start");
	}

	public static void main(String[] args) {
		Load l = new Load();
		System.out.println(l.a);

	}

}

class Parent {
	static int a = print2();
	int b = print();

	public int print() {
		System.out.println("parent dynamic b:" + this.b);
		return 10;
	};
	
	public static int print2() {
		System.out.println("parent static a:" + a);
		return 10;
	};
	
	Parent() {
		System.out.println("parent constructor start");
	}
}
