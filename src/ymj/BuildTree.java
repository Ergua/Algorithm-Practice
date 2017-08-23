package ymj;

import java.util.*;

/**
 * Created by FYG on 17/8/22.
 */
public class BuildTree {
    class Node {
        String name;
        List<Node> child = new ArrayList<>();
        Node parent;
        Node (String name) {
            this.name = name;
        }
    }

    public Node build(List<String[]> input) {
        HashMap<String, Node> map = new HashMap<>();
        HashSet<Node> set = new HashSet<>();
        for (String[] pair : input) {
            Node child;
            Node parent;
            if (map.containsKey(pair[0])) {
                parent = map.get(pair[0]);
            } else {
                parent = new Node(pair[0]);
                map.put(pair[0], parent);
                set.add(parent);
            }
            if (map.containsKey(pair[1])) {
                child = map.get(pair[1]);

            } else {
                child = new Node(pair[1]);
                map.put(pair[1], child);
            }
            child.parent = parent;
            if (set.contains(child)) {
                set.remove(child);
            }
            parent.child.add(child);
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        BuildTree test = new BuildTree();
        List<String[]> a = new ArrayList<>();
        a.add(new String[] {"B", "A"});
        a.add(new String[] {"B", "D"});
        a.add(new String[] {"C", "B"});
        System.out.println(test.build(a).child.get(0).child.get(1).name);
    }
}
