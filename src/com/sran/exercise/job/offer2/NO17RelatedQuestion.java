package com.sran.exercise.job.offer2;

public class NO17RelatedQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO17RelatedQuestion o = new NO17RelatedQuestion();
		System.out.println(o.bigNumberAddition("12337888489", "18299474628994"));
	}

	public String bigNumberAddition(String a, String b) {
		StringBuffer buf1 = new StringBuffer(a);
		StringBuffer buf2 = new StringBuffer(b);

		String result = null;
		if (buf1.charAt(0) != '-' && buf2.charAt(0) != '-') {
			result = additionCore(buf1, buf2);
		} else if (buf1.charAt(0) == '-' && buf1.charAt(0) == '-') {
			result = additionCore(buf1, buf2);
		} else {

		}

		return result;
	}

	public String additionCore(StringBuffer buf1, StringBuffer buf2) {

		StringBuffer resultBuf = new StringBuffer();
		int digit1 = buf1.length() - 1;
		int digit2 = buf2.length() - 1;
		boolean isOverFlow = false;
		int carry = 0;
		for (; digit1 >= 0 && digit2 >= 0; digit1--, digit2--) {
			int numOfDigit1 = buf1.charAt(digit1) - '0';
			int numOfDigit2 = buf2.charAt(digit2) - '0';
			if (numOfDigit1 + numOfDigit2 + carry <= 9) {
				resultBuf.insert(0, (char)(numOfDigit1 + numOfDigit2 + carry + '0'));
				carry = 0;
				isOverFlow = false;
			} else {
				resultBuf.insert(0, (char)(numOfDigit1 + numOfDigit2 + carry - 10 + '0'));
				carry = numOfDigit1 + numOfDigit2 + carry - 9;
				isOverFlow = true;
			}
		}
		
		if(digit1<0) {
			digit1 = digit2;
			buf1 = buf2;
		}
		
		while (digit1>=0) {
			int numOfDigit = buf1.charAt(digit1);
			if ((char) (numOfDigit + carry) <= '9') {
				resultBuf.insert(0, (char) (numOfDigit + carry));
				carry = 0;
				isOverFlow = false;
			} else {
				resultBuf.insert(0, (char) (numOfDigit + carry - 10));
				carry = numOfDigit + carry -9 - '0';
				isOverFlow = true;
			}
			digit1--;
		}
		
		if (isOverFlow) {
			resultBuf.insert(0, '1');
		}

		return resultBuf.toString();
	}

	public String subtractionCore(StringBuffer buf1, StringBuffer buf2) {
		return null;
	}

}
