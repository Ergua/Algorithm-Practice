package ymj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by FYG on 17/8/5.
 */
public class ChooseRestaurant {
    public String chooseRestaurant(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0) {
            return "Yelpwich";
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), i + 1);
        }
        int min = Integer.MAX_VALUE;
        String result = "Yelpwich";
        for (int i = 0; i < list2.size(); i++) {
            if (map.containsKey(list2.get(i))) {
                if (min > map.get(list2.get(i)) + i + 1) {
                    min = map.get(list2.get(i)) + i + 1;
                    result = list2.get(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ChooseRestaurant test = new ChooseRestaurant();
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        a.add("BB");
        a.add("C");
        ArrayList<String> b = new ArrayList<>();
        b.add("X");
        b.add("B");
        b.add("CC");
        System.out.println(test.chooseRestaurant(a,b));
    }
}
