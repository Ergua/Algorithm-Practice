package ymj;

import java.util.*;

import basicDataStructure.Intervals;

/**
 * Created by FYG on 17/8/3.
 */
public class BizHours {
    public HashMap<String, ArrayList<Intervals>> BizHours(HashMap<String, ArrayList<Intervals>> map) {
        if (map.isEmpty()) {
            return map;
        }
        for (Map.Entry<String, ArrayList<Intervals>> entry : map.entrySet()) {
            ArrayList<Intervals> intervals = entry.getValue();
            if (intervals.size() == 0) continue;
            Collections.sort(intervals, new Comparator<Intervals>() {
                @Override
                public int compare(Intervals o1, Intervals o2) {
                    return o1.start - o2.start;
                }
            });
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            ArrayList<Intervals> list = new ArrayList<>();
            for (int i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).start) {
                    end = Math.max(end, intervals.get(i).end);
                } else {
                    Intervals temp = new Intervals(start, end);
                    list.add(temp);
                    start = intervals.get(i).start;
                    end = intervals.get(i).end;
                }
            }
            list.add(new Intervals(start, end));
            map.put(entry.getKey(), list);
        }
        return map;
    }

    public static void main(String[] args) {
        BizHours test = new BizHours();
        HashMap<String, ArrayList<Intervals>> map = new HashMap<>();
        ArrayList<Intervals> a = new ArrayList<>();
        a.add(new Intervals(400, 800));
        a.add(new Intervals(100, 300));
        a.add(new Intervals(300, 320));
        a.add(new Intervals(350, 390));
        a.add(new Intervals(440, 1000));
        ArrayList<Intervals> b = new ArrayList<>();
        ArrayList<Intervals> c = new ArrayList<>();
        c.add(new Intervals(200, 800));
        c.add(new Intervals(300, 500));
        c.add(new Intervals(900, 1200));
        map.put("Monday", a);
        map.put("Tuesday", b);
        map.put("Wednesday", c);
        map = test.BizHours(map);
        for (Map.Entry<String, ArrayList<Intervals>> e : map.entrySet()) {
            System.out.println(e.getKey() + e.getValue());
        }
    }
}
