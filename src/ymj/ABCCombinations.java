package ymj;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by FYG on 17/8/23.
 */
public class ABCCombinations {
    public List<String> combination(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        helper(result, new StringBuilder(), input);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, String input) {
        if (sb.length() == input.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < 2; j++) {
                if (sb.indexOf(input.charAt(i) + "") != -1 || sb.indexOf((char)(input.charAt(i) + 'A' - 'a') + "") != -1) continue;
                if (j == 0) {
                    sb.append(input.charAt(i));
                    helper(result, sb, input);
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    char temp = (char)(input.charAt(i) + 'A' - 'a');
                    sb.append(temp);
                    helper(result, sb, input);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        ABCCombinations test = new ABCCombinations();
        System.out.println(test.combination("abc"));
    }

}
