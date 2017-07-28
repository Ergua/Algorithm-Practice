package other;

/**
 * Created by FYG on 17/7/28.
 */
public class MyLinkedList<T> {
    private MyNode<T> head = null;
    private MyNode<T> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T node) {
        if (head == null) {
            head = tail = new MyNode(null, node, null);
        } else {
            MyNode temp = new MyNode(null, node, null);
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }

    public void addFirst(T node) {
        if (head == null) {
            head = tail = new MyNode(null, node, null);
        } else {
            MyNode temp = new MyNode(null, node, null);
            temp.setNext(head);
            head.setPrev(temp);
            //System.out.println(temp.getNext().getCur());
            head = temp;
        }
        size++;
    }

    public void addLast(T node) {
        add(node);
    }

    public T removeFirst() {
        if (head == null) return null;
        MyNode temp = head;
        if (temp.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = temp.getNext();
            head.setPrev(null);
        }
        size--;
        return (T)temp.getCur();
    }

    public T removeLast() {
        if (tail == null) return null;
        MyNode temp = tail;
        //MyNode node = head;
        if (temp.getPrev() == null) {
            head = null;
            tail = null;
        } else {
            tail = temp.getPrev();
            tail.setNext(null);
        }
        size--;
        return (T)temp.getCur();
    }

    public T remove(int idx){
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        MyNode node = head;
        if (idx == 0) return removeFirst();
        if (idx == size() - 1) return removeLast();
        for (int i = 0; i < idx; i++) {
            node = node.getNext();
        }
        MyNode prev = node.getPrev();
        MyNode next = node.getNext();
        if (prev != null)
            prev.setNext(next);
        if (next != null)
            next.setPrev(prev);
        size--;
        return (T)node.getCur();
    }

    public void add(int idx, T node) {
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        if (idx == 0) {
            addFirst(node);
            return;
        }
        if (idx == size()) {
            addLast(node);
        }
        MyNode temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.getNext();
        }
        MyNode curNode = new MyNode(null, node, null);
        curNode.setNext(temp);
        curNode.setPrev(temp.getPrev());
        temp.getPrev().setNext(curNode);
        temp.setPrev(curNode);
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyNode node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.getCur());
            sb.append(", ");
            node = node.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.add(1);
        test.add(2);
//        test.removeFirst();
        test.add(3);
        test.add(4);
//        System.out.println(test.removeLast());
        test.addFirst(9);
        test.remove(0);
        test.remove(3);
        test.add(1, 10);
        test.add(1,8);
        test.add(0,7);
        System.out.println(test.toString());
        System.out.println(test.size());
    }
}
