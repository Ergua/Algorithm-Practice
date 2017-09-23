package other;

/**
 * Created by FYG on 17/9/21.
 */
public class LongestPwd {
    public int findLongest(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int upper = 0;
        int end = 0;
        int start = 0;
        int result = 0;
        while (end < s.length()) {
            while (end < s.length() && (s.charAt(end) < '0' || s.charAt(end) > '9')) {
                if (s.charAt(end) <= 'Z' && s.charAt(end) >= 'A') {
                    upper++;
                }
                end++;
            }
            if (upper > 0) {
                result = Math.max(result, end - start);
            }
            if (end == s.length()) break;
            else {
                end++;
                start = end;
                upper = 0;
            }
        }
        return result == 0 ? -1 : result;
    }

    public static void main(String[] args) {
        LongestPwd test = new LongestPwd();
        System.out.println(test.findLongest("a0Ba"));
    }
}
