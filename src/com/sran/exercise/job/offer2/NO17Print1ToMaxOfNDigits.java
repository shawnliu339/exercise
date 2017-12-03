package com.sran.exercise.job.offer2;

public class NO17Print1ToMaxOfNDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO17Print1ToMaxOfNDigits o = new NO17Print1ToMaxOfNDigits();
		o.printNumbers(2);
	}

	public void printNumbers(int num) {
		if (num <= 0) {
			return;
		}

		StringBuffer buf = new StringBuffer("0");
		int wrap = 0;
		while (buf.length() <= num) {
			wrap++;
			System.out.print(buf.toString() + ",");
			if (wrap == 10) {
				wrap = 0;
				System.out.println();
			}
			increase(buf);
		}
	}

	public void increase(StringBuffer buf) {

		boolean carry = false;
		for (int i = buf.length() - 1; i >= 0; i--) {
			int digit = buf.charAt(i);
			if ((char) (digit + 1) <= '9') {
				buf.setCharAt(i, (char) (digit + 1));
				carry = false;
				break;
			} else {
				buf.setCharAt(i, '0');
				carry = true;
			}
		}

		if (carry) {
			buf.insert(0, '1');
		}
	}

}
