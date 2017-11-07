package com.sran.exercise.job.others;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			out = new FileOutputStream("/Users/SranLiu/Documents/test.dat", true);
			DataOutputStream dataOutput = new DataOutputStream(out);
			dataOutput.writeChars("Liusiyuan ");
			dataOutput.writeUTF("LiuSiyuan ");
			dataOutput.writeInt(1000);
			dataOutput.flush();
			dataOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			in = new FileInputStream("/Users/SranLiu/Documents/test.dat");
			DataInputStream dataInput = new DataInputStream(in);
			char c;
			for(int i=0; i<20; i++) {
				c = dataInput.readChar();
				System.out.print(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件没有找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件读写失败");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("文件关闭失败");
			}
		}

	}

}

class User implements Serializable {
	int id;
	String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printInfo() {
		System.out.println(this.id);
		System.out.println(this.name);
	}

	@Override
	public String toString() {
		this.name = "hack";
		return "User [id=" + id + ", name=" + name + "123]";
	}

}
