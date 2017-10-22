package com.sran.exercise.job;

public class ProducerAndConsumer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Basket basket = new Basket();
		Producer cooker1 = new Producer(basket);
		Producer cooker2 = new Producer(basket);
		Consumer consumer1 =new Consumer(basket);
		
		//创建大师傅线程
		Thread cookerT1 = new Thread(cooker1);
		Thread cookerT2 = new Thread(cooker2);
		//创建吃货线程
		Thread consumerT1 = new Thread(consumer1);
		Thread consumerT2 = new Thread(consumer1);
		
		cookerT1.start();
		cookerT2.start();
		consumerT1.start();
		consumerT2.start();
		
		//每隔一秒检查一次饭桶里的馒头
		while(true) {
			Thread.sleep(1000);
			System.out.println("----------------现在篮子里的面包数量为:" + basket.size());
		}

	}

}

class Bread {
	private int num;

	public Bread(int num) {
		this.num = num;
	}

	public String toString() {
		return num + "";
	}
}

class Basket {
	private Bread[] bread = new Bread[6];
	private int index = 0;

	public synchronized void push(Bread bread) {
		
		while (this.bread.length <= this.index) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.bread[index] = bread;
		this.index++;
		this.notifyAll();
	}
	
	public int size() {
		return this.index;
	}

	public synchronized Bread pop() {
		
		while (this.index <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("现成吃被打断错误");
				e.printStackTrace();
			}
		}
		
		this.notifyAll();
		this.index--;
		return this.bread[index];
	}
}

class Producer implements Runnable {

	private static int num = 1;
	private Basket basket;
	public String name;

	public Producer(Basket basket) {
		this.name = "大师傅" + Producer.num;
		Producer.num++;
		this.basket = basket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5000; i++) {
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bread bread = new Bread(i);
			System.out.println(this.name+"生产了一个面包" + bread.toString());
			this.basket.push(bread);
		}
	}

}

class Consumer implements Runnable {

	Basket basket;

	public Consumer(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		
		for (int i=0; i<5000; i++) {
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bread bread = this.basket.pop();
			System.out.println("客人吃了一个馒头" + bread.toString());
		}
	}

}