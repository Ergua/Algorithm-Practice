package other;

import java.util.*;

/**
 * Created by FYG on 17/8/29.
 */
public class PowerNumbers {
    public int nthPowerNumbers(int n) {
        int[] power = new int[n + 1];
        List<Integer> ptrs = new ArrayList<>();
        List<Integer> base = new ArrayList<>();
        ptrs.add(2);
        base.add(2);
        for (int i = 0; i < n + 1; i++) {
            power[i] = Integer.MAX_VALUE;
            for (int j = 0; j < ptrs.size(); j++) {
                power[i] = Math.min(power[i], (int) Math.pow(base.get(j), ptrs.get(j)));
            }

            for (int j = 0; j < ptrs.size(); j++) {
                if (power[i] == (int) Math.pow(base.get(j), ptrs.get(j))) {
                    ptrs.set(j, ptrs.get(j) + 1);
                }
            }
            if (ptrs.get(ptrs.size() - 1) > 2) {
                base.add(base.get(base.size() - 1) + 1);
                ptrs.add(2);
            }
        }
        return power[n];
    }

    public int nthPowerNumbers2(int n) {
        int power = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 2; i < n + 2; i++) {
            pq.offer(new Node(i, 2));
        }

        int result = 0;
        int prev = 0;
        while (n >= 0) {
            Node cur = pq.poll();
            result = cur.value;
            if (prev != result) {
                n--;
            }
            pq.offer(new Node(cur.base, cur.exp + 1));
            prev = result;
        }
        return result;
    }

    public static void main(String[] args) {
        PowerNumbers test = new PowerNumbers();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(test.nthPowerNumbers(num));
        System.out.println(test.nthPowerNumbers2(num));
    }

    class Node {
        int base;
        int value;
        int exp;
        Node(int base, int exp) {
            this.base = base;
            this.exp = exp;
            this.value = (int) Math.pow(base, exp);
        }
    }
}
