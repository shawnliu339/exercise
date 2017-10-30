package com.sran.exercise.job.others;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("/Users/SranLiu/Documents/code/The.Mythical.Man.Month.F.Brooks.pdf");
			out = new FileOutputStream("/Users/SranLiu/Documents/code/copy.pdf");
			System.out.println("文件已打开！");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件不存在！");
		}
		
		try {
			int b;
			while ((b=in.read())!=-1) {
				out.write(b);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("文件读写错误");
		}
		
		try {
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println("文件关闭错误");
		}
		System.out.println("文件关闭！");
		
		
		
		
	}
	

}
