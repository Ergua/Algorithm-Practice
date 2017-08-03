package ymj;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by FYG on 17/8/2.
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        LinkedList<String> result = new LinkedList<>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int temp = map.get(list2[i]) + i;
                if(temp < sum) {
                    sum = temp;
                    while (!result.isEmpty()) {
                        result.remove();
                    }
                    result.add(list2[i]);
                } else if (temp == sum) {
                    result.add(list2[i]);
                }
            }
        }

        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
