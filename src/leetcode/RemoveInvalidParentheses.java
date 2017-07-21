package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FYG on 17/7/20.
 */

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 */

/**
 * 主要的思路就是，每次我发现counter为负了，就说明已经搜过的部分需要删除一个才是对的，
 * 具体删哪个：首先连续相同的不能删，因为会重复。第二，可能有几种删除方法，所以做一个循环找到所有可能。
 * 删掉后recursive去找下一个位置，直到遍历完整个string。然后把String反转，去搜索多余的’（’。
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(result, new char[]{'(', ')'}, 0, 0, s);
        return result;
    }

    private void helper(List<String> result, char[] pare, int lasti, int lastj, String s) {
        int counter = 0;
        for (int i = lasti; i < s.length(); i++) {
            if (s.charAt(i) == pare[0]) counter++;
            if (s.charAt(i) == pare[1]) counter--;
            if (counter >= 0) continue;
            for (int j = lastj; j <= i; j++) {
                if (s.charAt(j) == pare[1] && (j == lastj || s.charAt(j - 1) != pare[1])) {
                    helper(result, pare, i, j, s.substring(0, j) + s.substring(j + 1));
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pare[0] == '(') {
            helper(result, new char[]{')', '('}, 0, 0, reversed);
        } else {
            result.add(reversed);
        }
    }
}
