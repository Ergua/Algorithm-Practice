package other;

import java.util.*;

/**
 * Created by FYG on 17/10/2.
 */
public class Ibmmianjing {
    public String[] solution(String[] in) {
        HashMap<String, ArrayList<String[]>> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            String[] temp = in[i].split(",");
            if (!map.containsKey(temp[0])) {
                map.put(temp[0], new ArrayList<String[]>());
            }
            map.get(temp[0]).add(temp);
        }

        String[] result = new String[map.size()];
        int num = 0;
        for (Map.Entry<String, ArrayList<String[]>> entry : map.entrySet()) {
            ArrayList<String[]> list = entry.getValue();
            if (list.size() > 1) {
                int totalNum = 0;
                HashMap<String, Integer> count = new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    if (!count.containsKey(list.get(i)[2])) {
                        count.put(list.get(i)[2], 0);
                    }
                    count.put(list.get(i)[2], count.get(list.get(i)[2]) + Integer.parseInt(list.get(i)[1]));
                    totalNum += Integer.parseInt(list.get(i)[1]);
                }
                double avg = (double)totalNum / count.size();
                result[num] = entry.getKey() + "," + totalNum + "," + String.format("%.2f", avg) + "," + count.size();
            } else {
                result[num] = entry.getKey() + "," + list.get(0)[1] + "," + String.format("%.2f", Double.parseDouble(list.get(0)[1])) + "," + "1";
            }
            num++;
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Ibmmianjing test = new Ibmmianjing();
        String[] in = {"2017-06-02,5,apples", "2017-06-03,3,pineapples", "2017-06-02,2,pears"};//{"2016-04-03,2,apples", "2016-04-12,2,peaches", "2016-04-03,2,apples"};
        for (String s : test.solution(in))
            System.out.println(s);
    }
}
