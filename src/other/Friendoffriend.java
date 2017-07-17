package other;

/**
 * Created by FYG on 17/7/17.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Friendoffriend {
    public List<String[]> findFriend(HashMap<String, ArrayList<String>> relation) {
        List<String[]> result = new ArrayList<>();
        for (String key : relation.keySet()) {
            ArrayList<String> temp = relation.get(key);
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                helper(result, key, temp.get(i), relation);
            }
        }

        if (result.size() >= 2) {
            Collections.sort(result, new Comparator<String[]>() {
                public int compare(String[] a, String[] b) {
                    if (a[0].compareTo(b[0]) == 0) {
                        return a[1].compareTo(b[1]);
                    } else {
                        return a[0].compareTo(b[0]);
                    }
                }
            });

            for (int i = result.size() - 1; i >= 0; i--) {
                if (result.get(i)[0].equals(result.get(i)[1])) {
                    result.remove(i);
                } else if (i != result.size() - 1 && result.get(i + 1)[0].equals(result.get(i)[0])
                        && result.get(i + 1)[1].equals(result.get(i)[1])) {
                    result.remove(i + 1);
                }
            }
        }

        return result;
    }

    private void helper(List<String[]> result, String A, String friend, HashMap<String, ArrayList<String>> relation) {
        if (relation.get(friend) == null) return;
        for (String fOfF : relation.get(friend)) {
            if (A.compareTo(fOfF) < 0 ) {
                result.add(new String[] {A, fOfF});
            } else {
                result.add(new String[] {fOfF, A});
            }

        }
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> relation = new HashMap<>();
        relation.put("A", new ArrayList<String>());
        relation.put("B", new ArrayList<String>());
        relation.put("D", new ArrayList<String>());
        relation.put("C", new ArrayList<String>());
        relation.put("X", new ArrayList<String>());
        relation.put("Y", new ArrayList<String>());
        relation.get("A").add("B");
        relation.get("A").add("C");
        relation.get("A").add("D");
        relation.get("B").add("D");
        relation.get("B").add("E");
        relation.get("D").add("A");
        relation.get("C").add("X");
        relation.get("X").add("Y");
        relation.get("Y").add("A");
        Friendoffriend test = new Friendoffriend();
        List<String[]> result = test.findFriend(relation);
        for (String[] temp : result) {
            System.out.println(temp[0] + "," + temp[1]);
        }
    }
}

