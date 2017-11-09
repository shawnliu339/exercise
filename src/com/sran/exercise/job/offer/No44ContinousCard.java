package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No44ContinousCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cards = { 1, 2, 3,0,2 };
		System.out.println(sortCardByHash(cards));
	}

	private static int lengthOfContinousCard = 5;

	public static boolean sortCardByHash(int[] cards) {
		if (cards == null || cards.length < lengthOfContinousCard) {
			return false;
		}

		int[] hashTable = new int[14];
		int greatestCard = 0;
		for (int i = 0; i < cards.length; i++) {
			int num = cards[i];
			hashTable[num]++;
			if (greatestCard < num) {
				greatestCard = num;
			}
		}

		int i = 1;
		for (i = 1; i < hashTable.length && hashTable[i] == 0; i++) {
		}
		
		if (greatestCard - i + hashTable[0] + 1 < lengthOfContinousCard) {
			return false;
		}

		for (; i <= greatestCard; i++) {
			if (hashTable[i] >= 1) {
				continue;
			}

			if (hashTable[i] == 0) {
				hashTable[0]--;
				if (hashTable[0] < 0) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean sortCard(int[] cards) {

		if (cards == null || cards.length <= 0) {
			return false;
		}

		Arrays.sort(cards);
		int numberOfKing = 0;
		for (int i = 0; i < cards.length && cards[i] == 0; i++) {
			numberOfKing++;
		}

		for (int i = numberOfKing + 1; i < cards.length; i++) {
			int diff = cards[i] - cards[i - 1];
			if (diff == 1) {
				continue;
			} else if (diff < 1) {
				return false;
			} else if (diff - 1 > numberOfKing) {
				return false;
			} else {
				numberOfKing -= diff;
			}
		}

		return true;
	}

}
