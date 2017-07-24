package leetcode;

/**
 * Created by FYG on 17/7/23.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            end++;
            while (sum >= s) {
                minSize = Math.min(minSize, end - start);
                sum -= nums[start];
                start++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String args[]) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(test.minSubArrayLen(7, nums));
    }
}
