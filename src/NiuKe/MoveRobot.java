package NiuKe;

import java.util.*;
/**
 * Created by FYG on 17/7/30.
 */
public class MoveRobot {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows == 0 || cols == 0 || !isAccessable(0, 0, threshold)) return 0;
        boolean[][] matrix = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        matrix[0][0] = true;
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result += size;
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (cur.row - 1 >= 0 && !matrix[cur.row - 1][cur.col] && isAccessable(cur.row - 1, cur.col, threshold)) {
                    matrix[cur.row - 1][cur.col] = true;
                    queue.offer(new Pair(cur.row - 1, cur.col));
                }
                if (cur.row + 1 < rows && !matrix[cur.row + 1][cur.col] && isAccessable(cur.row + 1, cur.col, threshold)) {
                    matrix[cur.row + 1][cur.col] = true;
                    queue.offer(new Pair(cur.row + 1, cur.col));
                }
                if (cur.col - 1 >= 0 && !matrix[cur.row][cur.col - 1] && isAccessable(cur.row, cur.col - 1, threshold)) {
                    matrix[cur.row][cur.col - 1] = true;
                    queue.offer(new Pair(cur.row, cur.col - 1));
                }
                if (cur.col + 1 < cols && !matrix[cur.row][cur.col + 1] && isAccessable(cur.row, cur.col + 1, threshold)) {
                    matrix[cur.row][cur.col + 1] = true;
                    queue.offer(new Pair(cur.row, cur.col + 1));
                }
            }
        }
        return result;
    }

    public boolean isAccessable(int row, int col, int threshold) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col != 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= threshold;
    }

    public class Pair{
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
