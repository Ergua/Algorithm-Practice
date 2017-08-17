package leetcode;
import basicDataStructure.UnionFind;

/**
 * Created by FYG on 17/8/17.
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m, n, grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int p = i * n + j;
                int q;
                if (i > 0 && grid[i - 1][j] == '1') {
                    q = p - n;
                    uf.union(p, q);
                }

                if (i < m - 1 && grid[i + 1][j] == '1') {
                    q = p + n;
                    uf.union(p, q);
                }

                if (j > 0 && grid[i][j - 1] == '1') {
                    q = p - 1;
                    uf.union(p, q);
                }

                if (j < n - 1 && grid[i][j + 1] == '1') {
                    q = p + 1;
                    uf.union(p, q);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] a = {{'1','1','1','0'},
                {'1','0','0','0'},
                {'1','0','1','0'},
                {'0','0','0','1'}};
        NumIslands test = new NumIslands();
        System.out.println(test.numIslands(a));
    }
}
