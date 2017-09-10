package NiuKe;

import java.util.Scanner;

/**
 * Created by FYG on 17/9/10.
 */

public class NonOverlappingXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        int[][] dp = new int[n][n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = num[i];
            if (dp[i][i] == 0 && i == 0) {
                result[i] = 1;
            } else if (dp[i][i] == 0) {
                result[i] = result[i - 1] + 1;
            }
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] ^ num[j];
                if (dp[i][j] == 0) {
                    result[j] = Math.max(result[j], result[i - 1] + 1);
                } else {
                    result[j] = Math.max(result[j], result[j - 1]);
                }
            }
        }

        System.out.println(result[n - 1]);
    }
}