package NiuKe;

/**
 * Created by FYG on 17/9/5.
 */
public class LongestCommonSub {
    public int longest(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = 0;
        }

        int result = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonSub test = new LongestCommonSub();
        System.out.println(test.longest("ansfis", "ansfsdfa"));
    }
}
