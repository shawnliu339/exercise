package com.sran.exercise.ir;

import java.util.LinkedList;
import java.util.List;

public class Decode {

	public static void main(String[] args) {
		System.out.println("Variable Byte Code");
		toVariableByteCode();
		System.out.println("Gamma Code");
		toGammaCode();
	}
	
	private static void toGammaCode() {
		String encodedNum = "11111111110000000000111111111011111111";
		
		List<Integer> decodedList = new LinkedList<Integer>();
		while(encodedNum.length() != 0) {
			Integer markIndex = encodedNum.indexOf("0");
			String first = encodedNum.substring(0, markIndex);
			Integer length = first.length();
			encodedNum = encodedNum.substring(markIndex+1);
			String second = encodedNum.substring(0, length);
			if (encodedNum.length() == length)
				encodedNum = "";
			else
				encodedNum = encodedNum.substring(length);
			Integer decodedNum = Integer.parseInt("1"+second, 2);
			decodedList.add(decodedNum);
		}
		System.out.println(decodedList);
	}

	private static void toVariableByteCode () {
		
		String encodedNum = "000001101011100010000101000011010000110010110001";
		String [] encodedNums = new String[encodedNum.length()/8];
		
		for (int i=0; i<encodedNums.length; i++)
			encodedNums[i] = encodedNum.substring(i*8, i*8+8);
		
		Integer decodedNum = 0;
		Integer start = decodedNum;
		List<Integer> decodedList = new LinkedList<Integer>();
		for (int i=0; i<encodedNums.length; i++) {
			
			StringBuffer newNumBuffer = new StringBuffer(encodedNums[i].substring(1));
			while (i<encodedNums.length && encodedNums[i].charAt(0) != '1') {
				newNumBuffer.append(encodedNums[++i].substring(1));
			}
			decodedNum = start + Integer.parseInt(newNumBuffer.toString(), 2);
			start = decodedNum;
			decodedList.add(decodedNum);
			
		}
		
		System.out.println(decodedList);
	}

}
