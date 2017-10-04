package other;
import java.util.*;

/**
 * Created by FYG on 17/10/2.
 */
public class Ibmmianjing4 {
    public String solution(String[] relation, String p1, String p2) {
        HashMap<String, String> map = new HashMap<>();
        for (String s : relation) {
            String[] temp = s.split("->");
            map.put(temp[1], temp[0]);
        }
        HashSet<String> set = new HashSet<>();
        String temp = p1;
        while (map.containsKey(temp)) {
            if (map.get(temp).equals(p2)) {
                return map.get(p2);
            }
            set.add(map.get(temp));
            temp = map.get(temp);
        }
        temp = p2;
        while (map.containsKey(temp)) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = map.get(temp);
        }
        return "";
    }

    public static void main(String[] args) {
        Ibmmianjing4 test = new Ibmmianjing4();
        String[] s = {"Tom->Mary", "Mary->Bob", "Mary->Sam", "Bob->John", "Sam->Pete", "Sam->Katie"};
        System.out.println(test.solution(s, "Bob", "Pete"));
    }
}
