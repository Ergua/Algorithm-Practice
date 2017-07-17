package leetcode;

import java.util.HashMap;

public class LFUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, Integer> valueMap = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        increaseCount(key);
        return map.get(key).val;
    }
    
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            map.get(key).val = value;
            increaseCount(key);
        } else {
            if (map.size() == capacity) {
                map.remove(head.next.key);
                valueMap.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            valueMap.put(key, 1);
            addToHead(newNode);
        }
    }
    
    private void increaseCount(int key) {
        Node node = map.get(key);
        valueMap.put(key, valueMap.get(node.key) + 1);
        Node cur = node.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        while(cur.next != tail && valueMap.get(cur.next.key) <= valueMap.get(key)) {
            cur = cur.next;
        }
        cur.next.prev = node;
        node.next = cur.next;
        cur.next = node;
        node.prev = cur;
    }
    
    private void addToHead(Node newNode) {
        Node temp = head;
        while (temp.next != tail && valueMap.get(temp.next.key) <= 1) {
            temp = temp.next;
        }
        temp.next.prev = newNode;
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
