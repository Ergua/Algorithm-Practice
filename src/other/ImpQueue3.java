package other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ImpQueue3 {
	private int[] queue;
	private int curSize = 0;
	private int size;
	private int head = 0;
	private int tail = 0;
	Lock lock = new ReentrantLock();
	Condition notEmpty = lock.newCondition();
	Condition notFull = lock.newCondition();
	
	public ImpQueue3(int size) {
		queue = new int[size];
		this.size = size;
	}
	
	public void offer(int value){
		lock.lock();
		try {
			while (curSize == size) {
				notFull.await();
			}
			queue[head] = value;
			curSize++;
			System.out.println(Thread.currentThread().getName() + "offer.." + value + "..." + head + "..." + curSize);
			head++;
			if (head == size) {
				head = 0;
			}
			notEmpty.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public int poll(){
		lock.lock();
		int output = 0;
		try {
			while (curSize == 0) {
				notEmpty.await();
			}
			output = queue[tail];
			curSize--;
			System.out.println(Thread.currentThread().getName() + "poll.." + output + "..." + tail+ "..." + curSize);
			tail++;
			if (tail == size) {
				tail = 0;
			}
			notFull.signal();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
		return output;
	}
	
	
	
	public static void main(String[] args) {
		ImpQueue3 qq = new ImpQueue3(3);
		Producer2 producer = new Producer2(qq);
		Consumer2 consumer = new Consumer2(qq);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		Thread t3 = new Thread(producer);
		Thread t4 = new Thread(consumer);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Producer2 implements Runnable {
	private int num = 0;
	private ImpQueue3 q;
	Producer2(ImpQueue3 q) {
		this.q = q;
	}
	public void run() {
		while(true) {
			try{
			q.offer(num++);
			Thread.sleep(3);
			} catch(Exception e) {}
		}
	}
}

class Consumer2 implements Runnable {
	private ImpQueue3 q;
	Consumer2(ImpQueue3 q) {
		this.q = q;
	}
	public void run() {
		while(true) {
			try{
				q.poll();
				Thread.sleep(5);
				} catch(Exception e) {}
		}
	}
}
