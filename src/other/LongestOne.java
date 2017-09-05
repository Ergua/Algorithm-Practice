package other;

import java.util.*;
/**
 * Created by FYG on 17/9/4.
 */
public class LongestOne {
    public int findLongest(int k, String s) {
        ArrayList<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros.add(i);
            }
        }
        int result = 0;
        int ptr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > zeros.get(ptr)) {
                ptr++;
            }
            if (ptr + k < zeros.size()) {
                result = Math.max(result, zeros.get(ptr + k) - i);
            } else {
                result = Math.max(result, s.length() - i);
                break;
            }
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestOne test =  new LongestOne();
        String s = "10010101";
        System.out.println(test.findLongest(0, s));

    }
}
