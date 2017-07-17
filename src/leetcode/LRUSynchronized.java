package leetcode;

import java.util.HashMap;

public class LRUSynchronized {
	private class Node {
		Node prev;
		Node next;
		int val;
		int key;
		public Node(int key, int val) {
			this.val = val;
			this.key = key;
			this.prev = null;
			this.next = null;
		}
	}


	private int capacity;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);
	public LRUSynchronized(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	private int get(int key) {
		synchronized(this) {
			if (!map.containsKey(key)) {
				return -1;
			}
			Node cur = map.get(key);
			cur.next.prev = cur.prev;
			cur.prev.next = cur.next;
			moveToTail(cur);
			return cur.val;
		}
	}

	private void put(int key, int val) {
		synchronized(this) {
			if (get(key) != -1) {
				map.get(key).val = val;
				Node temp = map.get(key);
				temp.next.prev = temp.prev;
				temp.prev.next = temp.next;
				moveToTail(map.get(key));
				return;
			} else if (map.size() >= capacity) {
				Node cur = head.next;
				map.remove(cur.key);
				head.next = cur.next;
				cur.next.prev = head;
			}
			Node insertNode = new Node(key, val);
			moveToTail(insertNode);
			map.put(key, insertNode);
		}
	}

	private void moveToTail(Node cur) {
		tail.prev.next = cur;
		cur.prev = tail.prev;
		cur.next = tail;
		tail.prev = cur;
	}

	public static void main(String[] args) {
		LRUSynchronized test = new LRUSynchronized(2);
		test.put(1, 1);
		test.put(2, 2);
		System.out.println(test.get(1));
		test.put(3, 3);
		System.out.println(test.get(2));
		System.out.println(test.get(3));
		test.put(1, 1000);
		test.put(4, 4);
		System.out.println(test.get(1));
	}
}

