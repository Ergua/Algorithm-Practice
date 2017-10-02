import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();
        String[] num = s.split("\\s+");

        PriorityQueue<Pair> pq = new PriorityQueue<>(num.length, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                int val1 = 0, val2 = 0;
                if (a.str.length() > 3) {
                    String temp = a.str.substring(a.str.length() - 3, a.str.length());
                    val1 = Integer.parseInt(temp);
                } else {
                    val1 = Integer.parseInt(a.str);
                }

                if (b.str.length() > 3) {
                    String temp = b.str.substring(b.str.length() - 3, b.str.length());
                    val2 = Integer.parseInt(temp);
                } else {
                    val2 = Integer.parseInt(b.str);
                }
                if (val1 == val2) {
                    return a.index - b.index;
                } else {
                    return val1 - val2;
                }

            }
        });

        for (int i = 0; i < num.length; i++) {
            pq.offer(new Pair(num[i], i));
        }

        for (int i = 1; i <= n; i++) {
            if (i == n) {
                System.out.println(pq.peek().str);
            }
            pq.poll();
        }
    }
}

class Pair {
    String str;
    int index;
    Pair(String str, int index) {
        this.str = str;
        this.index = index;
    }
}