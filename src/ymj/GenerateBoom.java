package ymj;

import java.util.Random;

/**
 * Created by FYG on 17/8/23.
 */
public class GenerateBoom {
    public int[][] generate(int m, int n) {
        int[][] boom = new int[m][n];
        int[] result = new int[m];
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            result[i] = i;
        }
        for (int i = m - 1; i < m * n; i++) {
            int k = random.nextInt(i + 1);
            if (k < m) {
                result[k] = i;
            }
        }
        for (int i = 0; i < m; i++) {
            int r = result[i] / n;
            int c = result[i] % n;
            boom[r][c] = 1;
        }
        return boom;
    }

    public static void main(String[] args) {
        GenerateBoom test = new GenerateBoom();
        int[][] a = test.generate(5,6);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
}
