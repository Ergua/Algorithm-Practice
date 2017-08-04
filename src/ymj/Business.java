package ymj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by FYG on 17/8/3.
 */
public class Business {
    public ArrayList<BusinessInfo> sortlist(ArrayList<BusinessInfo> list) {
        Collections.sort(list, new Comparator<BusinessInfo>() {
            public int compare(BusinessInfo a, BusinessInfo b) {
                return b.rating - a.rating;
            }
        });
        return list;
    }

    public ArrayList<BusinessInfo> sortlist2(ArrayList<BusinessInfo> list) {
        Collections.sort(list, (a, b) -> (a.rating == b.rating ? a.id - b.id : b.rating - a.rating));
        return list;
    }

    public static void main(String[] args) {
        Business test = new Business();
        ArrayList<BusinessInfo> a = new ArrayList<>();
        a.add(new BusinessInfo(95, 2));
        a.add(new BusinessInfo(95, 1));
        a.add(new BusinessInfo(100,32));
        System.out.println(test.sortlist(a));
        System.out.println(test.sortlist2(a));
    }
}
