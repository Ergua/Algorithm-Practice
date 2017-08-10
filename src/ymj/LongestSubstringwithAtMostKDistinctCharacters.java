package ymj;

/**
 * Created by FYG on 17/8/9.
 */

import java.util.HashMap;

/**
 *  Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0, end = 0;
        int count = 0;
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), 1);
                count++;
            } else {
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            }
            end++;
            while (count > k) {
                char c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                    count--;
                }
                start++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
    
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0, end = 0;
        int count = 0;
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), 1);
                count++;
            } else {
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            }
            if (count > k || end == s.length() - 1) {
                if (count > k) {
                    result = end - start > result ? end - start : result;
                } else {
                    result = end - start + 1 > result ? end - start + 1 : result;
                }
                while (count > k && start <= end) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                        count--;
                    }
                    start++;
                }
            }
            end++;
        }
        return result;
    }
}
