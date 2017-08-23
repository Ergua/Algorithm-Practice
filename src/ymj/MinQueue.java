package ymj;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by FYG on 17/8/19.
 */
public class MinQueue {
    Queue<Integer> queue;
    PriorityQueue<Integer> pq;
    public MinQueue (){
        queue = new LinkedList<>();
        pq = new PriorityQueue<>();
    }

    public void enqueue(int num) {
        queue.offer(num);
        pq.offer(num);
    }

    public int dequeue() {
        Integer num = queue.poll();
        pq.remove(num);
        return num;
    }

    public int findMin() {
        return pq.peek();
    }

    public static void main(String[] args) {
        MinQueue test = new MinQueue();
        test.enqueue(2);
        test.enqueue(5);
        System.out.println(test.findMin());
        test.enqueue(2);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.findMin());
    }
}
