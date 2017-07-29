package other;

/**
 * Created by FYG on 17/7/28.
 */
public class POJ1008DP {
    int[] x = {1, 0, -1, 0};
    int[] y = {0, 1, 0, -1};
    public int maxPath(int[][] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[height.length][height[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                result = Math.max(result, searchMax(i, j, dp, height));
            }
        }
        return result + 1;
    }

    public int searchMax(int row, int col, int[][] dp, int[][] height) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        for (int i = 0; i < 4; i++) {
            int dx = x[i] + row;
            int dy = y[i] + col;
            if (dx < 0 || dy < 0 || dx >= dp.length || dy >= dp[0].length) continue;
            if (height[dx][dy] < height[row][col]) {
                dp[row][col] = Math.max(dp[row][col], searchMax(dx, dy, dp, height) + 1);
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        POJ1008DP test = new POJ1008DP();
        int[][] a = {{1,2,3,4,5},
                     {16,17,18,19,6},
                     {15,24,25,20,7},
                     {14,23,22,21,8},
                     {13,12,11,10,9}};
        int[][] b = {{2,1},{1,0}};
        System.out.println(test.maxPath(a));
        System.out.println(test.maxPath(b));
    }
}

//Description
//        Michael喜欢滑雪这并不奇怪， 因为滑雪的确很刺激。可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。Michael想知道在一个区域中最长底滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度。下面是一个例子
//
//        1  2  3  4 5
//        16 17 18 19 6
//        15 24 25 20 7
//        14 23 22 21 8
//        13 12 11 10 9
//
//        一个人可以从某个点滑向上下左右相邻四个点之一，当且仅当高度减小。在上面的例子中，一条可滑行的滑坡为24-17-16-1。当然25-24-23-...-3-2-1更长。事实上，这是最长的一条。
//
//        Input
//        输入的第一行表示区域的行数R和列数C(1 <= R,C <= 100)。下面是R行，每行有C个整数，代表高度h，0<=h<=10000。
//
//        Output
//        输出最长区域的长度。
//
//        Sample Input
//
//        5 5
//        1 2 3 4 5
//        16 17 18 19 6
//        15 24 25 20 7
//        14 23 22 21 8
//        13 12 11 10 9
//
//        Sample Output
//
//        25