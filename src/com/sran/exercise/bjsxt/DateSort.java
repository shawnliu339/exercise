package com.sran.exercise.bjsxt;

public class DateSort {

	public static void main(String[] args) {

		Date[] dates = new Date[4];
		dates[0] = new Date(2016, 10, 2);
		dates[1] = new Date(2015, 10, 2);
		dates[2] = new Date(2016, 10, 1);
		dates[3] = new Date(2014, 2, 14);

		bubbleSort(dates);
		print(dates);
		System.out.println(binarySearch(dates,new Date(2016,10,1)));

	}

	public static void print(Date[] dates) {
		for (int i = 0; i < dates.length; i++) {
			System.out.print(dates[i].toString() + " ");
		}
		System.out.println();
	}

	public static void selectSort(Date[] dates) {
		int k;
		Date temp;
		for (int i = 0; i < dates.length - 1; i++) {
			k = i;
			for (int j = k + 1; j < dates.length; j++) {
				if (dates[k].compare(dates[j]) == 1) {
					k = j;
				}
			}
			if (k != i) {
				temp = dates[i];
				dates[i] = dates[k];
				dates[k] = temp;
			}
		}
	}

	/*
	 * 冒泡法小的数字会向上浮，最大的数字会在每次循环中沉到最下端。
	 * 所以，i用于外侧循环。循环且为倒序，起始值为数组长度，
	 * 每次最大的数字会沉到最底部，即每次循环都会排序完毕一个数字，所以外侧循环次数每次都需要减少一次
	 * j用于内侧循环，控制每次的两个数字的比较，由于每次循环都会完成一个数字的排序，所以循环次数为i减1。
	 * 
	 * 所谓冒泡法，每次排序，都要把最小的排在第一个
	 * 
	 */
	public static void bubbleSort(Date[] dates) {
		for (int i = dates.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (dates[j].compare(dates[j + 1]) == 1) {
					Date temp = dates[j];
					dates[j] = dates[j + 1];
					dates[j + 1] = temp;
				}
			}
		}
	}

	public static Integer binarySearch(Date[] dates, Date date) {

		Integer startPos = 0;
		Integer endPos = dates.length;
		Integer middle = (startPos + endPos) / 2;

		while (startPos <= endPos) {

			if (date.compare(dates[middle]) == 1) {
				startPos = middle + 1;
			} else if (date.compare(dates[middle]) == -1) {
				endPos = middle - 1;
			} else {
				return middle;
			}
			middle = (startPos + endPos) / 2;
		}

		return -1;
	}
}

class Date {

	int year, month, day;

	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int compare(Date date) {
		return year > date.year ? 1
				: year < date.year ? -1
						: month > date.month ? 1
								: month < date.month ? -1 : day > date.day ? 1 : day < date.day ? -1 : 0;
	}

	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
