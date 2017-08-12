package NiuKe;

/**
 * Created by FYG on 17/8/11.
 */
import java.util.*;

public class MultMax{
    public long findMax(int[] input, int k, int d) {
        int n = input.length;
        long[][] max = new long[k][n];
        long[][] min = new long[k][n];

        for (int i = 0; i < n; i++) {
            max[0][i] = input[i];
            min[0][i] = input[i];

        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = d; m > 0; m--) {
                    if (j - m >= 0) {
                        max[i][j] = Math.max(max[i][j], Math.max(input[j] * max[i - 1][j - m], input[j] * min[i - 1][j - m]));
                        min[i][j] = Math.min(min[i][j], Math.min(input[j] * max[i - 1][j - m], input[j] * min[i - 1][j - m]));
                    }
                }
            }
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, max[k - 1][i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        MultMax test = new MultMax();
        System.out.println(test.findMax(input, k, d));
    }
}