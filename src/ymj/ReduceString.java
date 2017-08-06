package ymj;

import java.util.Scanner;

/**
 * Created by FYG on 17/8/5.
 */
public class ReduceString {
    public String reduceString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 1;
        StringBuilder sb = new StringBuilder();
        while (end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                end++;
            } else {
                sb.append(s.charAt(start));
                start = end;
                end++;
            }
        }
        sb.append(s.charAt(start));
        return sb.toString();
    }

    public static void main(String[] args) {
        ReduceString test = new ReduceString();
        System.out.println("input:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(test.reduceString(s));
    }
}
