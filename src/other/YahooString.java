package other;

/**
 * Created by FYG on 17/7/17.
 */
import java.util.*;

public class YahooString {
    private final String map = "abcdefghijklmnopqrstuvwxyz";
    public String question1(int len) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int num = random.nextInt(34);
            sb.append(num < 26 ? map.charAt(num) : " ");
        }
        return sb.toString();
    }

    public List<String> question2(String s) {
        s = s.trim();
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        String[] temp = s.split(" +");
        for (int i = 0; i < temp.length; i++) {
            if (!hasDuplicate(temp[i])) {
                result.add(temp[i]);
            }
        }
        return result;
    }

    private boolean hasDuplicate(String s) {
        int[] str = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (++str[s.charAt(i) - 'a'] >= 2) {
                return true;
            }
        }
        return false;
    }


    public List<String> question3(String s) {
        s = s.trim();
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        String[] temp = s.split(" +");

        Arrays.sort(temp, new Comparator<String>(){
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });


        int maxTimes = 0;
        int[] count = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (i == j) continue;
                if (contain(temp[i], temp[j])) {
                    count[i]++;
                }
            }
            maxTimes = Math.max(maxTimes, count[i]);
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxTimes) {
                result.add(temp[i]);
            }
        }

        return result;
    }

    private boolean contain(String a, String b) {
        if (a.length() == b.length()) {
            return a.equals(b);
        }
        for (int i = 0; i < a.length() - b.length() + 1; i++) {
            if (a.substring(i, i + b.length()).equals(b)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        YahooString test = new YahooString();
        String s = test.question1(15);
        System.out.println(s);
        List<String> str = test.question2(s);
        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
        System.out.println("-------------------");
        List<String> str2 = test.question3( "yahoo ya yahoo oo asdji");
        for (int i = 0; i < str2.size(); i++) {
            System.out.println(str2.get(i));
        }
    }
}

