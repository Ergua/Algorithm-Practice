package basicDataStructure;

/**
 * Created by FYG on 17/8/17.
 */
public class UnionFind {
    public int count = 0;
    public int[] id = null;
    public UnionFind(int m, int n, char[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') count++;
            }
        }
        id = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) return false;
        else return true;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}
