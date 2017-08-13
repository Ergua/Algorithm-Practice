package NiuKe;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by FYG on 17/8/12.
 */
public class DuiQiZi {
    public int[] minMove(int[] x, int[] y, int n) {
        if (x == null || x.length == 0 || y == null || y.length == 0) {
            return new int[]{};
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int sum = 0;
                    PriorityQueue<Integer> pq = new PriorityQueue<>(n, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });
                    for (int cur = 0; cur < n; cur++) {
                        int distance = Math.abs(x[row] - x[cur]) + Math.abs(y[col] - y[cur]);
                        sum += distance;
                        pq.add(distance);
                        if (pq.size() - 1 > i) {
                            sum -= pq.poll();
                        }
                    }
                    min = Math.min(min, sum);
                }
            }
            res[i] = min;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }

        DuiQiZi test = new DuiQiZi();
        int[] res = test.minMove(x, y, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append((res[i]) + " ");
        System.out.println(sb.toString().trim());
    }
}
