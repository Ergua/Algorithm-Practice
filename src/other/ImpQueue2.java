package other;

public class ImpQueue2 {
	private int[] queue;
	private int curSize = 0;
	private int size;
	private int head = 0;
	private int tail = 0;
	
	public ImpQueue2(int size) {
		queue = new int[size];
		this.size = size;
	}
	
	public void offer(int value){
		synchronized(this) {
			while (curSize == size) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					
				}
			}
			queue[head] = value;
			curSize++;
			System.out.println(Thread.currentThread().getName() + "offer.." + value + "..." + head + "..." + curSize);
			head++;
			if (head == size) {
				head = 0;
			}
			notifyAll();
		}
	}
	
	public int poll(){
		synchronized (this) {
			while (curSize == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					
				}
			}
			int output = queue[tail];
			curSize--;
			System.out.println(Thread.currentThread().getName() + "poll.." + output + "..." + tail+ "..." + curSize);
			tail++;
			if (tail == size) {
				tail = 0;
			}
			notifyAll();
			return output;
		}
	}
	
	
	
	public static void main(String[] args) {
		ImpQueue2 qq = new ImpQueue2(3);
		Producer producer = new Producer(qq);
		Consumer consumer = new Consumer(qq);
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

class Producer implements Runnable {
	private int num = 0;
	private ImpQueue2 q;
	Producer(ImpQueue2 q) {
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

class Consumer implements Runnable {
	private ImpQueue2 q;
	Consumer(ImpQueue2 q) {
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
