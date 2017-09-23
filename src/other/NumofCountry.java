package other;

/**
 * Created by FYG on 17/9/21.
 */
public class NumofCountry {
    public int countNum(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[A.length][A[0].length];
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (!visited[i][j]) {
                    helper(A, visited, i, j, -1, -1);
                    result++;
                }
            }
        }
        return result;
    }

    public void helper(int[][] A, boolean[][] visited, int i, int j, int row, int col) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j]) {
            return;
        }
        if (row != -1 && col != -1) {
            if (A[row][col] != A[i][j]) {
                return;
            }
        }
        visited[i][j] = true;
        helper(A, visited, i + 1, j, i, j);
        helper(A, visited, i - 1, j, i, j);
        helper(A, visited, i, j + 1, i, j);
        helper(A, visited, i, j - 1, i, j);
    }

    public static void main(String[] args) {
        NumofCountry test = new NumofCountry();
        int[][] A = {{5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}};
        System.out.println(test.countNum(A));
    }
}
