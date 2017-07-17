package other;


public class ImpQueue {
	private int[] queue;
	private int curSize = 0;
	private int size;
	private int head = 0;
	private int tail = 0;
	
	public ImpQueue(int size) {
		queue = new int[size];
		this.size = size;
	}
	
	public void offer(int value) throws Exception {
		synchronized(this) {
			if (curSize != size) {
				queue[head] = value;
				curSize++;
				head++;
				if (head == size) {
					head = 0;
				}
				return;
			}
			throw new Exception("Queue is full");
		}
	}
	
	public int poll() throws Exception{
		synchronized (this) {
			if (curSize != 0) {
				int output = queue[tail];
				curSize--;
				Thread.sleep(100);
				tail++;
				if (tail == size) {
					tail = 0;
				}
				return output;
			}
			throw new Exception("Queue is empty");
		}
	}
	
//	public static void main(String[] args) {
//		ImpQueue test = new ImpQueue(3);
//		try {
//			test.offer(1);
//			test.offer(2);
//			System.out.println(test.poll());
//			System.out.println(test.poll());
//			test.offer(3);
//			test.offer(4);
//			System.out.println(test.poll());
//			System.out.println(test.poll());
//			System.out.println(test.poll());
//			test.offer(6);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//	}
	public static void main(String[] args) {
		ImpQueue queue = new ImpQueue(30);
		try{
			queue.offer(1);
			queue.offer(2);
			queue.offer(3);
			queue.offer(4);
			queue.offer(5);
			queue.offer(6);
			queue.offer(7);
			queue.offer(8);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		Test aTest = new Test(queue);
		Thread t1 = new Thread(aTest);
		Thread t2 = new Thread(aTest);
		
		t1.start();
		t2.start();
	}
}


class Test implements Runnable {
	private ImpQueue queue;
	Test(ImpQueue queue) {
		this.queue = queue;
	}
	
	public void run() {
		try {
			//queue.offer(10000);
			for (int i = 0; i < 6; i++)
				System.out.println(queue.poll());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}


