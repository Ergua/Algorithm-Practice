package NiuKe;

import java.util.Scanner;

/**
 * Created by FYG on 17/9/13.
 */
public class TuanjianHuodong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }

        int[] maxA = new int[n + 5];

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) maxA[i] = height[i];
            else {
                maxA[i] = Math.max(height[i] + Math.min(maxA[i + 2], maxA[i + 3]),
                        height[i] + height[i + 1] + Math.min(maxA[i + 3], maxA[i + 4]));
            }
        }

        if (maxA[0] > sum - maxA[0]) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
