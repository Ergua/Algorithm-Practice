package other;

import java.util.*;

/**
 * Created by FYG on 17/9/4.
 */
public class PickApple {
    class Node {
        int val;
        ArrayList<Node> child = new ArrayList<>();
        Node(int val) {
            this.val = val;
        }
    }

    private int result = 0;

    public int pick(int[][] input) {
        HashSet<Integer> root = new HashSet<>();
        HashMap<Integer, Node> map = new HashMap<>();
        for (int[] in : input) {
            root.add(in[0]);
        }
        for (int[] in : input) {
            if (!map.containsKey(in[0])) {
                map.put(in[0], new Node(in[0]));
            }
            if (!map.containsKey(in[1])) {
                map.put(in[1], new Node(in[1]));
            }
            Node parent = map.get(in[0]);
            Node child = map.get(in[1]);
            if (root.contains(child.val)) {
                root.remove(child.val);
            }
            if (!parent.child.contains(child)) {
                parent.child.add(child);
            }
        }

        for (int cur : root) {
            //System.out.println(cur);
            result = Math.max(findMax(map.get(cur)), result);
        }
        return result;
    }

    private int findMax(Node root) {
        if (root.child.size() == 0) {
            return 1;
        }
        int depth1 = 0;
        int depth2 = 0;
        for (Node node : root.child) {
            int temp = findMax(node);
            //System.out.println(node.val + " " + temp);
            if (temp > depth1) {
                depth2 = depth1;
                depth1 = temp;
            } else if (temp > depth2) {
                depth2 = temp;
            }
        }
        result = Math.max(depth1 + depth2, result);
        //System.out.println(result);
        return depth1 + 1;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {1, 3}, {1, 4}, {0, 1}, {0, 8}, {2, 6}, {4, 9}, {9, 10}, {6, 11}};
        PickApple test = new PickApple();
        System.out.println(test.pick(input));
    }
}
