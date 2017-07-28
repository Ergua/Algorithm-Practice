package other;

import java.util.ArrayList;

/**
 * Created by FYG on 17/7/24.
 */
public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int curSize;
    private T[] list;

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        curSize = 0;
    }

    public int size() {
        return curSize;
    }

    public boolean add(T element) {
        add(size(), element);
        return true;
    }

    public void add(int idx, T element) {
        if (size() == list.length) {
            ensureCapacity(size() + (size() >> 1));
        }
        for (int i = curSize; i > idx; i--) {
            list[i] = list[i - 1];
        }
        list[idx] = element;
        curSize++;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < curSize) {
            return;
        }
        T[] old = list;
        list = (T[]) new Object[newCapacity];
        for (int i = 0; i < old.length; i++) {
            list[i] = old[i];
        }
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            return null;
        } else {
            return list[idx];
        }
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size()) {
            return null;
        } else {
            T element = list[idx];
            for (int i = idx; i < size() - 1; i++) {
                list[i] = list[i + 1];
            }
            curSize--;
            return element;
        }
    }

    public T set(int idx, T element) {
        if (idx < 0 || idx >= size()) {
            return null;
        } else {
            list[idx] = element;
        }
        return element;
    }


    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        test.add(2);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(2);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(2,10000);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        System.out.println(test.size());

    }
}
