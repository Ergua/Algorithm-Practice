package ymj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mini {
    public int cleverMinister(int numOfMin, int[] efficiency,
                              int[][] voteInFavour)
    {
        // WRITE YOUR CODE HERE
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] vote : voteInFavour) {
            if (!map.containsKey(vote[0])) {
                map.put(vote[0], new ArrayList<>());
            }
            if (!map.containsKey(vote[1])) {
                map.put(vote[1], new ArrayList<>());
            }
            map.get(vote[0]).add(vote[1]);
            map.get(vote[1]).add(vote[0]);
        }

        int result = 0;
        for (int i = 1; i <= numOfMin; i++) {
            int[] temp = new int[efficiency.length];
            for (int j = 0; j < efficiency.length; j++) {
                temp[j] = efficiency[j];
            }
            //System.out.println(temp[0]);
            if (map.containsKey(i)) {
                boolean[] visited = new boolean[efficiency.length];
                visited[i - 1] = true;
                helper(map, temp, i, numOfMin, visited);
            } else {
                continue;
            }
            int val = 0;
            for (int j = 0; j < temp.length; j++) {
                val += temp[j];

            }
            System.out.println(val);
            result = Math.max(result, val);
        }
        return result;
    }

    private void helper(HashMap<Integer, List<Integer>> map, int[] temp, int cur, int numOfMin, boolean[] visited) {
        for (int i = 0; i < map.get(cur).size(); i++) {
            temp[map.get(cur).get(i) - 1] = 0;
        }
        for (int i = 1; i <= numOfMin; i++) {
            if (!visited[i - 1]) {
                if (map.containsKey(i)) {
                    if (temp[i - 1] > 0) {
                        visited[i - 1] = true;
                        helper(map, temp, i, numOfMin, visited);
                    }
                } else {
                    continue;
                }
            }
        }
    }
    public static void main(String[] args) {
        Mini test = new Mini();
        int[] a = {1, 2, 3, 6, 5};
        int[][] b = {{1, 2}, {1, 3}, {2, 4}, {4, 5}};
        System.out.println(test.cleverMinister(4, a, b));
    }
}
