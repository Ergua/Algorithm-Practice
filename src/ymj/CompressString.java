package ymj;

/**
 * Created by FYG on 17/8/1.
 */
public class CompressString {
    public String compressString(String s) {
        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        while (end < s.length()) {
            char cur = s.charAt(start);
            while (end < s.length() && s.charAt(end) == cur) {
                end++;
            }
            sb.append(end - start);
            sb.append(s.charAt(start));
            start = end;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CompressString test = new CompressString();
        System.out.println(test.compressString("aaabbbbaccc"));
    }
}
