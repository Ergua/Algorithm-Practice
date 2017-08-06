package ymj;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by FYG on 17/8/3.
 */
public class RestaurantPreference {
    public String findBest(ArrayList<BusinessInfo> list1, ArrayList<BusinessInfo> list2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i).id, list1.get(i).rating);
        }
        int max = -1;
        BusinessInfo result = null;
        for (int i = 0; i < list2.size(); i++) {
            if (map.containsKey(list2.get(i).id)) {
                max = max > (list2.get(i).rating + map.get(list2.get(i).id)) ? max : list2.get(i).rating + map.get(list2.get(i).id);
                result = list2.get(i);
            }
        }
        return result == null ? "yelpwich" : result.toString();
    }

    public static void main(String[] args) {
        RestaurantPreference test = new RestaurantPreference();
        ArrayList<BusinessInfo> a = new ArrayList<>();
        a.add(new BusinessInfo(95, 9));
        a.add(new BusinessInfo(95, 1));
        a.add(new BusinessInfo(100,32));
        ArrayList<BusinessInfo> b = new ArrayList<>();
        b.add(new BusinessInfo(95, 2));
        b.add(new BusinessInfo(95, 3));
        b.add(new BusinessInfo(100,0));
        System.out.println(test.findBest(a, b));
    }
}
