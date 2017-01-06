package com.sran.exercise.bjsxt;

public class ThreeQuitQuestion {
	
	static public void main (String[] args) {
		
		Circle circle = new Circle(500);
		
		int numCount = 0;
		Kid kid = circle.first;
		while(circle.count > 1) {
			numCount ++;
			if(numCount == 3) {
				circle.delete(kid);
				numCount = 0;
			}
			kid = kid.rightKid;
		}
		
		System.out.println(kid.id);
	}

}

class Kid {
	int id;
	Kid leftKid, rightKid;
	
	public Kid(int id) {
		this.id = id;
	}
}

class Circle {
	
	int count = 0;
	Kid first, last;
	
	public Circle(int count) {
		for (int i=0; i<count; i++) {
			add();
		}
	}
	
	public void add() {
		
		Kid kid = new Kid(count);
		if(count==0) {
			kid.leftKid = kid.rightKid = kid;
			first=last=kid;
		} else {
			kid.leftKid = last;
			kid.rightKid = first;
			last.rightKid = kid;
			first.leftKid = kid;
			last = kid;
		}
		
		count ++;
	}
	
	public void delete(Kid kid) {
		if(count <= 0) {
			return;
		} else if(count == 1) {
			first = last = null;
		} else {
			kid.leftKid.rightKid = kid.rightKid;
			kid.rightKid.leftKid = kid.leftKid;
			
			if (kid == first) {
				first = kid.rightKid;
			} else if (kid == last) {
				last = kid.leftKid;
			}
		}
		
		count --;
	}
}
